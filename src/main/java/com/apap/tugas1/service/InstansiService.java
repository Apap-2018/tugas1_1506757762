package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface InstansiService {
	InstansiModel geInstansi(long id);
	List<PegawaiModel> getListPegawai(long id);
	List<InstansiModel> viewAllInstansi();
}
