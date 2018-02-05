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
   And "Due Date" に "2018-12-31" を入力する

   And "200_030_issue_input" スクリーンショットをとる
   And "Submit issue" をクリックする
   And "200_040_issue_submitted" スクリーンショットをとる

#@good
#Scenario: issue変更
# Given "http://gitlab/" URLを開く
#  Then "Projects · Dashboard · GitLab" ページであること
#
#  When "test / my-awesome-project" リンクをクリックする
#  Then "test / my-awesome-project · GitLab" ページであること
#
#  When "Issues" をクリックする
#   And "てすといしゅー" リンクをクリックする
#   And "200_050_issue" スクリーンショットをとる
#   And "Edit" をクリックする
#   And "Edit title" に "てすといしゅー変更" を入力する
#   And "Edit description" に以下を入力する:
#   """
#   これは
#   ***てすとのため***の
#   ***いしゅー***変更です。
#   """
#
#   And "200_060_issue_pre_edit" スクリーンショットをとる
#   And "Save changes" をクリックする
#   And "200_070_issue_save_changes" スクリーンショットをとる
