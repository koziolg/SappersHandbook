package pl.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.handbook.entity.Mine;
import pl.handbook.entity.TypeOfMine;

public interface TypeOfMineRepository extends JpaRepository<TypeOfMine,	Long> {

    TypeOfMine findByMine(Mine mine);
}
