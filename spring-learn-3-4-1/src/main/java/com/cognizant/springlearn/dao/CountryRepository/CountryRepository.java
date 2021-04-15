package com.cognizant.springlearn.dao.CountryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
