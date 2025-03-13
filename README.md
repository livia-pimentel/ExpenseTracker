# Overview

## Project: Expense Tracker Application

As a software development student, this project serves as my initial step in learning and applying core Java concepts, including object-oriented programming, data structures, and file handling, to build a practical tool.

## Software Description

The Expense Tracker application is a command-line tool designed to help users manage their personal expenses. It allows users to:

- **Add Expenses:** Record new expenses with details such as date, category, description, and amount.
- **Categorize Expenses:** Organize expenses into categories for better tracking and analysis.
- **Generate Reports:** View summarized spending reports by category, providing insights into spending habits.   
- **Data Persistence:** Save and load expense data from a CSV file, ensuring data is preserved between sessions.
- **Input Validation:** Implement robust input validation to ensure data integrity and prevent errors.

The application utilizes Java's *LocalDate* for date handling, *Scanner* for user input, *Map* for data organization, and file I/O for data persistence. It demonstrates the use of object-oriented principles through the *Expense* and *ExpenseTracker classes*.

## Purpose

The primary purpose of this project is to:

- Gain a foundational understanding of Java programming by building a practical application.
- Apply basic object-oriented design principles to structure the application.
- Learn how to handle user input and output using Java's *Scanner* class.
- Explore data persistence using file I/O operations.

# Development Environment

## Tools
The Expense Tracker application was developed using the following tools:

- **VS Code (Visual Studio Code):**  A lightweight but powerful source code editor that provided a versatile environment for coding, debugging, and testing the application. Its extensive library of extensions and integrated terminal made it an efficient tool for Java development.
- **Git:** A version control system used to manage and track changes to the codebase, ensuring proper versioning and collaboration.
- **GitHub:** A web-based platform used to host the Git repository, allowing for easy sharing and collaboration.

## Programming Language and Libraries
The application was written in **Java**, a versatile and widely used programming language. The core Java libraries were used to implement the application's functionality. Specifically:

- *java.time.LocalDate:* Used for handling date and time information, ensuring accurate date management for expenses.
- *java.util.Scanner:* Used for reading user input from the command line, enabling interactive user experience.
- *java.util.Map:* Used for storing and organizing expense data by category, facilitating efficient data retrieval and analysis.
- *java.io.BufferedReader* and *java.io.BufferedWriter:* Used for reading and writing expense data to a CSV file, enabling data persistence.
- *java.util.ArrayList:* Used for storing a list of existing categories.
- *java.util.Locale:* Used para formatar os numeros decimais corretamente.

# Useful Websites

- [JDK 23 - Documentation](https://docs.oracle.com/en/java/javase/23/)
- [Java - Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Visual Studio Code - Documentation](https://code.visualstudio.com/docs)
- [Git - Documentation](https://git-scm.com/doc)
- [GitHub - Documentation](https://docs.github.com/en)
- [Stack Overflow - Questions](https://stackoverflow.com/questions)


# Future Work

- Graphical User Interface (GUI)
- Enhanced Reporting
- Database Integration