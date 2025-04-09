#!/usr/bin/env bash
set -euC -o pipefail
# Usage: run.sh judge_dir/ File.java
# Judge dir should be a directory containing a file named "JudgeData/file.dat" and a file named "JudgeOutput/file.out"
judge_dir=$(realpath -- "$1")
file=$2
name=$(basename -- "$file") name="${name%.java}" name="${name,,}" # lowercase without .java

echo "Running $name"
tmpdir=$(mktemp -d)
echo "tmpdir: $tmpdir"

target="$tmpdir/$(basename -- "$file")"
cleanup() {
  rm -rf -- "$tmpdir"
}
trap cleanup EXIT

cp "$file" "$target"
cd "$tmpdir"

cp "$judge_dir/JudgeData/$name.dat" "$judge_dir/JudgeOutput/$name.out" .
java "$target" | tee -- "$name.out.real"
# Remove leading and trailing empty lines
sed -i -e :a -e '/./,$!d;/^\n*$/{$d;N;};/\n$/ba' "$name.out.real"

ok=0
diff -u -Z --strip-trailing-cr -- "$name.out.real" "$name.out" | bat || ok=${PIPESTATUS[0]}
if [[ "$ok" -eq 0 ]]; then
  echo "OK"
else
  echo "FAIL"
fi
