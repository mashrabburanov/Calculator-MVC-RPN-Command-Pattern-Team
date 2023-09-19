#!/bin/bash

export PATH_JAVAFX="/usr/lib/jvm/javafx-sdk-17.0.8/lib/"

javac -d classes src/model/*.java

javac --module-path $PATH_JAVAFX --add-modules javafx.controls -d classes src/view/*.java

javac --module-path $PATH_JAVAFX --add-modules javafx.controls -cp classes -d classes src/controller/*.java

javac --module-path $PATH_JAVAFX --add-modules javafx.controls -cp classes -d classes src/*.java
