package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministractorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministractorForm setUpInsertAdministratorForm() {
		return new InsertAdministractorForm();
		
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
}
