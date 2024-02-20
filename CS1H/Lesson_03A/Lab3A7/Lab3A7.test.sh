#!/usr/bin/env bash
input=(
    388.97
    412.42
)
this="$(realpath -- "$0")"
dir="$(dirname -- "$this")"
printf '%s\n' "${input[@]}" | java "$dir/$(basename -- "$dir").java"
