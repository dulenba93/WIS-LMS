package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
	
	

}
