package com.muru.dcb.department.service;

import com.muru.dcb.department.model.Department;
import com.muru.dcb.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public DepartmentService(@Autowired DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department findDepartment(Long departmentId) {
        return repository.findByDepartmentId(departmentId);
    }
}
