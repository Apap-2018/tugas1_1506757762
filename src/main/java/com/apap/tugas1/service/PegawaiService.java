package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
	
	PegawaiModel getPegawaiByNip(String nip);
	void addPegawai(PegawaiModel pegawai);
	PegawaiModel getPegawaiTua(Long id);
	PegawaiModel getPegawaiMuda(Long id);
}
