package com.chrisbone.dynamodemo.service;

import com.chrisbone.dynamodemo.entity.Employee;

import java.util.List;

public interface EmployeeDBInterface {
    Employee save(Employee employee);
    Employee getEmployeeByID(String employeeID);
    String deleteEmployeeByID(String employeeID);
    String updateEmployee(String employeeID, Employee employee);
    List<Employee> getAllEmployees() throws Exception;

}
