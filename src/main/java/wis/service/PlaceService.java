package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Place;
import wis.repository.PlaceRepository;

@Service
public class PlaceService {
	@Autowired
	PlaceRepository pr;

	public PlaceService() {
	}

	public Iterable<Place> getPlace() {
		return pr.findAll();
	}

	public Optional<Place> getPlace(Long id) {
		return pr.findById(id);
	}

	public void addPlace(Place place) {
		pr.save(place);
	}

	public void deletePlace(Long id) {
		Optional<Place> place = pr.findById(id);
		pr.delete(place.get());
	}
	
	public void updatePlace(Long id, Place place) {
		Optional<Place> plc = pr.findById(id);
		if(plc.isPresent()) {
			place.setId(plc.get().getId());
			pr.save(place);
		}
	}
}