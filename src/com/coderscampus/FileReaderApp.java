package com.coderscampus;

import java.io.IOException;
import java.nio.file.Path;

import com.coderscampus.service.FileService;

public class FileReaderApp {

	public static void main(String[] args) {
		FileService fileService = FileService.getInstance();
		
		fileService.printFileContentsToConsole(Path.of("sample-data.txt"));
		
	}

}
