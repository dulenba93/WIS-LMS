package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Admin;;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

}
