package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;

@Controller
public class PegawaiController {
	
	@Autowired
	ProvinsiService provinsiService;
	
	@Autowired
	JabatanService jabatanService;
	
	@Autowired 
	InstansiService instansiService;
	
	@Autowired
	PegawaiService pegawaiService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("jabatan",jabatanService.viewAllJabatan());
		model.addAttribute("instansi", instansiService.viewAllInstansi());
		
		return "home";
	
	}

	@RequestMapping(value = "/pegawai-tuamuda" , method = RequestMethod.GET)
	private String instansiTuaMuda(@RequestParam ("id") long id, Model model) {
	
		model.addAttribute("tua", pegawaiService.getPegawaiTua(id));
		model.addAttribute("muda", pegawaiService.getPegawaiMuda(id));
		
		return "pegawai-tuamuda";
	}

	
	@RequestMapping(value = "/jabatan" , method = RequestMethod.GET)
	private String jabatanDetail(@RequestParam ("id") long id, Model model) {
	
		model.addAttribute("jabatan", jabatanService.getJabatanByid(id));
		
		return "jabatan";
	}
	@RequestMapping(value="/jabatan/jabatan-update", method=RequestMethod.GET)
	private String updateJabatan1(@RequestParam("id")long id, Model model) {
		model.addAttribute("jabatan", jabatanService.getJabatanByid(id));
		return "jabatan-update";
	}
	@RequestMapping(value="/jabatan/jabatan-update", method=RequestMethod.POST)
	private String updateJabatan2(@RequestParam(value = "id", required = false) Long id,  @ModelAttribute JabatanModel jabatan,Model model, RedirectAttributes redirectAttributes) {
		jabatanService.updateJabatan(jabatan);
		
		redirectAttributes.addAttribute("id", id);
		return "redirect:/jabatan";
	}
	
	@RequestMapping(value ="/jabatan/delete", method = RequestMethod.GET)
	private String deleteJabatan(@RequestParam("id")Long id, Model model) {
		try {
			jabatanService.deleteJabatan(id);
		}catch(Exception e){
			model.addAttribute("message","data tidak bisa di delete");
		}	
		return "message";
	}
	
	@RequestMapping("/view-all-jabatan")
	private String viewAllJabatan(JabatanModel jabatan, Model model) {
		model.addAttribute("jabatan", jabatanService.viewAllJabatan());
		
		return "view-all-jabatan";
	}
	@RequestMapping(value = "/jabatan-add", method=RequestMethod.GET)
	private String addJabatan(Model model) {
		model.addAttribute("jabatan", new JabatanModel());
		return "jabatan-add";
	}
	
	@RequestMapping(value = "/jabatan-add", method = RequestMethod.POST)
	private String addJabatan(@ModelAttribute JabatanModel jabatan, RedirectAttributes redirectAttributes) {
		jabatanService.addJabatan(jabatan);
		
		//redirectAttributes.addAttribute("id", id);
		return "home";
	}
	@RequestMapping(value="/pegawai", method= RequestMethod.GET)
	private String pegawaiDetail(@RequestParam ("nip") String nip, Model model) {
		model.addAttribute("pegawai", pegawaiService.getPegawaiByNip(nip));
		
		return "pegawai";
	}
	
	@RequestMapping(value="pegawai-add", method=RequestMethod.GET)
	private String addPegawai(Model model) {
		model.addAttribute("pegawai", new PegawaiModel());
		model.addAttribute("provinsi", provinsiService.viewAllProvinsi());
		return "pegawai-add";
	}
	
	@RequestMapping(value="/pegawai-add/instansi", method = RequestMethod.GET)
	@ResponseBody
	private List<InstansiModel> pegawaiInstansi(@RequestParam(value="idProvinsi") Integer idProvinsi){
		return provinsiService.getProvinsiById(idProvinsi).getListInstansi();
	}
//	@RequestMapping(value = "/jabatan-add", method=RequestMethod.GET)
//	private String addJabatan(Model model) {
//		model.addAttribute("jabatan", new JabatanModel());
//		return "jabatan-add";
//	}
//	
//	@RequestMapping(value = "/jabatan-add", method = RequestMethod.POST)
//	private String addJabatan(@ModelAttribute JabatanModel jabatan, RedirectAttributes redirectAttributes) {
//		jabatanService.addJabatan(jabatan);
//		
//		//redirectAttributes.addAttribute("id", id);
//		return "home";
//	}
	
	
}
