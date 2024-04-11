package com.example.springwebwiththymeleaf.controller;

import com.example.springwebwiththymeleaf.entity.Employee;
import com.example.springwebwiththymeleaf.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeRepo employeeRepo;

    //1.By using this method we will get all data which is inserted in database
    @GetMapping({"/employees","/" ,"/list"})
    public ModelAndView showDataList()
    {
        ModelAndView mav = new ModelAndView("Employee-list");
        List<Employee> list=employeeRepo.findAll();
        mav.addObject("employees", list);
        return mav;
    }
    //2.add the button and link "/addEmployeeForm" this url to create a form and store data of each employee
    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm()
    {
      ModelAndView mav=new ModelAndView("add-employee-form");
      Employee newEmployee=new Employee();
      mav.addObject("employee", newEmployee);
      return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee)
    {
        employeeRepo.save(employee);
        return "redirect:/list";
    }

    //3.If i want to update the data then use get method to get the data through perticular id
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int employeeId)
    {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = employeeRepo.findById(employeeId).get();
        mav.addObject("employee", newEmployee);
        return mav;
    }
    //4. create a delete button - by ID
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int employeeId)
    {
        employeeRepo.deleteById(employeeId);
        return "redirect:/list";
    }




}
