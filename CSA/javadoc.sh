#!/usr/bin/env sh
abort() { printf '%s\n' "$1" >&2 && exit "${2:-1}"; }
[ -n "${1:-}" ] && [ -n "${2:-}" ] || abort "usage: $0 <java_file> <doc_dest> [javadoc options]" 2
java_file="$1" doc_dest="$2"
shift 2 # remove the first two arguments

if [ -n "${JAVA_HOME:-}" ]; then
  java=$JAVA_HOME/bin/java
  javadoc=$JAVA_HOME/bin/javadoc
else
  java=$(command -v java)
  javadoc=$(command -v javadoc)
fi
[ -n "$javadoc" ] && [ -n "$java" ] || abort "javadoc or java not found"

# used to link to the correct documentation versions
JAVA_MAJOR_VERSION=$("$java" -version 2>&1 | grep -oP 'version "?(1\.)?\K\d+')
rm -rf -- "$doc_dest"
$javadoc \
  -link "https://docs.oracle.com/en/java/javase/$JAVA_MAJOR_VERSION/docs/api/" \
  -docencoding UTF-8 \
  -charset UTF-8 \
  -nonavbar -notree -noindex -nohelp -nodeprecatedlist \
  -d "$doc_dest" \
  --class-path "$_classpath" \
  -private "$java_file" "$@"
