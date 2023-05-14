#!/bin/bash
cd /home/ubuntu/app

nohup java -jar build/libs/aha-point-0.0.1-SNAPSHOT.jar 1>log.out 2>error.out &