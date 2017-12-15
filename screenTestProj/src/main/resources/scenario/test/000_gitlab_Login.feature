#language: ja
@login
機能: gitlabへのログインを行いたい。
 操作者は、gitlabでの操作をするために、ログインを行う必要がある。

@good @create
シナリオ: ユーザのログイン
  前提 "http://gitlab/users/sign_in" URLを開く
  かつ "000_010_sign_in" スクリーンショットをとる
ならば "Sign in · GitLab" ページであること

  もし "Sign in tab" をクリックする
  かつ "Username or email" に "test" を入力する
  かつ "Password" に "test1234" を入力する
  かつ "000_020_pre_sign_in" スクリーンショットをとる
  かつ "Sign in" をクリックする
  かつ "000_030_project" スクリーンショットをとる
ならば "Projects · Dashboard · GitLab" ページであること

