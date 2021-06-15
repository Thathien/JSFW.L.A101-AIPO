package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer>{

}
