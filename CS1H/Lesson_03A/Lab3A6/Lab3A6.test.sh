#!/usr/bin/env bash
input=(
  4528
  8143
)
this="$(realpath -- "$0")"
dir="$(dirname -- "$this")"
printf '%s\n' "${input[@]}" | java "$dir/$(basename -- "$dir").java"
