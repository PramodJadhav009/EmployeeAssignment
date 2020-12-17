package com.assignment.emp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPLOYEE")
@JsonInclude(Include.NON_NULL)
@ApiModel
public class Employee extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId")
    @ApiModelProperty(value = "employeeId", example = "1") 
    private long employeeId;

    @Column(nullable = false)
    @NotBlank(message = "employeeName can't be blank")
    @ApiModelProperty(value = "employeeName", example = "TestEmployee")
    private String employeeName;

    @Column
    @ApiModelProperty(value = "title", example = "Mr.")
    private String title;

    @Column
    @ApiModelProperty(value = "businessUnit", example = "Unit-1")
    private String businessUnit;

    @Column
    @ApiModelProperty(value = "place", example = "Pune")
    private String place;

    @Column
    @ApiModelProperty(value = "supervisorID", example = "11")
    private String supervisorID;

    @Column
    @ApiModelProperty(value = "competencies", example = "competencies")
    private String competencies;

    @Column
    @ApiModelProperty(value = "salary", example = "30000.00")
    private Float salary;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

}
