package com.lms.pharmacyrecommend.pharmacy.repository;

import com.lms.pharmacyrecommend.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
