package com.mohan.practise;

public class Employee {

    private int empId;
    private String empName;
    private String department;
    private int codeCommit;

    public Employee(int empId, String empName, String department, int codeCommit) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.codeCommit = codeCommit;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCodeCommit() {
        return codeCommit;
    }

    public void setCodeCommit(int codeCommit) {
        this.codeCommit = codeCommit;
    }
}
