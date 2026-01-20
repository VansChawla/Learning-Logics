import ast

def process_file_robust(input_path, output_path):
    f_in = None
    f_out = None

    print(f"--- Processing '{input_path}' ---")

    try:
        # Manually opening files to demonstrate 'finally' usage
        f_in = open(input_path, 'r')
        f_out = open(output_path, 'w')

        for line_num, line in enumerate(f_in, 1):
            line = line.strip()
            if not line: continue  # Skip empty lines

            try:
                # 1. Safe Eval (Parses string to Python object safely)
                data = ast.literal_eval(line)

                # 2. Filter: Must be a dictionary
                if not isinstance(data, dict):
                    print(f"[Line {line_num}] Ignored: Not a dictionary.")
                    continue

                # 3. Simulate KeyError check (Enforcing required schema)
                # We insist every dict must have an 'id' key to demonstrate KeyError handling
                _ = data['id']

                # 4. Write valid data to output
                f_out.write(str(data) + "\n")
                print(f"[Line {line_num}] Success.")

            # Chained Exception Handling
            except (SyntaxError, ValueError):
                # ast.literal_eval raises ValueError/SyntaxError for malformed strings
                print(f"[Line {line_num}] Error: Malformed syntax (SyntaxError/ValueError).")
            
            except KeyError:
                # Raised when 'id' is missing
                print(f"[Line {line_num}] Error: Missing required 'id' field (KeyError).")

    except EOFError:
        print("Error: Unexpected End of File.")
    except IOError as e:
        print(f"System Error: {e}")

    finally:
        # Guaranteed cleanup regardless of errors
        if f_in: 
            f_in.close()
        if f_out: 
            f_out.close()
        print("--- Resources closed in 'finally' block ---")

# --- Driver Code ---
if __name__ == "__main__":
    # 1. Create a dummy input file with mixed bad data
    input_file = "raw_data.txt"
    output_file = "clean_data.txt"
    
    with open(input_file, "w") as f:
        f.write("{'id': 1, 'name': 'Alice'}\n")    # Valid
        f.write("{'name': 'Bob'}\n")                # Missing 'id' (KeyError)
        f.write("[1, 2, 3]\n")                      # Not a dict (Ignored)
        f.write("{'id': 2, 'name': 'Charlie\n")     # Malformed/Incomplete (SyntaxError)
        f.write("{'id': 3, 'name': 'Dave'}\n")      # Valid

    # 2. Run Processor
    process_file_robust(input_file, output_file)

    # 3. Verify Output
    print(f"\n--- Contents of '{output_file}' ---")
    try:
        with open(output_file, 'r') as f:
            print(f.read())
    except IOError:
        print("Output file could not be read.")