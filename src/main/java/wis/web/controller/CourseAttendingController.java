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

import wis.domain.CourseAttending;
import wis.service.CourseAttendingService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseAttending")
public class CourseAttendingController {
	
	@Autowired
	CourseAttendingService cas;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseAttending>> getAllCourseAttending() {
		return new ResponseEntity<Iterable<CourseAttending>>(cas.getCourseAttending(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending courseAttending) {
		cas.addCourseAttending(courseAttending);
		return new ResponseEntity<CourseAttending>(courseAttending, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CourseAttending> updateCourseAttending(@PathVariable Long id, @RequestBody CourseAttending courseAttending) {
		cas.updateCourseAttending(id, courseAttending);
		return new ResponseEntity<CourseAttending>(courseAttending, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CourseAttending> getCourseAttendingById(@PathVariable Long id) {
		Optional<CourseAttending> courseAttending = cas.getCourseAttending(id);
		if(courseAttending.isPresent()) {
			return new ResponseEntity<CourseAttending>(courseAttending.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseAttending> removeCourseAttending(@PathVariable Long id) {
		try {
			cas.deleteCourseAttending(id);
		}catch (Exception e) {
			return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseAttending>(HttpStatus.NO_CONTENT);
	}
	
}
