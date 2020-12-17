package com.assignment.emp.controller;

import com.assignment.emp.entity.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.assignment.emp.exceptions.ApplicaionException;
import com.assignment.emp.model.AppResponceEntity;
import com.assignment.emp.model.ResultEntity;
import com.assignment.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/v1/employee/")
@Api(value = "EmployeeController", tags = "Employee")
public class EmployeeController extends AbstractController {

     private static final Logger logger = LogManager.getLogger(EmployeeController.class);
    
     private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation(value = "Get All Employee", response = String.class, tags = "Employee")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK")
        ,@ApiResponse(code = 404, message = "not found!!!")})
    public ResponseEntity<AppResponceEntity> getAllEmployee(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(defaultValue = "employeeId,desc") String[] sort) throws ApplicaionException{
         final ResultEntity resultEntity = employeeService.getAllEmployees(page,size,sort);
        return buildSuccessResponse(resultEntity.getEntity(), resultEntity.getMessage(), HttpStatus.OK);

    }

    @PostMapping
    @ApiOperation(value = "Add  new Employee record", response = AppResponceEntity.class, tags = "Employee")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK")
        ,@ApiResponse(code = 404, message = "not found!!!")})
    public ResponseEntity<AppResponceEntity> saveEmployee(@RequestBody Employee employee) throws ApplicaionException {
        final ResultEntity resultEntity = employeeService.saveEmployee(employee);
        return buildSuccessResponse(resultEntity.getEntity(), resultEntity.getMessage(), HttpStatus.OK);
    }

    @PutMapping(value = "/place/{place}/salary/{percentage}")
      @ApiOperation(value = "Update Employee percentage", response = AppResponceEntity.class, tags = "Employee")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK")
        ,@ApiResponse(code = 404, message = "not found!!!")})
      public ResponseEntity<AppResponceEntity> updateEmpPercentage(@PathVariable(value = "place") String place, @PathVariable(value = "percentage") Float percentage) throws ApplicaionException {
        final ResultEntity resultEntity = employeeService.updateEmpPercentage(place, percentage);
        return buildSuccessResponse(resultEntity.getEntity(), resultEntity.getMessage(), HttpStatus.OK);
    }
}
