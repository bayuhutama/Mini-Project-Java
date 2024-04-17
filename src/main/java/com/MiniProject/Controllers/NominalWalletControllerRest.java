package com.MiniProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.NominalWalletModel;
import com.MiniProject.Services.NominalWalletServices;

@RestController
@RequestMapping(value="api/nominal")
public class NominalWalletControllerRest {

	@Autowired
	private NominalWalletServices ws;

	@GetMapping("listNominal")
	public List<NominalWalletModel>ListNominal(){
		return ws.ListNominal();
	}

	@GetMapping("searchNominal/{nom}")
	public List<NominalWalletModel>searchNominal(@PathVariable String nom){
		return ws.searchNominal(nom);
	}

	@GetMapping("nominalById/{id}")
	public NominalWalletModel nominalById(@PathVariable int id){
		return ws.nominalById(id);
	}

	@PostMapping("addNominal")
	public String addNominal(@RequestBody NominalWalletModel wm) {
		//Object idUser = session.getAttribute("idUser");
		Integer nominal1 = ws.nominalByNominal(wm.getNominal());
		//int iduser1=Integer.valueOf(idUser.toString());
		String result="";
		//int Iduser1=1;
		//System.out.println(nominal1);
		if (nominal1==0) {
			ws.addNominal(wm.getNominal(),wm.getId());
			result="1";
		}else {
			result="2";
		}
		return result;
	}

	@PutMapping("editNominal")
	public String editUser(@RequestBody NominalWalletModel wm) {
		//Object idUser = session.getAttribute("idUser");
		//int iduser1=Integer.valueOf(idUser.toString());
		//int Iduser1=1;
		String result="";
		Integer nominal1 = ws.nominalByNominal(wm.getNominal());
		if(nominal1==0) {
			ws.editNominal(wm.getId(),wm.getNominal(), wm.getId());
			result="1";
		}else {
			result="2";
		}
		return result;
	}

	@PutMapping("deleteNominal")
	public void deleteNominal(@RequestBody NominalWalletModel wm) {
		//Object idUser = session.getAttribute("idUser");
		//int iduser1=Integer.valueOf(idUser.toString());
		//int Iduser1=1;
		ws.deleteNominal(wm.getId(),wm.getId());
	}
}
