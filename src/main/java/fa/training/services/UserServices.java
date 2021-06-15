package fa.training.services;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.dto.LoginDTO;
import fa.training.entities.User;

public interface UserServices {
	public User login(LoginDTO dto);
	public List<User> getAllListUser();
	Page<User> paginationUser(Pageable pa);
	void save(User user);
	void delete(int id);
	public void Active(String action,int idUser,int idauthor);
	Page<User> paginationUserOld(int index, int size);
	Page<User> paginationAndSearch(int index, int size,String key);
	public User getByID(int id);
}
