def add_employee(employees, name, age, department):
    new_emp = {
        'Name': name,
        'Age': age,
        'Department': department
    }
    employees.append(new_emp)
    print(f"Added new employee: {name} ({department})")

def update_department(employees, name, new_department):
    found = False
    for emp in employees:
        if emp['Name'] == name:
            old_dept = emp['Department']
            emp['Department'] = new_department
            found = True
            print(f"Updated {name}'s department from '{old_dept}' to '{new_department}'.")
            break
    
    if not found:
        print(f"Error: Employee '{name}' not found. Cannot update.")

def remove_employee(employees, name):
    employee_to_remove = None
    
    for emp in employees:
        if emp['Name'] == name:
            employee_to_remove = emp
            break
    
    if employee_to_remove:
        employees.remove(employee_to_remove)
        print(f"Terminated/Removed employee: {name}")
    else:
        print(f"Error: Employee '{name}' not found. Cannot remove.")

def display_employees(employees):
    print("\n--- Employee Directory ---")
    if not employees:
        print("(No employees found)")
    else:
        print(f"{'Name':<15} | {'Age':<5} | {'Department'}")
        print("-" * 40)
        for emp in employees:
            print(f"{emp['Name']:<15} | {emp['Age']:<5} | {emp['Department']}")
    print("-" * 40 + "\n")


if __name__ == "__main__":
    company_staff = [
        {'Name': 'Alice', 'Age': 30, 'Department': 'HR'},
        {'Name': 'Bob',   'Age': 24, 'Department': 'IT'},
        {'Name': 'Charlie', 'Age': 29, 'Department': 'Sales'}
    ]

    print("=== Employee Management System ===")
    display_employees(company_staff)

    # 2. Add a new employee
    add_employee(company_staff, "David", 35, "Management")

    # 3. Update an employee's department
    # Moving Bob from IT to Security
    update_department(company_staff, "Bob", "Security")

    # 4. Remove a terminated employee
    # Alice leaves the company
    remove_employee(company_staff, "Alice")

    # 5. Try to remove someone who doesn't exist (to test logic)
    remove_employee(company_staff, "Zara")

    # 6. Show Final List
    display_employees(company_staff)