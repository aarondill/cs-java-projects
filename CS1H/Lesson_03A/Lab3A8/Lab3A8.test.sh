#!/usr/bin/env bash
input=(
    8.5
    10.2
)
this="$(realpath -- "$0")"
dir="$(dirname -- "$this")"
printf '%s\n' "${input[@]}" | java "$dir/$(basename -- "$dir").java"
