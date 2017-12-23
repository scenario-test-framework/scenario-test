package scenario.test;
import java.io.File;

import org.junit.Test;

public class converterTest {

    @Test
    public void convert() throws Exception {
        File inFeatureFile = new File("src/test");
        File outFeatureFile = new File("target");

        CucumberFeatureComverter.main(new String[] {inFeatureFile.getAbsolutePath(), outFeatureFile.getAbsolutePath()});

    }

}
