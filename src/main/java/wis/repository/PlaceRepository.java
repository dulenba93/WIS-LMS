package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wis.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{

}
