#!/bin/bash

# moving to project root
cd "$(dirname "$0")"

# cleaning old classes
find . -name "*.class" -delete

# create a bin directory
mkdir -p bin

# compiling everything
javac -cp "lib/flatlaf-3.7.1.jar" -d bin $(find src -name "*.java")

# copying images to bin directory
cp -r src/view/images bin/view/

# running program
java -cp "lib/flatlaf-3.7.1.jar:bin" Main