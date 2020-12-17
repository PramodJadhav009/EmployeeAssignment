/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.emp.controller;

import com.assignment.emp.entity.Employee;
import com.assignment.emp.model.AppResponceEntity;
import com.assignment.emp.service.EmployeeService;
import com.assignment.emp.service.impl.EmployeeServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Admin
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    
   @InjectMocks
  private  EmployeeServiceImpl employeeServiceMock;  
    
   
  private EmployeeController employeeController;
  
    @Before
    public void setUp() {
        employeeController=new EmployeeController(employeeServiceMock);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllEmployee method, of class EmployeeController.
     */
    @Test
    public void testGetAllEmployee() throws Exception {
        System.out.println("getAllEmployee");
        int page = 0;
        int size = 0;
        String[] sort = {"id","desc"};
        EmployeeController instance = employeeController;
         ResponseEntity<AppResponceEntity> result = instance.getAllEmployee(page, size, sort);
        assertEquals(HttpStatus.OK,result.getStatusCode().OK);
        }

    /**
     * Test of saveEmployee method, of class EmployeeController.
     */
    @Test
    public void testSaveEmployee() throws Exception {
        System.out.println("saveEmployee");
        Employee employee = new Employee();
        EmployeeController instance = employeeController;
      
        ResponseEntity<AppResponceEntity> result = instance.saveEmployee(employee);
        assertEquals(HttpStatus.OK,result.getStatusCode().OK);
    }

    /**
     * Test of updateEmpPercentage method, of class EmployeeController.
     */
    @Test
    public void testUpdateEmpPercentage() throws Exception {
        System.out.println("updateEmpPercentage");
        String place = "abc";
        Float percentage = 10.0f;
        EmployeeController instance = employeeController;
        ResponseEntity<AppResponceEntity> result = instance.updateEmpPercentage(place, percentage);
       assertEquals(HttpStatus.OK,result.getStatusCode().OK);
    }
    
}
