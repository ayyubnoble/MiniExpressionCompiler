# Mini Expression Compiler

## Project Summary

This project is a mini expression compiler written in Java.
It processes mathematical expressions through several compiler phases:

1. Lexical Analysis (Tokenization)
2. Parsing using Recursive Descent
3. AST (Abstract Syntax Tree) Generation
4. Expression Evaluation

The compiler supports:

* Addition (+)
* Subtraction (-)
* Multiplication (*)
* Division (/)
* Parentheses
* Unary minus (example: -3)

The project also detects invalid syntax and displays error messages.

## Features

* Tokenizes arithmetic expressions
* Validates expressions using recursive descent parsing
* Builds an Abstract Syntax Tree (AST)
* Evaluates expressions recursively
* Handles invalid expressions with error messages
* Supports nested parentheses and unary operators


## Project Structure

```text
src/
├── lexer/
├── parser/
├── ast/
├── evaluator/
├── utils/
└── Main.java
```

## Setup Instructions

### Requirements

* Java JDK 17 or higher
* Visual Studio Code or any Java IDE

### Compile the Project

```bash
javac -d src $(find src -name "*.java")


### Run the Project

```bash
java -cp src Main

## Example Inputs

### Valid Input

3 + 4 * 2

Output:

Evaluation Result: 11


### Parentheses Example

(1 + 2) * (3 + 4)

Output:

Evaluation Result: 21


### Unary Operator Example

-3 + 5

Output:

Evaluation Result: 2


### Invalid Input Example

3 + * 5

Output:

Error: Invalid syntax near: *

## Author

Ayyub Noble
