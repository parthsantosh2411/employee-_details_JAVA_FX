# Employee Registration and Management System

This application allows you to register and manage employee details using a JavaFX frontend and MySQL backend.

# Classes & Function

1. **EmployeeDatabase Class**:
   
   - This class manages database operations for handling employee data.
   - **Functions**:
     - `getConnection()`: Establishes a connection to the MySQL database.
     - `connect()`: Connects to the database and creates a new table if it doesn't already exist.
     - `createNewTable()`: Creates a new table in the database to store employee details.
     - `addEmployee(String name, int age, String email, String department)`: Adds a new employee to the database.
     - `updateEmployee(int id, String name, int age, String email, String department)`: Updates an existing employee's details in the database.
     - `viewEmployees()`: Retrieves and displays all employees from the database.

3. **EmployeeManager Class**:
   - This class is a JavaFX application for managing employees.
   - **Functions**:
     - `start(Stage primaryStage)`: Initializes the frontend UI components and sets up event handling for adding, viewing, and updating employees.
     - `main(String[] args)`: Launches the JavaFX application.

4. **Main Method**:
   - In `EmployeeDatabase`:
     - `main(String[] args)`: Ensures connection to the database and creates the table if not already present.
   - In `EmployeeManager`:
     - `main(String[] args)`: Launches the JavaFX application.

These classes and functions work together to provide a user-friendly interface for managing employee data stored in a MySQL database. The `EmployeeDatabase` class handles database operations, while the `EmployeeManager` class presents the interface to interact with the database.


## Usage

- Input employee details in the respective fields.
- Click "Add Employee" to register a new employee.
- Click "View Employees" to see all registered employees.
- Click "Update Employee" after filling the Employee ID field to update an employee's details.

## Setup

1. **Database Setup**:
   - Execute the `create_database.sql` script to create the MySQL database (`employeeDB`) and switch to it.
   - Ensure your MySQL server is running and accessible.

2. **Java Environment**:
   - Make sure you have Java installed on your system.

3. **Running the Application**:
   - Compile and run the `EmployeeManager.java` class.
   - Input employee details and use the provided buttons to add, view, or update employees.
  



