package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
