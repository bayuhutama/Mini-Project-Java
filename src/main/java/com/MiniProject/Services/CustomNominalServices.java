package com.MiniProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Models.CustomNominalModel;
import com.MiniProject.Repository.CustomNominalRepository;

@Service
@Transactional
public class CustomNominalServices {

	@Autowired
	private CustomNominalRepository cr;
	
	public List<CustomNominalModel> customById(long id) {
		return cr.customById(id);
	}
	
	public void addCustom(long cid,int nom) {
		cr.addCustom(cid,nom);
	}
	
	public int custNominalByNominal(Integer nom,long cid) {
		return cr.custNominalByNominal(nom,cid);
	}
	
	public int custNominalBydefaultNominal(Integer nom) {
		return cr.custNominalBydefaultNominal(nom);
	}
}
