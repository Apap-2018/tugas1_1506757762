package com.apap.tugas1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService {
	
	@Autowired
	JabatanDb jabatanDb;

	@Override
	public List<JabatanModel> viewAllJabatan() {
		// TODO Auto-generated method stub
		
		return jabatanDb.findAll();
	}

	@Override
	public JabatanModel getJabatanByid(Long id) {
		// TODO Auto-generated method stub
		if(jabatanDb.findById(id).isPresent()) {
			return jabatanDb.findById(id).get();
	}return null;
		
	}

	@Override
	public void updateJabatan(JabatanModel jabatan) {
		// TODO Auto-generated method stub
		JabatanModel jabatanlama = jabatanDb.findById(jabatan.getId()).get();
		jabatanlama.setNama(jabatan.getNama());
		jabatanlama.setDeskripsi(jabatan.getDeskripsi());
		jabatanlama.setGaji_pokok(jabatan.getGaji_pokok());
		jabatanDb.save(jabatanlama);
		
	}

	@Override
	public void deleteJabatan(Long id) {
		// TODO Auto-generated method stub
		jabatanDb.deleteById(id);
		
	}

	@Override
	public void addJabatan(JabatanModel jabatan) {
		// TODO Auto-generated method stub
		jabatanDb.save(jabatan);
		
	}
	

	
	
	
	
}
