package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository administratorRepository;

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
}
