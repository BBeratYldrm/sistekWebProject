package com.berat.sistek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berat.sistek.model.Barcode;

@Repository("barcodeRepository")
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {

	Barcode findBarcodeByUserId(long id);

}
