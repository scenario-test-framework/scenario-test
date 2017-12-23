
■selenium grid環境、実行環境作成・起動

1. selenium grid環境、実行環境イメージ作成

  sudo docker-compose -f runtile_env/docker-compose.yml build

2. selenium grid環境、実行環境起動

  sudo docker-compose -f runtime_env/docker-compose.yml up -d

  ※ http://{ip}:4444/ で状態確認  
  ※ 内部で runtimeenv_test_bridgeネットワークを作成

■selenide+cucumberテスト実行  
※selenium grid/テスト対象サービスは起動していること

1. 実行環境dockerイメージ作成

  sudo docker-compose build

2. src内のソースをビルド(jdk/maven)

  cd screenTestProj
  ./build.sh

3. src内のソースをもとにテスト実行

  sudo docker-compose up

■selenium grid環境を停止する場合

1. sudo docker-compose -f runtime_env/docker-compose.yml down

------------

■feature内の表部分の外部ファイル化  
cd cucumber-feature-converter  
java -cp ./target/cucumber-feature-converter-0.0.1-SNAPSHOT-jar-with-dependencies.jar scenario.test.CucumberFeatureComverter src/test/resources /tmp

1. これが

[210_gitlab_Issue_outline.feature]  
 Examples:  
   #csv://src/test/resources/data2.csv  
   ||  

[data2.csv]  
 aaa,IssueTitle,IssueDescription,Due Date,ScreenShotName  
 aaa,"""テスト１１""",説明１,"""2018-01-01""","""210_010_issue_submeitted"""  
 aaa,"""テスト１２""",説明２,"""2018-01-02""","""210_020_issue_submeitted"""  
 aaa,"""テスト１３""",説明３,"""2018-01-03""","""210_030_issue_submeitted"""  
 aaa,"""テスト１４""",説明４,"""2018-01-04""","""210_040_issue_submeitted"""  
 aaa,"""テスト１５""",説明５,"""2018-01-05""","""210_050_issue_submeitted"""  

2. こうなります

[210_gitlab_Issue_outline.feature]  
 Examples:  
   #csv://src/test/resources/data2.csv  
|aaa|IssueTitle|IssueDescription|Due Date|ScreenShotName|  
|aaa|"テスト１１"|説明１|"2018-01-01"|"210_010_issue_submeitted"|  
|aaa|"テスト１２"|説明２|"2018-01-02"|"210_020_issue_submeitted"|  
|aaa|"テスト１３"|説明３|"2018-01-03"|"210_030_issue_submeitted"|  
|aaa|"テスト１４"|説明４|"2018-01-04"|"210_040_issue_submeitted"|  
|aaa|"テスト１５"|説明５|"2018-01-05"|"210_050_issue_submeitted"|  

