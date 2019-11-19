package com.meric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meric.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class RestfulApiController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(path="/departments" ,method=RequestMethod.GET)
	public List getDepartments(){
		
		return departmentService.getDeparmentsAsList();
	}
	
}
