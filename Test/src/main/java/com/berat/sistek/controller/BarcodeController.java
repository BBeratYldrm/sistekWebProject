package com.berat.sistek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berat.sistek.model.Barcode;
import com.berat.sistek.service.BarcodeService;

@Controller
public class BarcodeController {

	@Autowired
	private BarcodeService barcodeService;

	@RequestMapping("/allBarcodes")
	public String getAllBarcodes(Model model) {
		model.addAttribute("barcodes", barcodeService.findAllBarcodes());
		return "user/barcodesList";

	}

	@RequestMapping("/myBarcodes/{id}")
	public String getAllBarcodes(@PathVariable long id, Model model) {
		List<Barcode> myBarcodes = barcodeService.findByUserId(id);
		model.addAttribute("myBarcodes", myBarcodes);
		return "user/myBarcodes";

	}

}
