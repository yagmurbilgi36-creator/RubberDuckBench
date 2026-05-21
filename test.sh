#!/bin/bash

echo "============================================================"
echo "  Compiling proof script..."
echo "============================================================"

javac ExtMetadata.java ImageInfo.java Media.java Main.java

if [ $? -ne 0 ]; then
    echo "Compilation FAILED."
    exit 1
fi

echo "Compilation successful."
echo ""

echo "============================================================"
echo "  Running proof..."
echo "============================================================"
echo ""

java Main
