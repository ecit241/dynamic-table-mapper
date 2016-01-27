package com.closer.department.web;

import com.closer.company.service.CompanyService;
import com.closer.department.domain.Department;
import com.closer.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门Controller
 * Created by closer on 2016/1/20.
 */
@RestController
@RequestMapping("/companies")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.GET)
    public Department get(@PathVariable("companyId") long companyId,
                          @PathVariable("departmentId") long departmentId) {
        return service.findOne(departmentId);
    }

    @RequestMapping(value = "/{companyId}/departments", method = RequestMethod.GET)
    public List<Department> list(@PathVariable long companyId) {
        return service.findAll();
    }

    @RequestMapping(value = "/{companyId}/departments", method = RequestMethod.POST)
    public Department add(@PathVariable long companyId, @RequestBody Department department) {
        return service.add(department);
    }
}
