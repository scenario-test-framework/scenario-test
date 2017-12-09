#!/bin/bash

RET=-1
case "$1" in
init)
    cd ~/scenario-test && 
    mvn test
    RET=$?
    ;;
test)
# gridを利用しない場合、仮想fb上に画面描画する	
#    export DISPLAY=:99 && 
#    ( Xvfb :99 & ) && 
    umask 0000 && 
    cd ~/scenario-test && 
    mvn -Dselenide.browser=chrome -Dremote=http://hub:4444/wd/hub clean test
    #mvn -Dselenide.browser=firefox -Dremote=http://hub:4444/wd/hub clean test
    RET=$?
    ;;
shell)
    exec /bin/bash
    ;;
*)
    ;;
esac
exit $RET
