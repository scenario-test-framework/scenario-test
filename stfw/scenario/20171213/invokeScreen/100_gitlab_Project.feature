@project
Feature: gitlabでのプロジェクト管理を行いたい。
 操作者は、gitlabでのプロジェクト管理をするために、プロジェクト作成・変更・削除を行う必要がある。

Scenario:
 Given "http://gitlab" URLを開く
  Then "Projects · Dashboard · GitLab" ページであること
  When "100_010_projects" スクリーンショットをとる
  When "Create a project" をクリックする
  When "100_020_create project" スクリーンショットをとる
