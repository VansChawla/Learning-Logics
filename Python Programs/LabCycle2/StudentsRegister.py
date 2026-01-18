def add_grades(students):
    for student in students:
        marks = student['Marks']
        if marks >= 90:
            student['Grade'] = 'A'
        elif marks >= 80:
            student['Grade'] = 'B'
        elif marks >= 70:
            student['Grade'] = 'C'
        elif marks >= 60:
            student['Grade'] = 'D'
        else:
            student['Grade'] = 'F'
        print("Grades Added Successfully.")

def update_age(students, name, new_age):
    found = False
    for student in students:
        if student['Name'] == name:
            student['Age'] = new_age
            found = True
            print(f"Updated {name}'s age to {new_age}")
            break
        
        if not found:
            print(f"Student {name} not found.")

def calculate_average(students):
    total_marks = 0
    count = len(students)

    for student in students:
        total_marks += student['Marks']
    
    average = total_marks / count
    print(f"The Class Average is: {average:.2f}")

if __name__ == "__main__":
    student_list = [
        {'Name': 'Rohan', 'Age': 20, 'Subject': 'Maths', 'Marks': 85},
        {'Name': 'Priya', 'Age': 21, 'Subject': 'Physics', 'Marks': 92},
        {'Name': 'Amit',  'Age': 22, 'Subject': 'Chemistry', 'Marks': 78},
        {'Name': 'Neha',  'Age': 20, 'Subject': 'CS', 'Marks': 65},
        {'Name': 'Arjun', 'Age': 23, 'Subject': 'English', 'Marks': 88}
    ]

    print("--- Initial List ---")
    for s in student_list:
        print(s)
    print("\n--- Performing Operations ---")

    # Operation 1: Add Grades
    add_grades(student_list)

    # Operation 2: Update Age
    update_age(student_list, "Amit", 25)

    # Operation 3: Calculate Average
    calculate_average(student_list)

    print("\n--- Final List (Updated) ---")
    for s in student_list:
        print(s)

    

            
