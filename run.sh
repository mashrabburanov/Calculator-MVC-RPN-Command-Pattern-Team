#!/bin/bash

export PATH_JAVAFX="/usr/lib/jvm/javafx-sdk-17.0.8/lib/"

java --module-path $PATH_JAVAFX --add-modules javafx.controls -cp "./classes/:" calculator.Calculator
