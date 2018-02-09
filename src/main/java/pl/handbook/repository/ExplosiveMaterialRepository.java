package pl.handbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.handbook.entity.ExplosiveMaterial;

public interface ExplosiveMaterialRepository extends JpaRepository<ExplosiveMaterial,	Long> {
}
