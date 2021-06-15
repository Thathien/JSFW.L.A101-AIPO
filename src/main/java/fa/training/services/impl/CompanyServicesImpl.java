package fa.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Company;
import fa.training.repository.CompanyRepository;
import fa.training.services.CompanyServices;

@Service
public class CompanyServicesImpl implements CompanyServices{

	@Autowired
	private CompanyRepository comRepo;
	
	@Override
	public List<Company> getAllList() {
		// TODO Auto-generated method stub
		return comRepo.findAll();
	}

	@Override
	public Company getByID(int id) {
		// TODO Auto-generated method stub
		return comRepo.getOne(id);
	}

}
