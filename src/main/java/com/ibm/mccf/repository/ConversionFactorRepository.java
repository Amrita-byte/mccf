package com.ibm.mccf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mccf.model.CurrencyConversionFactor;
@Repository
public interface ConversionFactorRepository extends JpaRepository<CurrencyConversionFactor, String> {

}
