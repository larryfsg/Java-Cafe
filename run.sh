#!/bin/bash

# ir para raiz do projeto (garante consistência)
cd "$(dirname "$0")"

# limpar classes antigas
find . -name "*.class" -delete

mkdir -p bin

# compilar tudo dentro de src corretamente
javac -cp "lib/flatlaf-3.7.1.jar" -d bin $(find src -name "*.java")

cp -r src/view/images bin/view/

# rodar Main (sem package)
java -cp "lib/flatlaf-3.7.1.jar:bin" Main