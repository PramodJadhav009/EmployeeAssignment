package com.assignment.emp.service;

import com.assignment.emp.entity.Employee;
import org.springframework.web.multipart.MultipartFile;
import com.assignment.emp.exceptions.ApplicaionException;
import com.assignment.emp.model.ResultEntity;

public interface EmployeeService {
     ResultEntity saveEmployee(Employee employee) throws ApplicaionException;
    
     ResultEntity updateEmpPercentage(String place, Float percentage)throws ApplicaionException;
     
     ResultEntity getAllEmployees(Integer pageNo, Integer pageSize, String[] sort)throws ApplicaionException;
}
