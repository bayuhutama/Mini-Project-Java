package com.MiniProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Models.NominalWalletModel;
import com.MiniProject.Repository.NominalWalletRepository;
import com.sun.istack.Nullable;

@Service
@Transactional
public class NominalWalletServices {


	@Autowired
	private NominalWalletRepository wr;

	public List<NominalWalletModel>ListNominal(){
		return wr.ListNominal();
	}
	
	public void addNominal(Integer nom, long cb) {
		wr.addNominal(nom, cb);
	}
	
	public void editNominal(long id,Integer nom, long mb) {
		wr.editNominal(id, nom, mb);
	}

	public void deleteNominal(long id,long db) {
		wr.deleteNominal(id,db);
	}

	public int nominalByNominal(Integer nom) {
		return wr.nominalByNominal(nom);
	}
	
	public List<NominalWalletModel>searchNominal(String nom) {
		return wr.searchNominal(nom);
	}
	
	public NominalWalletModel nominalById(int id){
		return wr.nominalById(id);
	}
	

}
