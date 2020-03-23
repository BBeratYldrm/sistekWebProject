package com.berat.sistek.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berat.sistek.model.Barcode;
import com.berat.sistek.repositories.BarcodeRepository;
import com.berat.sistek.service.BarcodeService;

@Service("barcodeService")
public class BarcodeServiceImpl implements BarcodeService {

	@Autowired
	private BarcodeRepository barcodeRepository;

	@Override
	public void saveBarcode(Barcode barcode) {
		barcodeRepository.save(barcode);
	}

	@Override
	public List<Barcode> findAllBarcodes() {
		List<Barcode> barcodeList = barcodeRepository.findAll();
		return barcodeList;
	}

	@Override
	public List<Barcode> findByUserId(long id) {
		barcodeRepository.findById(id);
		return null;
	}

}
