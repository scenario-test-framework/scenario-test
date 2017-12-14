@project
Feature: gitlabでのプロジェクト管理を行いたい。
 操作者は、gitlabでのプロジェクト管理をするために、プロジェクト作成・変更・削除を行う必要がある。

Scenario: プロジェクト作成
 Given "http://gitlab/" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること
  When "100_010_projects" スクリーンショットをとる
  When "Create a project" をクリックする
  When "Project name" に "my-awesome-project" を入力する
   And "Project description" に "日本語入力てすと" を入力する
   And "Internal" をクリックする
  When "100_020_create project" スクリーンショットをとる
  When "Create project" をクリックする

Scenario: プロジェクト削除
 Given "http://gitlab/" URLを開く
  When "900_010_projects" スクリーンショットをとる
  When "test / my-awesome-project" リンクをクリックする
  When "900_020_project_detail" スクリーンショットをとる
  Then "test / my-awesome-project · GitLab" ページであること
  When "Remove project" をクリックする
  When "900_030_project_removed" スクリーンショットをとる
