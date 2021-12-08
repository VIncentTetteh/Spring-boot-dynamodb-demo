package com.chrisbone.dynamodemo.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.chrisbone.dynamodemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeDBInterface{
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeByID(String employeeID) {
        return dynamoDBMapper.load(Employee.class,employeeID);
    }

    @Override
    public String deleteEmployeeByID(String employeeID) {
        Employee employee = dynamoDBMapper.load(Employee.class,employeeID);
        dynamoDBMapper.delete(employee);
        return "Employee with id:" + employeeID + " deleted";
    }

    @Override
    public String updateEmployee(String employeeID,Employee employee) {
        dynamoDBMapper.save(employee,new DynamoDBSaveExpression()
                .withExpectedEntry(
                        "employeeId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(employeeID)
                        )
                ));
        return employeeID;
    }

    @Override
    public List<Employee> getAllEmployees() throws Exception {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Employee> getAllEmployees = dynamoDBMapper.scan(Employee.class,scanExpression);
        if(getAllEmployees.isEmpty()){
            throw new Exception("table empty");
        }
        return getAllEmployees;
    }


}
