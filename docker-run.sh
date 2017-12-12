#!/bin/bash
# 注 dockerの利用には、 root 権限が必要かもしれません。

export VERSION=0.0.1

function local.start(){
  JAR=./screenTestProj/target/scenario-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar
  if [ ! -f $JAR ]; then
    echo "cd screenTestProj;mvn package"
    exit 2
  fi
  DATE=$(date "+%Y%m%d_%H%M%S")
  if [ -d /tmp/scenario-data ]; then
    rm -Rf /tmp/scenario-data
  fi
  mkdir -p /tmp/scenario-data
  cp -R $JAR /tmp/scenario-data
  cp -R ./screenTestProj/src /tmp/scenario-data
  cp -R ./entry-point.sh /tmp/scenario-data
  docker-compose up 
  RET=$?
  mkdir -p ../scenario-data.$DATE/build
  if [ -d /tmp/scenario-data/build ]; then
    cp -R /tmp/scenario-data/build/* ../scenario-data.$DATE/build
  fi
  exit $RET
}
function local.update(){
  # dockerイメージ更新
  docker-compose build
}
function local.usage(){
  echo "$0 start|update|usage"
}

case "$1" in
  start)
    local.start
	  ;;
  update)
    local.update
    ;;
  *)
    local.usage
    exit 1
    ;;
esac

exit 0
