#!/usr/bin/env bash
set -euo pipefail

mkdir -p _data

author="$(git config user.name 2>/dev/null || true)"
if [ -z "$author" ]; then
  author="Joatham Pérez Expósito"
fi

version="$(git describe --tags --always 2>/dev/null || true)"
if [ -z "$version" ]; then
  version="local"
fi

branch="$(git branch --show-current 2>/dev/null || true)"
if [ -z "$branch" ]; then
  branch="main"
fi

commit="$(git rev-parse --short HEAD 2>/dev/null || true)"
if [ -z "$commit" ]; then
  commit="local"
fi

date="$(git log -1 --format=%cd --date=short 2>/dev/null || true)"
if [ -z "$date" ]; then
  date="$(date +%F)"
fi

cat > _data/build.yml <<YAML
author: "$author"
version: "$version"
branch: "$branch"
commit: "$commit"
date: "$date"
YAML
