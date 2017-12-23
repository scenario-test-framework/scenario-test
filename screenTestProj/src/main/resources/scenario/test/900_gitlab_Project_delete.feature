@project
Feature: gitlabでのプロジェクト削除を行いたい。
 操作者は、gitlabでのプロジェクト管理をするために、プロジェクト削除を行う必要がある。

@good @delete
Scenario: プロジェクト削除
 Given "http://gitlab/" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること

  When "900_010_projects" スクリーンショットをとる
   And "test / my-awesome-project" リンクをクリックする
   And "900_020_project_detail" スクリーンショットをとる
  Then "test / my-awesome-project · GitLab" ページであること

  When "Remove project" をクリックする
   And "900_030_project_removed" スクリーンショットをとる
  Then "Projects · Dashboard · GitLab" ページであること
