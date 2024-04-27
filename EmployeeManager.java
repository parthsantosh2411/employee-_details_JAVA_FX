package org.example.employee_registration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmployeeManager extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize the backend (database connection and table creation)
        EmployeeDatabase.connect();
        EmployeeDatabase.createNewTable();

        // Create UI components
        TextField employeeIdField = new TextField();
        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField emailField = new TextField();
        TextField departmentField = new TextField();

        Button addEmployeeButton = new Button("Add Employee");
        Button viewEmployeesButton = new Button("View Employees");
        Button updateEmployeeButton = new Button("Update Employee");

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(0, new Label("Employee ID:"), employeeIdField);
        grid.addRow(1, new Label("Name:"), nameField);
        grid.addRow(2, new Label("Age:"), ageField);
        grid.addRow(3, new Label("Email:"), emailField);
        grid.addRow(4, new Label("Department:"), departmentField);
        grid.addRow(5, addEmployeeButton);
        grid.addRow(6, viewEmployeesButton, updateEmployeeButton);

        // Event Handling
        addEmployeeButton.setOnAction(e -> EmployeeDatabase.addEmployee(
                nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), departmentField.getText()
        ));
        viewEmployeesButton.setOnAction(e -> EmployeeDatabase.viewEmployees());
        updateEmployeeButton.setOnAction(e -> EmployeeDatabase.updateEmployee(
                Integer.parseInt(employeeIdField.getText()), nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), departmentField.getText()
        ));

        // Set scene and stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Employee Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}