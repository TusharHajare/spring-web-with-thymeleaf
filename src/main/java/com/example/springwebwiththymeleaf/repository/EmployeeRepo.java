package com.example.springwebwiththymeleaf.repository;

import com.example.springwebwiththymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{

}
