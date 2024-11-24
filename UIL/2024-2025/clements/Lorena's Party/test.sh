#!/usr/bin/env bash
set -euC -o pipefail
this_dir="$(readlink -f -- "$(dirname "$0")")" # might break if cwd is a symlink

javav=jdk-15
java="/usr/lib/jvm/$javav/bin/java"
javac="/usr/lib/jvm/$javav/bin/javac"

cd -- "$this_dir"

"$javac" ./Solution.java
stdin=./solution.dat
[ -t 0 ] || stdin=/dev/stdin

exit=0
"$java" Solution "$@" <"$stdin" || exit=$?
rm -f ./Solution.class
exit "$exit"
