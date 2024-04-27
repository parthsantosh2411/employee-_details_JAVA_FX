package org.example.employee_registration;

import java.sql.*;


  //Handles database operations for managing employee data.
public class EmployeeDatabase {

    // Database URL for MySQL, specifying the database name and other connection settings.
    private static final String URL = "jdbc:mysql://localhost:3306/employeeDB";
    // Database user, typically set to 'root' for local development environments.
    private static final String USER = "root";
    // Password for the database user.
    private static final String PASSWORD = "Parth2411";

    /**
     * Establishes and returns a connection to the database.
     * @return a Connection object to interact with the database.
     * @throws SQLException if a database access error occurs or the URL is null.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


     // Connects to the database and creates a new table if it doesn't already exist.
    public static void connect() {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Connected to the database!");
                createNewTable(); // Create the employee table automatically upon connecting.
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }


     // Creates a new table in the database to store employee details.
    public static void createNewTable() {
        // SQL command to create a table with necessary fields if it does not already exist.
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "age INT," +
                "email VARCHAR(255) NOT NULL UNIQUE," +
                "department VARCHAR(255) NOT NULL);";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created automatically.");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Adds a new employee to the database.
     * @param name The name of the employee.
     * @param age The age of the employee.
     * @param email The email address of the employee.
     * @param department The department in which the employee works.
     */
    public static void addEmployee(String name, int age, String email, String department) {
        // SQL command to insert employee data into the table.
        String sql = "INSERT INTO employees(name, age, email, department) VALUES(?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, email);
            pstmt.setString(4, department);
            pstmt.executeUpdate();
            System.out.println("Employee added.");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Updates an existing employee's details in the database.
     * @param id The ID of the employee to update.
     * @param name The new name of the employee.
     * @param age The new age of the employee.
     * @param email The new email address of the employee.
     * @param department The new department of the employee.
     */
    public static void updateEmployee(int id, String name, int age, String email, String department) {
        // SQL command to update employee details based on the ID.
        String sql = "UPDATE employees SET name = ?, age = ?, email = ?, department = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, email);
            pstmt.setString(4, department);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Employee updated.");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

     // Retrieves and displays all employees from the database.
    public static void viewEmployees() {
        // SQL command to retrieve all employee data.
        String sql = "SELECT id, name, age, email, department FROM employees";

        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    // Main method to connect to the database and ensure the table is ready.
    public static void main(String[] args) {
        connect(); // Ensure connection and create table if not exists
    }
}
