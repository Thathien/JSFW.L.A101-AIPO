package fa.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.dto.LoginDTO;
import fa.training.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	@Query("select a from User a")
	Page<User> paginationUser(Pageable pa);
	
	@Query(value = "update dbo.[User] set disabled=?1, updated_user_id=?3 where user_id=?2",nativeQuery = true)
	public void Active(String action,int idUser,int idauthor);

}
