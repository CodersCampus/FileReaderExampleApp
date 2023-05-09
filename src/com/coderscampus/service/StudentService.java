package com.coderscampus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.coderscampus.domain.Student;

public class StudentService {

	public void printListOfBirthdays (List<Student> students) {
		students.stream()
			    .forEach(student -> {
			    	String todaysDate = LocalDate.now()
			    	         					 .format(DateTimeFormatter.ofPattern("MM-DD"));
			    	
			    	String studentBirthdate = student.getBirthdate()
			    									 .format(DateTimeFormatter.ofPattern("MM-DD"));
			    	
			    	if (todaysDate.equals(studentBirthdate))
			    		System.out.println("Happy Birthday " + student.getName());
			    });
	}
}
