import csv

def get_grade(score):
    if score >= 90: return 'A'
    elif score >= 80: return 'B'
    elif score >= 70: return 'C'
    elif score >= 60: return 'D'
    else: return 'F'

def process_scores(input_filename, output_filename):
    # Dictionary to store lists of students by grade
    grouped_data = {'A': [], 'B': [], 'C': [], 'D': [], 'F': []}

    try:
        # 1. Read the CSV file
        with open(input_filename, 'r') as csv_file:
            reader = csv.reader(csv_file)
            next(reader, None)  # Skip header row safely
            
            for row in reader:
                if len(row) < 2: continue # Skip empty/malformed lines
                
                name, score_str = row[0], row[1]
                
                # 2. Handle bad data (ValueError) inside the loop
                try:
                    score = int(score_str)
                    grade = get_grade(score)
                    grouped_data[grade].append(name)
                except ValueError:
                    print(f"Log: Skipping invalid score for '{name}': {score_str}")

        # 3. Write summary to output file
        with open(output_filename, 'w') as out_file:
            for grade, students in sorted(grouped_data.items()):
                if students: # Only write grades that have students
                    line = f"Grade {grade}: {', '.join(students)}\n"
                    out_file.write(line)
                    print(line.strip()) # Mirror to console
        
        print(f"-> Success! Summary saved to '{output_filename}'")

    # 4. Handle missing file (FileNotFoundError)
    except FileNotFoundError:
        print(f"Error: The file '{input_filename}' was not found.")

# --- Driver Code ---
if __name__ == "__main__":
    # Create a dummy file for testing purposes
    with open('data.csv', 'w') as f:
        f.write("name,score\nAlice,95\nBob,82\nCharlie,invalid\nDavid,76\nEve,91")
    
    # Run script
    process_scores('data.csv', 'output.txt')