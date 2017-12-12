#!/bin/sh

java -Djava.awt.headless=true -Dselenide.browser=chrome -Dremote=http://192.168.128.99:4444/wd/hub -cp 'target/scenario-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar' cucumber.api.cli.Main  src/main/resources/ --glue scenario.test

