package com.MiniProject;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MiniProject.Controllers.FileControllerRest;

@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		new File(FileControllerRest.uploadingDir).mkdir();
		SpringApplication.run(MiniProjectApplication.class, args);
	}

}
