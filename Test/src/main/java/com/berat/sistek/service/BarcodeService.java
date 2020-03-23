package com.berat.sistek.service;

import java.util.List;

import com.berat.sistek.model.Barcode;

public interface BarcodeService {

	public List<Barcode> findByUserId(long id);

	public void saveBarcode(Barcode barcode);

	List<Barcode> findAllBarcodes();

}
