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

import wis.domain.TypeOfCourse;
import wis.service.TypeOfCourseService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/typeOfCourse")
public class TypeOfCourseController {
	
	@Autowired
	TypeOfCourseService tcs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<TypeOfCourse>> getAllTypeOfCourse() {
		return new ResponseEntity<Iterable<TypeOfCourse>>(tcs.getTypeOfCourse(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<TypeOfCourse> addTypeOfCourse(@RequestBody TypeOfCourse typeOfCourse) {
		tcs.addTypeOfCourse(typeOfCourse);
		return new ResponseEntity<TypeOfCourse>(typeOfCourse, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<TypeOfCourse> updateTypeOfCourse(@PathVariable Long id, @RequestBody TypeOfCourse typeOfCourse) {
		tcs.updateTypeOfCourse(id, typeOfCourse);
		return new ResponseEntity<TypeOfCourse>(typeOfCourse, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TypeOfCourse> getTypeOfCourseById(@PathVariable Long id) {
		Optional<TypeOfCourse> typeOfCourse = tcs.getTypeOfCourse(id);
		if(typeOfCourse.isPresent()) {
			return new ResponseEntity<TypeOfCourse>(typeOfCourse.get(), HttpStatus.OK);
		}
		return new ResponseEntity<TypeOfCourse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<TypeOfCourse> removeTypeOfCourse(@PathVariable Long id) {
		try {
			tcs.deleteTypeOfCourse(id);
		}catch (Exception e) {
			return new ResponseEntity<TypeOfCourse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TypeOfCourse>(HttpStatus.NO_CONTENT);
	}
	
}
