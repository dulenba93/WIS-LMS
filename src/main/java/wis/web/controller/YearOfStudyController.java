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

import wis.domain.YearOfStudy;
import wis.service.YearOfStudyService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/yearOfStudy")
public class YearOfStudyController {
	
	@Autowired
	YearOfStudyService yoss;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<YearOfStudy>> getAllYearOfStudy() {
		return new ResponseEntity<Iterable<YearOfStudy>>(yoss.getYearOfStudy(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<YearOfStudy> addYearOfStudy(@RequestBody YearOfStudy yearOfStudy) {
		yoss.addYearOfStudy(yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<YearOfStudy> updateYearOfStudy(@PathVariable Long id, @RequestBody YearOfStudy yearOfStudy) {
		yoss.updateYearOfStudy(id, yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<YearOfStudy> getYearOfStudyById(@PathVariable Long id) {
		Optional<YearOfStudy> yearOfStudy = yoss.getYearOfStudy(id);
		if(yearOfStudy.isPresent()) {
			return new ResponseEntity<YearOfStudy>(yearOfStudy.get(), HttpStatus.OK);
		}
		return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<YearOfStudy> removeYearOfStudy(@PathVariable Long id) {
		try {
			yoss.deleteYearOfStudy(id);
		}catch (Exception e) {
			return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<YearOfStudy>(HttpStatus.NO_CONTENT);
	}
	
}
