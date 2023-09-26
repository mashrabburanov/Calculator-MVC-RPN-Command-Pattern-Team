#!/bin/bash

rm -dr ./classes/*

javac -cp ./src \
      -d ./classes/ \
      ./src/*.java