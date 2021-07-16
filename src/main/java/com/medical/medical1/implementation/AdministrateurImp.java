package com.medical.medical1.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.repository.AdministrateurRepository;
import com.medical.medical1.service.IAdministrateurService;

@Service
public class AdministrateurImp implements IAdministrateurService {
	@Autowired
	AdministrateurRepository admiRepo;
}
