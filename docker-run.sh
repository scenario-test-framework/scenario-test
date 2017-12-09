#!/bin/bash
# 注 dockerの利用には、 root 権限が必要かもしれません。

export VERSION=0.0.1
DOCKERFILE=Dockerfile
#DOCKERFILE=Dockerfile.alpine
#CACHE=--no-cache

function local.start(){
  local.stop
  # docker内部のディレクトリ参照は -v で指定可能。
  # /tmpにリソースをコピーし、コピーしたリソースでビルド&テスト
  DATE=$(date "+%Y%m%d_%H%M%S")
  mkdir -p /tmp/scenario-data.$DATE
  cp -R ./src /tmp/scenario-data.$DATE
  cp -R ./pom.xml /tmp/scenario-data.$DATE
  cp -R ./entry-point.sh /tmp/scenario-data.$DATE
  docker run --rm --network test_bridge -v /tmp/scenario-data.$DATE:/root/scenario-test --name scenario-test scenario-test:$VERSION
  RET=$?
  mkdir -p ../scenario-data.$DATE/build
  if [ -d /tmp/scenario-data.$DATE/build ]; then
    cp -R /tmp/scenario-data.$DATE/build/* ../scenario-data.$DATE/build
  fi
  cp -R /tmp/scenario-data.$DATE/target/surefire-reports/* ../scenario-data.$DATE
  exit $RET
}
function local.stop(){
  # 停止＆イメージ削除
  docker stop scenario-test
  docker rm scenario-test
}
function local.logs(){
  docker logs scenario-test
}
function local.update(){
  # dockerイメージ更新
  local.stop
  docker build -f $DOCKERFILE $CACHE -t scenario-test:$VERSION .
}
function local.ps(){
  docker ps
}
function local.shell(){
  docker exec -it scenario-test /bin/bash
}
function local.usage(){
  echo "$0 start|stop|logs|update|ps|shell|usage"
}

case "$1" in
  start)
    local.start
	  ;;
  stop)
    local.stop
	  ;;
  logs)
    local.logs
	  ;;
  update)
    local.update
    ;;
  ps)
    local.ps
	  ;;
  shell)
    local.shell
	  ;;
  *)
    local.usage
    exit 1
    ;;
esac

exit 0
