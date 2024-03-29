package com.chrisbone.dynamodemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "employees")
public class Employee {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String employeeId;
    @DynamoDBAttribute
    private String employeeName;
    @DynamoDBAttribute
    private String employeeMail;
    @DynamoDBAttribute
    private Department employeeDepartment;

}
