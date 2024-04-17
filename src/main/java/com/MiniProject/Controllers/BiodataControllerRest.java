package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.BiodataModel;
import com.MiniProject.Services.BiodataServices;

@RestController
@RequestMapping(value="api/biodata")
public class BiodataControllerRest {

	@Autowired
	private BiodataServices bs;
	
	@GetMapping("biodataById/{id}")
	public BiodataModel biodataById(@PathVariable int id){
		return bs.biodataById(id);
	}
	
	@PutMapping("ubahGambar")
	public String ubahGambar(@RequestBody BiodataModel bm) {
		String result="1";
		bs.ubahGambar(bm.getId(), "/gbr/"+ bm.getImagePath());
		return result;
	}
}
