#!/bin/sh

java \
	-Djava.awt.headless=true \
	-Dselenide.browser=chrome \
	-Dremote=http://localhost:4444/wd/hub \
	-cp 'target/screenTestProj-0.0.1-SNAPSHOT-jar-with-dependencies.jar' \
	cucumber.api.cli.Main src/ \
	--glue scenario.test

