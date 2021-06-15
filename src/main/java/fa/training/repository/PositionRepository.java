package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Position;
@Repository
public interface PositionRepository extends JpaRepository<Position,Integer>{

}
