
■テスト対象サービス準備

1. テスト対象サービスセットアップ(イメージのビルドまで)

  https://github.com/in-house-swagger/in-house-swagger

■selenium grid環境作成・起動

1. selenium grid環境イメージ作成

  sudo docker-compose build

2. selenium grid環境起動

  sudo docker-compose -f runtime_env/docker-compose.yml up -d

  ※ http://{ip}:4444/ で状態確認
  ※ 内部で runtimeenv_test_bridgeネットワークを作成

■selenide+cucumberテスト実行
※selenium grid/テスト対象サービスは起動していること

1. 実行環境dockerイメージ作成

  sudo ./docker-run.sh update

2. src内のソースをもとにコンパイル＆テスト実行

  sudo ./docker-run.sh start

■selenium grid環境を停止する場合

1. sudo docker-compose -f runtime_env/docker-compose.yml down

