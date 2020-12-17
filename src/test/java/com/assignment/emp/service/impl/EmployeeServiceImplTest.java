/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.emp.service.impl;

import com.assignment.emp.entity.Employee;
import com.assignment.emp.model.ResultEntity;
import com.assignment.emp.model.ResultEntity.RESULT;
import com.assignment.emp.repository.EmployeeRepository;
import com.assignment.emp.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Admin
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
    
    @Mock
    private EmployeeRepository employeeRepositoryMock;
    
   @InjectMocks 
   private EmployeeServiceImpl employeeServiceMock; 
   
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveEmployee method, of class EmployeeServiceImpl.
     */
    @Test
    public void testSaveEmployee() throws Exception {
        System.out.println("saveEmployee");
        Employee employee = new Employee();
        employee.setEmployeeName("Emp-1");
        EmployeeServiceImpl instance =employeeServiceMock;
        ResultEntity expResult = null;
        Mockito.when(employeeRepositoryMock.save(employee)).thenReturn(employee); 
        ResultEntity result = instance.saveEmployee(employee);
        assertEquals(RESULT.SUCCESS,result.getResult());
    }

    /**
     * Test of updateEmpPercentage method, of class EmployeeServiceImpl.
     */
    @Test
    public void testUpdateEmpPercentage() throws Exception {
        System.out.println("updateEmpPercentage");
        String place = "abc";
        Float percentage = 10.0f;
        EmployeeServiceImpl instance = employeeServiceMock;
        ResultEntity expResult = new ResultEntity();
        expResult.setResult(ResultEntity.RESULT.SUCCESS);
        List<Employee> empList=new ArrayList<>();
        Employee e=new Employee();
        e.setSalary(30000.00f);
       e.setPlace(place);
       empList.add(e);
      
        ResultEntity result = instance.updateEmpPercentage(place, percentage);
       assertEquals(RESULT.SUCCESS,result.getResult());
    }
    
    @Test
    public void testGetAllEmployees() throws Exception {
        System.out.println("getAllEmployees");
        Integer pageNo = 1;
        Integer pageSize = 5;
        String[] sort = {"employeeId","desc"};
        EmployeeServiceImpl instance =employeeServiceMock;
        ResultEntity result = instance.getAllEmployees(pageNo, pageSize, sort);
        assertEquals(RESULT.SUCCESS,result.getResult());
    }
    
}
