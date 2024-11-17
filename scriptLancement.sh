#!/bin/bash

javac --module-path /c/Users/40ahm/Lib/openjfx/lib --add-modules javafx.controls -d ./bin ./src/*.java

java --module-path /c/Users/40ahm/Lib/openjfx/lib --add-modules javafx.controls -cp ./bin Executable
