@project
Feature: gitlabでのissues管理を行いたい。
 操作者は、gitlabでのissues管理をするために、issue作成・変更・削除を行う必要がある。

@good @create
Scenario: issue作成
 Given "http://gitlab/" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること

  When "test / my-awesome-project" リンクをクリックする
  Then "test / my-awesome-project · GitLab" ページであること

  When "Issues" をクリックする
   And "200_010_Issues" スクリーンショットをとる
   And "Create Issue" をクリックする
   And "200_020_issue" スクリーンショットをとる
   And "Title" に "てすといしゅー" を入力する
   And "Description" に以下を入力する:
   """
   これは
   ***てすとのため***の
   いしゅーです。
   """

   And "200_030_issue_input" スクリーンショットをとる
   And "Submit issue" をクリックする
   And "200_040_issue_submitted" スクリーンショットをとる
