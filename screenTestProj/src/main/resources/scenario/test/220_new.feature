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
   #csv://src/test/resources/data.csv
|IssueTitle|IssueDescription|Due Date|ScreenShotName|
|"テスト１"|説明１|"2018-01-01"|"210_010_issue_submeitted"|
|"テスト２"|説明２|"2018-01-02"|"210_020_issue_submeitted"|
|"テスト３"|説明３|"2018-01-03"|"210_030_issue_submeitted"|
|"テスト４"|説明４|"2018-01-04"|"210_040_issue_submeitted"|
|"テスト５"|説明５|"2018-01-05"|"210_050_issue_submeitted"|

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
   #csv://src/test/resources/data2.csv
|aaa|IssueTitle|IssueDescription|Due Date|ScreenShotName|
|aaa|"テスト１１"|説明１|"2018-01-01"|"210_010_issue_submeitted"|
|aaa|"テスト１２"|説明２|"2018-01-02"|"210_020_issue_submeitted"|
|aaa|"テスト１３"|説明３|"2018-01-03"|"210_030_issue_submeitted"|
|aaa|"テスト１４"|説明４|"2018-01-04"|"210_040_issue_submeitted"|
|aaa|"テスト１５"|説明５|"2018-01-05"|"210_050_issue_submeitted"|
