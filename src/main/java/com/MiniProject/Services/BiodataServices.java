package com.MiniProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Models.BiodataModel;
import com.MiniProject.Repository.BiodataRepository;

@Service
@Transactional
public class BiodataServices {

	@Autowired
	private BiodataRepository br;
	
	public BiodataModel biodataById(int id) {
		return br.biodataById(id);
	}
	
	public int ubahNamaNomor(long id,String nama, String noHP) {
		return br.ubahNamaNomor(id, nama, noHP);
	}
	
	public void ubahGambar(long id, String img) {
		br.ubahGambar(id, img);
	}
}
