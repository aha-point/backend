#!/bin/bash
cd /home/ubuntu/app

SPRING_PID=$(pgrep -f aha-point-0.0.1-SNAPSHOT.jar)
kill -9 $SPRING_PID