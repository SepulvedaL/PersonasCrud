package com.api.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.api.crud.model.Pais;
import com.api.crud.repository.PaisRepository;

@Service
public class PaisService {
	

	@Autowired
	private PaisRepository paisRepository;


	public List<Pais> findAll() {
		return paisRepository.findAll();
	}


}
