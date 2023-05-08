package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
			
			System.out.println( Files.readAllLines(path) );
			throw new IllegalArgumentException(); // Note: this is not real-world code, you wouldn't just throw
			                                      // an exception like this for no reason.
		} catch (IOException e) {
			System.out.println("Oops, there was a problem reading the file");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Hey there, we caught the IllegalArgumentException, aren't we silly");
			e.printStackTrace();
		}
	}
}
