def add_book(library, title, author):
    new_book = {
        'title' : title,
        'author' : author,
        'status' : 'Available'
    }
    library.append(new_book)
    print(f"Added '{title}' by {author} to the library.")

def borrow_book(library, title):
    found = False
    for book in library:
        if book['title'] == title:
            found = True
            if book['status'] == 'Available':
                book['status'] = 'Borrowed'
                print(f"You have successfully borrowed '{title}'.")
            else:
                print(f"Sorry, '{title}' is currently unavailable (already borrowed).")
            break
    
    if not found:
        print(f"Error: Book '{title}' not found in the library.")

def return_book(library, title):
    found = False
    for book in library:
        if book['title'] == title:
            found = True
            if book['status'] == 'Borrowed':
                book['status'] = 'Available'
                print(f"You have returned '{title}'.")
            else:
                print(f"'{title}' was already in the library (not borrowed).")
            break
            
    if not found:
        print(f"Error: Cannot return '{title}'. It does not belong to this library.")

def display_library(library):
    """
    Prints the current status of all books.
    """
    print("\n--- Current Library Stock ---")
    print(f"{'Title':<20} | {'Author':<15} | {'Status'}")
    print("-" * 50)
    for book in library:
        print(f"{book['title']:<20} | {book['author']:<15} | {book['status']}")
    print("-" * 50 + "\n")

if __name__ == "__main__":
    # 1. Initialize an empty list or a list with some starter books
    my_library = [
        {'title': 'The Alchemist', 'author': 'Paulo Coelho', 'status': 'Available'},
        {'title': '1984', 'author': 'George Orwell', 'status': 'Borrowed'}
    ]

    print("=== Library Management System ===")
    display_library(my_library)

    # 2. Add a new book
    add_book(my_library, "Harry Potter", "J.K. Rowling")

    # 3. Try to borrow a book that is available
    borrow_book(my_library, "The Alchemist")

    # 4. Try to borrow a book that is already borrowed
    borrow_book(my_library, "1984")

    # 5. Return a book
    return_book(my_library, "1984")

    # 6. Show final state
    display_library(my_library)
    