#!/usr/bin/env bash
set -euC -o pipefail
shopt -s nullglob dotglob globstar
log() { printf '%s\n' "$@" || true; }
err() { printf '%s\n' "$@" >&2 || true; }
abort() { err "$1" && exit "${2:-1}"; }
# Usage: run.sh judge_dir/ File.java
# Judge dir should be a directory containing a file named "JudgeData/file.dat" and a file named "JudgeOutput/file.out"
judge_dir=$(realpath -- "$1")
file=$2
name=$(basename -- "$file") name="${name%.java}" name="${name,,}" # lowercase without .java

log "Running $name"
tmpdir=$(mktemp -d)
log "tmpdir: $tmpdir"

target="$tmpdir/$(basename -- "$file")"
cleanup() {
  rm -rf -- "$tmpdir"
}
trap cleanup EXIT

cp "$file" "$target"
cd "$tmpdir"

# Glob to find the data and output files
shopt -s nocaseglob # case-insensitive globbing
datafile=("$judge_dir"/*Judge*Dat*/"$name.dat")
outputfile=("$judge_dir"/*Judge*Out*/"$name.out")
shopt -u nocaseglob
[ -n "$datafile" ] && [ -n "$outputfile" ] || abort "No data or no output file found"
[ "${#datafile[@]}" -eq 1 ] || abort "Multiple data files found: ${datafile[@]}"
[ "${#outputfile[@]}" -eq 1 ] || abort "Multiple output files found: ${outputfile[@]}"

cp -a -- "$datafile" "$outputfile" .
java "$target" | tee -- "$name.out.real"
# Remove leading and trailing empty lines
sed -i -e :a -e '/./,$!d;/^\n*$/{$d;N;};/\n$/ba' "$name.out.real"

ok=0
diff -u -Z --strip-trailing-cr -- "$name.out.real" "$name.out" | bat || ok=${PIPESTATUS[0]}
[ "$ok" -eq 0 ] && log "PASS" || log "FAIL"
