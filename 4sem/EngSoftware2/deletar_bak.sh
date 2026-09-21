#!/bin/bash

TARGET_DIR="$(cd "$(dirname "$0")" && pwd)"

echo "Removendo backups e locks do Visual Paradigm em: $TARGET_DIR"

find "$TARGET_DIR" -type f \( -name "*.lck" -o -name "*.bak_*" -o -name "*.bak" \) -print -delete

echo "Limpeza finalizada"
