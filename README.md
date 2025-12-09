
## Author
Eyobed Awel Nuri

xnuriey00



### Using makefile


```bash
make          # Compile
make run      # Compile and run with an example
make test     # run automatic test 
make clean    # Remove compiled files
make rebuild  # Clean and recompile
```

### Manual compilation

```bash
javac -d out src/*.java
```

### Execution

```bash
java -cp out Main "input"
```

### Automated Testing

```bash
# First, compile
javac -d out src/*.java

# Then run the tests
chmod +x test.sh
./test.sh
```

## Implementation Details

- **Language**: Java
- **Libraries**: Only Java standard library (`java.util.*`)
- **No external dependencies**

### Known Limitations

- No error recovery
- Output does not include spaces between operators

### Files
 three main files:

1. **Lexical Analysis** (`Scanner.java`)
   - DFA

2. **Syntax Analysis** (`Parser.java`)
   - Recursive descent parser
   - Builds Abstract Syntax Tree (AST)

3. **Code Generation** (`CodeGeneration.java`)
   - Converts AST to the infix notation
   



## External References

AI was explicitly used to assist with:
 line 28-43 in `Tree.Java`  reason - boilerplate
 line 57-73 in `CodeGeneration.java` reason - problem solution suggestion and research
 In `Makefile.md` reason -Inital draft
