#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

cd "$SCRIPT_DIR"
set -ex

TARGET=ubuntu@164.115.45.150
LOCAL_IMAGE=aaa/md_payment:latest
REMOTE_IMAGE=164.115.45.150:5000/aaa/md_payment:latest

docker tag $LOCAL_IMAGE $REMOTE_IMAGE

docker push $REMOTE_IMAGE

rsync -avzP \
  ./compose.yml \
  $TARGET:~/md_payment/

ssh $TARGET <<EOF
  cd ~/md_payment
  docker compose pull
  docker compose up -d
EOF
