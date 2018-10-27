package com.apap.tugas1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;



@SuppressWarnings("serial")
@Entity
@Table(name="provinsi")
public class ProvinsiModel implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(max=255)
	@Column(name="nama", nullable=false)
	private String nama;
	
	@NotNull
	@Size(max=255)
	@Column(name="presentase_tunjangan", nullable=false)
	private double presentase_tunjang;
	

	@OneToMany(mappedBy="provinsi", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private List<InstansiModel> listInstansi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}
   
	public void setNama(String nama) {
		this.nama = nama;
	}



	public double getPresentase_tunjang() {
		return presentase_tunjang;
	}

	public void setPresentase_tunjang(double presentase_tunjang) {
		this.presentase_tunjang = presentase_tunjang;
	}

	public List<InstansiModel> getListInstansi() {
		return listInstansi;
	}

	public List<InstansiModel> getProvIns() {
		return listInstansi;
	}

	public void setListInstansi(List<InstansiModel> listInstansi) {
		this.listInstansi = listInstansi;
	}
	
	
}
