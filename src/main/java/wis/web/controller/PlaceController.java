package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Place;
import wis.service.PlaceService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	PlaceService ps;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Place>> getAllPlace() {
		return new ResponseEntity<Iterable<Place>>(ps.getPlace(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {
		ps.addPlace(place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
		ps.updatePlace(id, place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
		Optional<Place> place = ps.getPlace(id);
		if(place.isPresent()) {
			return new ResponseEntity<Place>(place.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Place> removePlace(@PathVariable Long id) {
		try {
			ps.deletePlace(id);
		}catch (Exception e) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
	
}
