#!/bin/bash

RET=-1
case "$1" in
init)
    cd ~/scenario-test && 
    mvn test
    RET=$?
    ;;
test)
    export DISPLAY=:99 && 
    ( Xvfb :99 & ) && 
    umask 0000 && 
    cd ~/scenario-test && 
    mvn clean test
    RET=$?
    ;;
shell)
    exec /bin/bash
    ;;
*)
    ;;
esac
exit $RET
