package com.example.petMate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petMate.domain.Item;
import com.example.petMate.service.PetMateFacade;

public class AdoptFormController {
	private static Logger logger = LoggerFactory.getLogger(AdoptFormController.class);

	@Autowired
	private PetMateFacade petmate;
	

}
