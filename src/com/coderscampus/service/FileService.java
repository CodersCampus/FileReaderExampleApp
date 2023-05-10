package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.domain.Student;

public class FileService {
	
	private static FileService fileService = null;
	
	private FileService () {
		
	}
	
	public static FileService getInstance () {
		if (fileService == null) {
			fileService = new FileService();	
		}
		return fileService;
	}
	
	public void printFileContentsToConsole (Path path) {
		try {
			
			// Step 1: Read data in
			List<String> data = Files.readAllLines(path);
			List<Student> students = new ArrayList<>();
			
			// Step 2: do something useful with the data
			data.stream()
				.skip(1)
				.forEach((String lineOfData) -> {
					Student student = new Student();
					String[] studentData = lineOfData.split(",");
					// studentData = 3 "boxes / buckets / nodes" of data
					// i.e. [1001, John Smith, 2002-01-01]
					student.setId(Integer.parseInt(studentData[0])); // studentId
					student.setName(studentData[1]); // studentName
					student.setBirthdate(LocalDate.parse(studentData[2], DateTimeFormatter.ISO_DATE)); // studentBirthdate
					students.add(student);
				});
			
			// Step 3: Output the happy birthday messages
			StudentService studentService = new StudentService();
			studentService.printListOfBirthdays(students);
			
		} catch (IOException e) {
			System.out.println("Oops, there was a problem reading the file");
			e.printStackTrace();
		} 
	}
}
