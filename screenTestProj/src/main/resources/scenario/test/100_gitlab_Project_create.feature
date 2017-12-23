@project
Feature: gitlabでのプロジェクト作成を行いたい。
 操作者は、gitlabでのプロジェクト管理をするために、プロジェクト作成を行う必要がある。

@good @create
Scenario: プロジェクト作成
 Given "http://gitlab/" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること

  When "100_010_projects" スクリーンショットをとる
   And "Create a project" をクリックする
   And "Project name" に "my-awesome-project" を入力する
   And "Project description" に "日本語入力てすと" を入力する
   And "Internal" をクリックする
   And "100_020_create project" スクリーンショットをとる
   And "Create project" をクリックする
  Then "test / my-awesome-project · GitLab" ページであること
