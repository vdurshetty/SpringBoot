package com.venu;

import org.springframework.web.bind.annotation.RestController;

import com.venu.dto.Emp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
	
	
	List<Emp> empList  = new ArrayList<Emp>();
	
	
	public HelloController() {
		
		Emp emp = new Emp(10,"Venugopal",0.34f);
		Emp emp1 = new Emp(20,"Durshetty",123.49f);
		empList.add(emp);empList.add(emp1);
		System.out.println("In the Constructor : the emplist size is : "+ empList.size());
	}
	

    @RequestMapping(value = {"/greet","/hello"})
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/getEmps", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
    public List<Emp> getEmployees() {
    	System.out.println("Emp List is : " + empList.size());
        return empList;
    }
    
    @RequestMapping(value = "/getEmp",  method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Emp getEmployee(@RequestParam("id") int id) {
    	System.out.println("The Param value is :"+ id);
        return getEmp(id);
    }
    
    private Emp getEmp(int eid) {
    	for (int i=0;i<empList.size();i++) {
    		Emp emp = empList.get(i);
    		if (emp.getEmpid() == eid) {
    			return emp;
    		}
    	}
        return null;
    }

    @RequestMapping(value = "/addEmp", method=RequestMethod.PUT ,produces="text/plain",  consumes="application/json")
    public String addEmployee(@RequestBody Emp emp ) {
       empList.add(emp);	
       return "Employee Successfully Addedd.....";
    }

    @RequestMapping(value = "/deleteEmp", method=RequestMethod.DELETE ,produces="text/plain",  consumes="application/json")
    public String removeEmployee(@RequestBody Emp emp ) {
    	int empid = emp.getEmpid();
    	if (empid<0) {
    		return "empid should be greater than zero";
    	}
       	for (int i=0;i<empList.size();i++) {
    		Emp employee = empList.get(i);
    		if (employee.getEmpid() == emp.getEmpid()) {
    			empList.remove(i);
    			i=empList.size();
    		}
    	}
       return "Employee Successfully Deleted.....";
    }

}


