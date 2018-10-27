package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel; 

public interface JabatanService {

		List<JabatanModel> viewAllJabatan();
		JabatanModel getJabatanByid(Long id);
		void addJabatan(JabatanModel jabatan);
		void updateJabatan(JabatanModel jabatan);
		void deleteJabatan(Long id);
}
