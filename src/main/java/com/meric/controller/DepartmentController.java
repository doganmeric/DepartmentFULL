package com.meric.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meric.entity.Department;
import com.meric.entity.Employee;
import com.meric.entity.Location;
import com.meric.service.DepartmentService;
import com.meric.service.EmployeeService;
import com.meric.service.LocationService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LocationService locationService;
	
	List<Employee> employees;
	List<Location> locations;
	List<Department> myDepartments;
	@GetMapping("/list")
	public String listDepartments(Model model) {
		
		myDepartments = departmentService.getDeparmentsAsList();
		employees =employeeService.getEmployeesAsList();
		locations =locationService.getLocationsAsList();
		model.addAttribute("departments", myDepartments);
		model.addAttribute("employees",employees);
		model.addAttribute("locations", locations);
		
		return "list-departments";
	}
	
	@GetMapping("/addDepartmentForm")
	public String addDepartmentForm(Model model) {
		
		Department department  = new Department();
		model.addAttribute("department",department);
		model.addAttribute("employees",employees);
		model.addAttribute("locations", locations);
		model.addAttribute("mode", true);
		return "department-form";
	}
	
	
	
	
	@RequestMapping("/saveOrUpdateDepartment")
	public String saveOrUpdateDepartment(@Valid @ModelAttribute("department") Department department,
											BindingResult bindingResult,
											@Valid @RequestParam("managerId") Integer managerId,
											@RequestParam("locationId") Integer locationId,
											@RequestParam("mode") Boolean mode,
											Model model) {
		
		myDepartments = departmentService.getDeparmentsAsList();
		myDepartments.forEach( tempdepartment-> {				
				if(tempdepartment.getDepartmentName().equals(department.getDepartmentName())&&mode==true) {
					bindingResult.rejectValue("departmentName","error.department.depName","Department name must be unique");
				}
				if(tempdepartment.getManager()!=null) {
					if(tempdepartment.getManager().getId().equals(managerId)) {
						model.addAttribute("errorMsg", "Bu manager "+tempdepartment.getDepartmentName()+" departmanının yöneticisi, kaydedilmedi");
						model.addAttribute("mode",mode);
						bindingResult.rejectValue("manager","error.department.manager",
							"Bu manager"+tempdepartment.getDepartmentName()+" departmanının yöneticisi, kaydedilmedi");
					}
				}
			});
		
		
		if((locationId!=null&&locationId!=-1111)) {
		department.setLocation(locationService.getLocation(locationId));
		}
		if((managerId!=null&&managerId!=-1111)) {
		department.setManager(employeeService.getEmployee(managerId));
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("employees",employees);
			model.addAttribute("locations", locations);
			
			model.addAttribute("mode", mode);
			return "department-form";
		}
		else {
			departmentService.saveOrUpdate(department);
			return "redirect:/department/list";
		}
		
		
		
	}
	
	@RequestMapping(value="/updateOrDeleteDepartments",params = "Update", method =RequestMethod.POST)
	public String updateDepartmentForm( @RequestParam("radioButton") Integer departmentId, Model model) {
		
		
		model.addAttribute("department",departmentService.getDepartment(departmentId));
		model.addAttribute("employees",employees);
		model.addAttribute("locations", locations);
		model.addAttribute("mode",false);
		return "department-form";
	}
	
	@RequestMapping(value="/updateOrDeleteDepartments",params="Delete",method = RequestMethod.POST)
	public String deleteDepartment(@RequestParam("radioButton") Integer departmentId,Model model) {
		//TODO düzelt buraları
		List<Employee> empList =employeeService.getEmployeesAsList();
		int asso=0;
		for(int i = 0;i<empList.size();i++) {
		
			//System.out.println(empList.get(i).getDepartment_id()+" "+departmentId);
			Integer empDep =empList.get(i).getDepartment_id();
			if(empDep!=null&&empDep.equals(departmentId)) {				
				asso++;		
			}

		}
		if(asso>0) {
			//TODO hata kontrol mesajı
			model.addAttribute("errorMsg","Bu departmanın "+asso+" adet çalışanı vardır silinemez.");
			
		}

		else if(asso==0){
			departmentService.delete(departmentId);
		}
		return "redirect:/department/list";
		
		
		
	}
	
	@RequestMapping(value="/searchDepartments",method = RequestMethod.GET)
	public String search(@RequestParam("searchDepName") String searchDepName,
			@RequestParam("searchMngrName") String searchMngrName,
			@RequestParam("searchLocName") String searchLocName,
			Model model) {
		

		
		List<Department> departments = departmentService.searchDepartments(searchDepName,searchMngrName,searchLocName);
		employees =employeeService.getEmployeesAsList();
		locations =locationService.getLocationsAsList();
		model.addAttribute("departments",departments);
		model.addAttribute("employees",employees);
		model.addAttribute("locations", locations);
		
		return "list-departments";
	}

}
