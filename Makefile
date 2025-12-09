# Makefile for Translator Project
# Author: xnuriey00

# Compiler and flags
JC = javac
JFLAGS = -d out

# Runtime
JAVA = java
JRFLAGS = -cp out

# Directories
SRC_DIR = src
OUT_DIR = out

# Source files
SOURCES = $(wildcard $(SRC_DIR)/*.java)

# Default target
all: compile

# Compile all Java files
compile:
	@mkdir -p $(OUT_DIR)
	$(JC) $(JFLAGS) $(SOURCES)
	@echo "Compilation successful!"

# Run with example input
run: compile
	$(JAVA) $(JRFLAGS) Main "add(5, mul(3, sub(10, pow(6, 4))))"

# Run tests
test: compile
	@chmod +x test.sh
	@./test.sh

# Clean compiled files
clean:
	rm -rf $(OUT_DIR)
	@echo "Cleaned output directory"

# Rebuild everything
rebuild: clean compile


.PHONY: all compile run test clean rebuild
