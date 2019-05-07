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

import wis.domain.CourseRealization;
import wis.service.CourseRealizationService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseRealization")
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationService crs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseRealization>> getAllCourseRealization() {
		return new ResponseEntity<Iterable<CourseRealization>>(crs.getCourseRealization(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization courseRealization) {
		crs.addCourseRealization(courseRealization);
		return new ResponseEntity<CourseRealization>(courseRealization, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CourseRealization> updateCourseRealization(@PathVariable Long id, @RequestBody CourseRealization courseRealization) {
		crs.updateCourseRealization(id, courseRealization);
		return new ResponseEntity<CourseRealization>(courseRealization, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CourseRealization> getCourseRealizationById(@PathVariable Long id) {
		Optional<CourseRealization> courseRealization = crs.getCourseRealization(id);
		if(courseRealization.isPresent()) {
			return new ResponseEntity<CourseRealization>(courseRealization.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseRealization> removeCourseRealization(@PathVariable Long id) {
		try {
			crs.deleteCourseRealization(id);
		}catch (Exception e) {
			return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseRealization>(HttpStatus.NO_CONTENT);
	}
	
}
