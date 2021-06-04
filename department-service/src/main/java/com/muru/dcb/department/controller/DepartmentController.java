package com.muru.dcb.department.controller;

import com.muru.dcb.department.model.Department;
import com.muru.dcb.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController (@Autowired DepartmentService service) {
        this.departmentService = service;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Request for save Department - {}", department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable("id") Long departmentId) {
        log.info("Request for find Department - {}", departmentId);
        return departmentService.findDepartment(departmentId);
    }

}
