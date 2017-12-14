@login
Feature: gitlabへのログインを行いたい。
 操作者は、gitlabでの操作をするために、ログインを行う必要がある。

Scenario: ユーザのログイン
 Given "http://gitlab/users/sign_in" URLを開く
  When "000_010_sign_in" スクリーンショットをとる
  Then "Sign in · GitLab" ページであること
  When "Sign in tab" をクリックする
  When "Username or email" に "test" を入力する
   And "Password" に "test1234" を入力する
  When "000_020_pre_sign_in" スクリーンショットをとる
  When "Sign in" をクリックする
  When "000_030_project" スクリーンショットをとる
  Then "Projects · Dashboard · GitLab" ページであること

