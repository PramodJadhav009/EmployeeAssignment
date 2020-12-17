package com.assignment.emp.service.impl;

import com.assignment.emp.entity.Employee;
import com.assignment.emp.exceptions.ApplicaionException;
import com.assignment.emp.model.ResultEntity;
import com.assignment.emp.model.ResultEntity.RESULT;
import com.assignment.emp.repository.EmployeeRepository;
import com.assignment.emp.service.EmployeeService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResultEntity saveEmployee(Employee employee) throws ApplicaionException {
        ResultEntity resultEntity = new ResultEntity();
        try {
            Employee dbEmp = employeeRepository.save(employee);
            resultEntity.setEntity(dbEmp);
            resultEntity.setResult(RESULT.SUCCESS);
            resultEntity.setMessage("Employee add successfull which id new is " + dbEmp.getEmployeeId());
        } catch (RuntimeException e) {
            resultEntity.setException(e);
            resultEntity.setResult(RESULT.EXCEPTION);
        }
        return resultEntity;
    }

    @Override
    public ResultEntity updateEmpPercentage(String place, Float percentage) throws ApplicaionException {
        logger.debug("Start updateEmpPercentage " + place + " " + percentage);
        ResultEntity resultEntity = new ResultEntity();
        if (percentage > 55) {
            throw new ApplicaionException("percentage value caanot more than 55 %");
        }

        try {
            Optional<List<Employee>> optional = employeeRepository.findEmployeeByPlace(place);
            if (optional.isPresent()) {
                List<Employee> list = optional.get();
                for (Employee e : list) {
                    Float salary = e.getSalary();
                    salary = salary + (salary * percentage / 100);
                    employeeRepository.updateEmployeeSalary(e.getEmployeeId(), salary);
                }
            }
            resultEntity.setResult(RESULT.SUCCESS);

        } catch (RuntimeException e) {
            resultEntity.setException(e);
            resultEntity.setResult(RESULT.EXCEPTION);
        } catch (Exception e) {
              logger.error(e.getLocalizedMessage(), e);
            resultEntity.setException(e);
            resultEntity.setResult(RESULT.EXCEPTION);
        }
        logger.debug("End updateEmpPercentage ");
        return resultEntity;
    }

    @Override
    public ResultEntity getAllEmployees(Integer pageNo, Integer pageSize, String[] sort) throws ApplicaionException {
        ResultEntity resultEntity = new ResultEntity();
        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));
            Page<Employee> pagedResult = employeeRepository.findAll(paging);
            if (pagedResult!=null && pagedResult.hasContent()) {
                resultEntity.setEntity(pagedResult.getContent());
                resultEntity.setResult(RESULT.SUCCESS);
            } else {
                resultEntity.setEntity(Collections.EMPTY_LIST);
                resultEntity.setResult(RESULT.SUCCESS);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultEntity.setException(e);
            resultEntity.setResult(RESULT.EXCEPTION);
        }
        return resultEntity;
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
}
