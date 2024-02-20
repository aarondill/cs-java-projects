#!/usr/bin/env bash
input=(
    "20 Sided Die"
    8.82
    "Two Sided Coin"
    1.23
    "Color Spinner"
    3.99
)
this="$(realpath -- "$0")"
dir="$(dirname -- "$this")"
printf '%s\n' "${input[@]}" | java "$dir/$(basename -- "$dir").java"
