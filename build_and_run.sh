#!/bin/sh
cd "$(dirname "$0")" || exit
./build.sh || exit
java -jar dentakun.jar
