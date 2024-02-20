#!/usr/bin/env bash
input=(
    31987
    999
)
this="$(realpath -- "$0")"
dir="$(dirname -- "$this")"
printf '%s\n' "${input[@]}" | java "$dir/$(basename -- "$dir").java"
