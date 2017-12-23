package scenario.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import com.opencsv.CSVReader;

public class CucumberFeatureComverter {
    private File inputPath  = new File(".");
    private File outputPath = new File(".");
    private File dataPath   = null;

    public static void main(String[] args) {

        CucumberFeatureComverter converter = new CucumberFeatureComverter();

        if (args.length>0)
            converter.setInputPath(new File(args[0]));
        if (args.length>1)
            converter.setOutputPath(new File(args[1]));
        if (args.length>2)
            converter.setDataPath(new File(args[2]));

        converter.searchFeatureAndConvert();
    }

    public void searchFeatureAndConvert() {
        searchFeatureAndConvert(getInputPath(), getOutputPath());
    }

    public void searchFeatureAndConvert(File inFeaturePath,File outFeatruePath) {
        for (File file: inFeaturePath.listFiles()) {
            if (file.getAbsolutePath().endsWith(".feature")) {
                outFeatruePath.mkdirs();
                convertFeature(file,  new File(outFeatruePath.getAbsolutePath()+File.separator+file.getName()));
            }else if (file.isDirectory()) {
                searchFeatureAndConvert(file,  new File(outFeatruePath.getAbsolutePath()+File.separator+file.getName()));
            }
        }
    }

    public void convertFeature(File inFeatureFile,File outFeatureFile) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(inFeatureFile));
              FileWriter writer = new FileWriter(outFeatureFile); ){
            boolean skip = false;
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.trim().startsWith("#csv://")) {
                    writer.write(line + "\n");
                    String filepath = line.trim().replaceFirst("#csv://", "");
                    File dataFile = searchData(getDataPath(),filepath);
                    if ( dataFile == null ) {
                        throw new RuntimeException("No Such File:" + filepath);
                    }
                    readCsv(dataFile, writer);
                    skip = true;
                } else if (skip) {
                    if (! line.trim().startsWith("|")) {
                        writer.write(line + "\n");
                        skip = false;
                    }
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File searchData(File dataPath,String dataFilePath) {
        if (dataPath == null) {
            return new File(dataFilePath);
        }
        for (File file: dataPath.listFiles()) {
            if (file.getAbsolutePath().replaceAll("\\\\","/").endsWith(dataFilePath.replaceAll("\\\\","/"))) {
                return file;
            }else if (file.isDirectory()) {
                File ret = searchData(file, dataFilePath);
                if (ret != null) {
                    return ret;
                }
            }
        }
        return null;
    }

    public void readCsv(File filepath,Writer writer) {
        try ( CSVReader reader = new CSVReader(new FileReader(filepath)); ) {
            for (String[] line : reader.readAll()) {
                StringBuffer sb = new StringBuffer();
                for (String value : line) {
                    sb.append("|");
                    sb.append(value);
                }
                if (line.length > 0) {
                    sb.append("|\n");
                    writer.write(sb.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File getInputPath() {
        return inputPath;
    }

    public void setInputPath(File inputPath) {
        this.inputPath = inputPath;
    }

    public File getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(File outputPath) {
        this.outputPath = outputPath;
    }

    public File getDataPath() {
        return dataPath;
    }

    public void setDataPath(File dataPath) {
        this.dataPath = dataPath;
    }


}
