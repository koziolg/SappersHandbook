package pl.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.handbook.entity.Fuze;

public interface FuzeRepository extends JpaRepository<Fuze,	Long> {
}
