package fa.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fa.training.dto.LoginDTO;
import fa.training.entities.User;
import fa.training.repository.UserRepository;
import fa.training.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User login(LoginDTO dto) {
		// TODO Auto-generated method stub
		User user=null;
		List<User> listUsers=userRepo.findAll();
		if(!listUsers.isEmpty()){
			for (User users : listUsers) {
				if(dto.getUsername().equals(users.getLoginName()) && dto.getPass().equals(users.getPasswordValue())){
					user=users;
					break;
				}
			}
		}
		return user;
	}

	@Override
	public List<User> getAllListUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Page<User> paginationUser(Pageable pa) {
		// TODO Auto-generated method stub
		return userRepo.paginationUser(pa);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		
	}

	@Override
	public Page<User> paginationUserOld(int index, int size) {
		// TODO Auto-generated method stub
		return userRepo.paginationUser(PageRequest.of(index, size));
	}

	@Override
	public Page<User> paginationAndSearch(int index, int size, String key) {
		// TODO Auto-generated method stub
		return userRepo.paginationUser(PageRequest.of(index, size,Sort.by(Sort.DEFAULT_DIRECTION.valueOf("trung"))));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public void Active(String action,int idUser,int idauthor) {
		// TODO Auto-generated method stub
		userRepo.Active(action, idUser, idauthor);
	}

	@Override
	public User getByID(int id) {
		// TODO Auto-generated method stub
		return userRepo.getOne(id);
	}



}
