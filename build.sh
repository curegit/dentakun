#!/bin/sh
javac -verbose -sourcepath src -d bin src/dentakun/Calculator.java
jar --verbose --create --file dentakun.jar --manifest manifest -C bin/ .
chmod +x dentakun.jar
