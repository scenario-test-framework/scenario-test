#!/bin/sh

# シナリオの日付はパラメータ？
java -Djava.awt.headless=true -Dselenide.browser=chrome -Dremote=http://192.168.128.99:4444/wd/hub -cp 'lib/scenario-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar' cucumber.api.cli.Main ../../scenario/20171213/invokeScreen/ --glue scenario.test

