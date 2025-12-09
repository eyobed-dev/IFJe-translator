#!/bin/bash
# Simple test script
# Author: xnuriey00

echo "Running tests..."

# Required examples
echo "Input: add(5, mul(3, sub(10, pow(6, 4))))"
echo "Expected: 5+3*(10-6^4)"
java -cp out Main "add(5, mul(3, sub(10, pow(6, 4))))"

echo "Input: pow(pow(2,3),1)"
echo "Expected: (2^3)^1"
java -cp out Main "pow(pow(2,3),1)"

echo "Input: tern(5e2, 2.7, 1)"
echo "Expected: 5e2?2.7:1"
java -cp out Main "tern(5e2, 2.7, 1)"

echo "Input: tern(1, tern(2, 3, 4), 5)"
echo "Expected: 1?2?3:4:5"
java -cp out Main "tern(1, tern(2, 3, 4), 5)"

# Additional tests
echo "Input: mul(2, add(3, 4))"
echo "Expected: 2*(3+4)"
java -cp out Main "mul(2, add(3, 4))"

echo "Input: sub(10, sub(3, 2))"
echo "Expected: 10-(3-2)"
java -cp out Main "sub(10, sub(3, 2))"

echo "Input: div(20, div(4, 2))"
echo "Expected: 20/(4/2)"
java -cp out Main "div(20, div(4, 2))"

echo "Input: add(3.14, 2.86)"
echo "Expected: 3.14+2.86"
java -cp out Main "add(3.14, 2.86)"

echo "Input: mod(10, 3)"
echo "Expected: 10%3"
java -cp out Main "mod(10, 3)"

echo "Input: pow(2, pow(3, 4))"
echo "Expected: 2^3^4"
java -cp out Main "pow(2, pow(3, 4))"

echo "Input: /* comment */ add(5, 3)"
echo "Expected: 5+3"
java -cp out Main "/* comment */ add(5, 3)"

echo "Done."
