package com.berat.sistek.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berat.sistek.model.Barcode;
import com.berat.sistek.service.BarcodeService;

@RestController
@RequestMapping("barcodeRest")
public class BarcodeRestController {

	@Autowired
	private BarcodeService barcodeService;

	@PostMapping("/add")
	public void saveBarcode(Barcode barcode) {
		barcodeService.saveBarcode(barcode);
	}

	@GetMapping("/all")
	public List<Barcode> getAllBarcodes() {
		return barcodeService.findAllBarcodes();

	}
}
