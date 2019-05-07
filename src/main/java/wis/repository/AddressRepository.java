package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{


}
