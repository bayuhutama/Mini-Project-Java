package com.MiniProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.CustomNominalModel;
import com.MiniProject.Models.NominalWalletModel;
import com.MiniProject.Services.CustomNominalServices;
import com.MiniProject.Services.NominalWalletServices;

@RestController
@RequestMapping(value="api/custom")
public class CustomNominalControllerRest {

	@Autowired
	private CustomNominalServices cs;
	
//	@Autowired
//	private NominalWalletServices ns;

	@GetMapping("customById/{id}")
	public List<CustomNominalModel> customById(@PathVariable int id) {
		return cs.customById(id);
	}

	@PostMapping("addCustom")
	public String addCustom(@RequestBody CustomNominalModel cm){//, @RequestBody NominalWalletModel nm) {
		String result="";
		Integer nominal1 = cs.custNominalByNominal(cm.getNominal(), cm.getCustomerId());
		Integer nominal2 = cs.custNominalBydefaultNominal(cm.getNominal());
		//System.out.println(nominal2);
		if(nominal1==0 & nominal2==0) {
			cs.addCustom(cm.getCustomerId(),cm.getNominal());
			result="1";
		}else {
			result="2";
		}
		return result;
	}
}
