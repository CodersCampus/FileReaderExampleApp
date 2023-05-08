package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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
			
			// Step 3: Output the data
			for ( int i = 0; i < data.size(); i++ ) {
				System.out.println(data.get(i));
			}
			
			// Step 4: Profit
		} catch (IOException e) {
			System.out.println("Oops, there was a problem reading the file");
			e.printStackTrace();
		} 
	}
}
