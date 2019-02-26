#!/bin/sh
cd "$(dirname "$0")" || exit
./build.sh
java -jar dentakun.jar
