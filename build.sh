#!/bin/sh
cd "$(dirname "$0")" || exit
javac -verbose -sourcepath src -d bin src/dentakun/Calculator.java || exit
jar --verbose --create --file dentakun.jar --manifest manifest -C bin/ . || exit
chmod +x dentakun.jar
