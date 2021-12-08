package com.chrisbone.dynamodemo.controller;

import com.chrisbone.dynamodemo.entity.Employee;
import com.chrisbone.dynamodemo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeByID(@PathVariable("id") String employeeID){
        return employeeRepository.deleteEmployeeByID(employeeID);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeByID(@PathVariable("id") String employeeID){
        return employeeRepository.getEmployeeByID(employeeID);
    }
    @PatchMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") String employeeID, @RequestBody Employee employee){
        return employeeRepository.updateEmployee(employeeID,employee);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployees() throws Exception {
       return employeeRepository.getAllEmployees();
    }


}
