package com.MiniProject.Controllers;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Services.BiodataServices;
import com.MiniProject.Services.CustomerServices;

@RestController
@RequestMapping(value="api/profil")
public class ProfilControllerRest {

	@Autowired
	private CustomerServices cs;
	
	@Autowired
	private BiodataServices bs;

	@PutMapping("ubahDataProfil")
	public void ubahDataProfil(@RequestBody Map<String,Object> dt) {
		long id= Long.valueOf(dt.get("biodataId").toString());
		bs.ubahNamaNomor(id, dt.get("fullname").toString(), dt.get("noHP").toString());
		String dob1=dt.get("dob").toString();
		Date dob2=Date.valueOf(dob1);
		cs.ubahDOB(id,dob2);
		
		//int lastIdProvinsi=0;
		//Object idUser = session.getAttribute("idUser");
		//String inGender=dt.get("gender").toString();
		//boolean mayGender=Boolean.parseBoolean(inGender);
		//String hariJadi=dt.get("hariJadi").toString();
		//Date hariJadi1=Date.valueOf(hariJadi);
		//String gambar="/gbr/";
		//ps.addProvinsi(dt.get("namaProvinsi").toString(),mayGender , (gambar+dt.get("gbrSrc")),Integer.valueOf(idUser.toString()));
		//lastIdProvinsi=ps.provinsiLastId();
		//ks.addKota(dt.get("namaKota").toString(), lastIdProvinsi,hariJadi1, dt.get("transportasi").toString());
	}



}
