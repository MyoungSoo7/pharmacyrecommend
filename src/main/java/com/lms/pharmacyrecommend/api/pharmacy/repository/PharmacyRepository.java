package com.lms.pharmacyrecommend.api.pharmacy.repository;

import com.lms.pharmacyrecommend.api.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
