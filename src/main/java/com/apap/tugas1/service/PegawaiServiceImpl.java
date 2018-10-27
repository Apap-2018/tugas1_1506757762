package com.apap.tugas1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
	
	@Autowired
	
	PegawaiDb pegawaiDb;
	
	@Override
	public PegawaiModel getPegawaiByNip(String nip) {
		// TODO Auto-generated method stub
		return pegawaiDb.findPegawaiByNipEquals(nip);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		// TODO Auto-generated method stub
		pegawaiDb.save(pegawai);
		
	}

	@Override
	public PegawaiModel getPegawaiTua(Long id) {
		// TODO Auto-generated method stub
		List<PegawaiModel> listPegawai = pegawaiDb.findAllByInstansi_id(id);
		PegawaiModel pegawaiTua = listPegawai.get(0);
		
		for(PegawaiModel pegawai : listPegawai) {
			
			if(pegawaiTua.getTanggal_lahir().compareTo(pegawai.getTanggal_lahir())>0) {
				pegawaiTua = pegawai;
			}
		}
		
		return pegawaiTua;
	}

	@Override
	public PegawaiModel getPegawaiMuda(Long id) {
		// TODO Auto-generated method stub
		List<PegawaiModel> listPegawai = pegawaiDb.findAllByInstansi_id(id);
		PegawaiModel pegawaiMuda = listPegawai.get(0);
		
		for(PegawaiModel pegawai : listPegawai) {
			
			if(pegawaiMuda.getTanggal_lahir().compareTo(pegawai.getTanggal_lahir())<0) {
				pegawaiMuda = pegawai;
			}
		}
		
		return pegawaiMuda;
	}

}


