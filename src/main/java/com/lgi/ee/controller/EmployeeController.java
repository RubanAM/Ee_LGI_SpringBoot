package com.lgi.ee.controller;

import com.lgi.ee.entity.Employee;
import com.lgi.ee.repository.EmployeeRepository;
import com.lgi.ee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This controller used to retrieve, add and delete employee details
 *
 * @author Kalpana Pochareddy
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.fetchEmployee(employeeId);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId) {
        return  employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId,employee);
    }
}
