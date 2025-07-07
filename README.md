# Split Expense System (Java - LLD Project)

This is a Java-based command-line application for managing and tracking shared expenses between users. The system supports adding expenses, calculating split amounts (Equal, Exact, Percent), and viewing net balances. Built using clean object-oriented design and low-level design principles, this project models real-world expense sharing similar to platforms like Splitwise.

---

## Overview

This project allows users to:

- Create users and assign expenses
- Share expenses using different split types:
  - Equal
  - Exact
  - Percent
- Track how much each user owes or is owed
- View individual or overall balances
- Scale easily with new expense types or group features

---


### Primary Classes

- **User.java**  
  Represents a user with a unique ID and name.

- **Balance.java**  
  Tracks how much one user owes another.

- **Expenses.java**  
  Represents a single expense, with payer, amount, splits, and type.

- **Split.java** (Abstract class/interface)  
  Base for all split strategies.

- **SplitEqual.java**, **SplitExact.java**, **SplitPercent.java**  
  Implement different strategies for splitting expenses.

- **SplitType.java**  
  Enum to represent supported split types: EQUAL, EXACT, PERCENT.

- **ExpenseService.java**  
  Handles the core business logic: adding expenses, calculating balances, managing users.

- **SplitExpense.java**  
  Entry point / main class that reads command-line input and routes to `ExpenseService`.

---

## Tech Stack

- Java SE 17+

- Java Collections (Map, List)

- Console-based input

- Modular object-oriented design

## Author

- [Jeevitha Shree T](https://github.com/JeevithaShreeT)
