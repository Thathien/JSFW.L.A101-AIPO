package fa.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Position;
import fa.training.repository.PositionRepository;
import fa.training.services.PositionServices;

@Service
public class PositionServicesImpl implements PositionServices{
	
	@Autowired
	PositionRepository posrepo;

	@Override
	public List<Position> getAll() {
		// TODO Auto-generated method stub
		return posrepo.findAll();
	}

	@Override
	public Position getByID(int id) {
		// TODO Auto-generated method stub
		return posrepo.getOne(id);
	}

}
