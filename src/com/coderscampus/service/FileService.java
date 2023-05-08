package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
			ArrayList<String> data = (ArrayList<String>) Files.readAllLines(path);
			
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
					System.out.println(student);
				});
			
			// Step 3: Output the data
			for ( int i = 0; i < data.size(); i++ ) {
//				System.out.println(data.get(i));
			}
			
			// Step 4: Profit
		} catch (IOException e) {
			System.out.println("Oops, there was a problem reading the file");
			e.printStackTrace();
		} 
	}
}
