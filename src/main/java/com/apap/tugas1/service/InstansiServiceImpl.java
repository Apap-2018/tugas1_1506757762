package com.apap.tugas1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.InstansiDb;

@Service
@Transactional
public class InstansiServiceImpl implements InstansiService {
	
	@Autowired
	InstansiDb instansiDb;
	




	@Override
	public InstansiModel geInstansi(long id) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<PegawaiModel> getListPegawai(long id) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<InstansiModel> viewAllInstansi() {
		// TODO Auto-generated method stub
		return instansiDb.findAll();
	}
	 
}
