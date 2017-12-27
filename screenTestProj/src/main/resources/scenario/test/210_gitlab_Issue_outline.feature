@project
Feature: gitlabでのissues管理を行いたい。
 操作者は、gitlabでのissues管理をするために、issue作成を行う必要がある。

@good
Scenario Outline: issue連続作成
 Given "http://gitlab/" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること

  When "test / my-awesome-project" リンクをクリックする
  Then "test / my-awesome-project · GitLab" ページであること

  When "Issues" をクリックする
   And "Create Issue" をクリックする
   And "Title" に <IssueTitle> を入力する
   And "Description" に以下を入力する:
       """
       <IssueDescription>
       """
   And "Due Date" に <Due Date> を入力する

   And "Submit issue" をクリックする
   And <ScreenShotName> スクリーンショットをとる

 Examples:
   #csv://data.csv
   |IssueTitle  |IssueDescription|Due Date     |ScreenShotName             |
   |"a"|てすと１|"2018-01-01"|"d"|
   |"b"|てすと２|"2018-01-01"|"d"|
   |"c"|てすと３|"2018-01-01"|"d"|
   |"d"|てすと４|"2018-01-01"|"d"|
   |"e"|てすと５|"2018-01-01"|"d"|
