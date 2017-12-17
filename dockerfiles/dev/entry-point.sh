#!/bin/bash

RET=-1
case "$1" in
init)
    RET=0
    ;;
test)
    TAGET=chrome # or firefox
    umask 0000 && 
    cd ~/scenario-test && 
    java \
      -Djava.awt.headless=true \
      -Dselenide.browser=${TAGET} \
      -Dremote=http://hub:4444/wd/hub \
      -cp './target/screenTestProj-0.0.1-SNAPSHOT-jar-with-dependencies.jar' \
      cucumber.api.cli.Main \
      src/main/resources/ \
      --glue scenario.test

    RET=$?
    ;;
shell)
    exec /bin/bash
    ;;
*)
    ;;
esac
exit $RET
