/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.emp.repository;

import com.assignment.emp.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query(value = "SELECT * FROM Employee e where e.place = :place", nativeQuery = true)
    Optional<List<Employee>> findEmployeeByPlace(@Param("place") String place);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update Employee  e SET  e.salary = :salary WHERE  e.employee_Id = :employeeId", nativeQuery = true)
    public void updateEmployeeSalary(@Param("employeeId") Long employeeId, @Param("salary") Float salary);
}
