package pl.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.handbook.entity.Mine;

public interface MineRepository extends JpaRepository<Mine,	Long> {
     Mine findByName(String name);
}
