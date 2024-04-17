package com.MiniProject.Controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MiniProject.Models.BiodataModel;
import com.MiniProject.Services.BiodataServices;

@RestController
@RequestMapping(value="api/file")
public class FileControllerRest {

	public static final String uploadingDir = System.getProperty("user.dir")+"/uploadingDir/";
	
	@Autowired
	private BiodataServices bs;
	
	@PostMapping("upload")
	public void uploadFile(@RequestParam("uploadFiles")MultipartFile[] uploadFiles) throws Exception, IOException{
		for(MultipartFile uploadedFile : uploadFiles){
			int custId=2;
			String gbrImg=uploadedFile.getOriginalFilename().replace(uploadedFile.getOriginalFilename(),"ProfilImgUser"+custId);
			//System.out.println(gbrImg);
			File file= new File(uploadingDir + gbrImg+".jpg");
//			System.out.println(file);
			uploadedFile.transferTo(file);
		}
		

	}

	
	
}
