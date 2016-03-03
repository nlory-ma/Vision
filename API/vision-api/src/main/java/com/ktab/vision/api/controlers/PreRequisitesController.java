package com.ktab.vision.api.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktab.vision.api.dao.PreRequisitesDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PreRequisitesController {
	@Autowired
	PreRequisitesDao preRequisitesDao;
	
	private static final Logger logger = LoggerFactory.getLogger(PreRequisitesController.class);

	@RequestMapping(value = { "/populate" }, method = RequestMethod.GET)
	public ModelAndView populatePreRequisites() {
		ModelAndView model = new ModelAndView();
		preRequisitesDao.insertRerequisites();
		model.addObject("title", "Prerequisites Populated");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = { "/retrieve" }, method = RequestMethod.GET)
	public ModelAndView retrievePreRequisites() {
		ModelAndView model = new ModelAndView();
		preRequisitesDao.retreveRerequisites();
		model.addObject("title", "Prerequisites Populated");
		model.setViewName("hello");
		return model;

	}
	
	@RequestMapping(value = { "/loginSAdmin" }, method = RequestMethod.GET)
	public ModelAndView loginSAdmin() {
		ModelAndView model = new ModelAndView();
		preRequisitesDao.retreveRerequisites();
		model.addObject("title", "Prerequisites Populated");
		model.setViewName("hello");
		return model;

	}
}
