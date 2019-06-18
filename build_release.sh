#!/bin/sh
cd "$(dirname "$0")" || exit
if [ -e dentakun.zip ]; then
  rm dentakun.zip
fi
./build.sh || exit
zip -r dentakun.zip img dentakun.jar README.md LICENSE
