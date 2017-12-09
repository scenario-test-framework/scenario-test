
■docker network設定
1. sudo docker network create test_bridge

■selenium grid環境作成・起動
1. selenium grid環境イメージ作成
  sudo docker-compose build
2. selenium grid環境起動
  sudo docker-compose up -d
  ※ http://{ip}:4444/ で状態確認


■selenium grid環境を停止する場合
1. sudo docker-compose down

■selenide+cucumberテスト実行
※selenium grid/テスト対象サービスは起動していること
0. テスト対象サービスセットアップ
  https://github.com/in-house-swagger/in-house-swagger
※起動時にネットワークを指定する
1. sudo docker run -d --network test_bridge -p 9700:9700 -p 9701:9701 --name in-house-swagger in-house-swagger:$(cat ./src/VERSION)


2. 実行環境dockerイメージ作成
  sudo ./docker-run.sh update
3. src内のソースをもとにコンパイル＆テスト実行
  sudo ./docker-run.sh start

