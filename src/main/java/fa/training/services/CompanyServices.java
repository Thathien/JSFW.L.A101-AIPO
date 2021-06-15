package fa.training.services;

import java.util.List;

import fa.training.entities.Company;

public interface CompanyServices {
	public List<Company> getAllList();
	public Company getByID(int id);
}
