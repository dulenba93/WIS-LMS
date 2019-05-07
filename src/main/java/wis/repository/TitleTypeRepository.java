package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.TitleType;

public interface TitleTypeRepository extends JpaRepository<TitleType, Long> {

}
