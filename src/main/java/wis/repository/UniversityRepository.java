package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.University;

public interface UniversityRepository extends JpaRepository<University, Long>{

}
