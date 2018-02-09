package pl.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.handbook.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByName(String name);
}
