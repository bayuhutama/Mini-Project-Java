package com.MiniProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {

	@RequestMapping("profil")
	public String profil() {
		return "profil/profil";
	}
	
	@RequestMapping("dataProfil")
	public String dataProfil() {
		return "profil/dataProfile";
	}
	
	@RequestMapping("ubahDataProfil")
	public String ubahDataProfil() {
		return "profil/ubahData";
	}
	
	@RequestMapping("inputPassLama")
	public String inputPassLama() {
		return "profil/inputPassLama";
	}
	
	@RequestMapping("inputPassBaru")
	public String inputPassBaru() {
		return "profil/inputPassBaru";
	}
	
	@RequestMapping("ubahFoto")
	public String ubahFoto() {
		return "profil/ubahFoto";
	}
	
	@RequestMapping("ubahEmail")
	public String ubahEmail() {
		return "profil/ubahEmail";
	}
	
	@RequestMapping("emailOTP")
	public String emailOTP() {
		return "profil/emailOTP";
	}
}
