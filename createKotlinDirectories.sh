#!/bin/bash

# Define the folder structure
folders=(
    "src"
    "src/main"
    "src/main/kotlin"
    "src/main/resources"
    "src/test"
    "src/test/kotlin"
    "src/test/resources"
)

# Create directories
for folder in "${folders[@]}"
do
    mkdir -p "$folder"
done

# Create files build.gradle.kts and gradle.properties in src directory
touch "src/build.gradle.kts"
touch "src/gradle.properties"


echo "Folder structure created successfully."
