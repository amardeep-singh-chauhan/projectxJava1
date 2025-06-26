package com.amardeep.projectx.controllers;

import com.amardeep.projectx.dto.EmployeeDTO;
import com.amardeep.projectx.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/hardCodedEmployee")
    public EmployeeDTO getEmployees(){
        return new EmployeeDTO(12, "John", LocalDate.of(2024,01,02), true);
    }

    // particular employee using path variable
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable() long id){
        // or to change name of variable I can use @PathVariable("id") long empId
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // particular employee using params variable
    @GetMapping(path = "/say")
    public String sayHello(@PathParam("word") String word, @PathParam("count") String count){
        return "Hello " + word + " " + count + " times";
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public List<EmployeeDTO> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }

}
