package com.coderscampus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.coderscampus.domain.Student;

public class StudentService {

	public void printListOfBirthdays (List<Student> students) {
		boolean weHaveABirthday = false;
		for ( Student student : students ) {
			String todaysDate = LocalDate.now()
								 .format(DateTimeFormatter.ofPattern("MM-dd"));
			
			String studentBirthdate = student.getBirthdate()
									 .format(DateTimeFormatter.ofPattern("MM-dd"));
			
			if (todaysDate.equals(studentBirthdate)) { 
				System.out.println("Happy Birthday " + student.getName());
				weHaveABirthday = true;
			}
		}
		
		if (!weHaveABirthday) {
			System.out.println("No birthdays today");
		}
	}
}
