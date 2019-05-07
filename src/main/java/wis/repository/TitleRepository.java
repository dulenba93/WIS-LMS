package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {

}
