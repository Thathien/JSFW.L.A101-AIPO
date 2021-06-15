package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
