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

import wis.domain.StudentYear;
import wis.service.StudentYearService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studentYear")
public class StudentYearController {
	
	@Autowired
	StudentYearService sys;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<StudentYear>> getAllStudentYear() {
		return new ResponseEntity<Iterable<StudentYear>>(sys.getStudentYear(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<StudentYear> addStudentYear(@RequestBody StudentYear studentYear) {
		sys.addStudentYear(studentYear);
		return new ResponseEntity<StudentYear>(studentYear, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StudentYear> updateStudentYear(@PathVariable Long id, @RequestBody StudentYear studentYear) {
		sys.updateStudentYear(id, studentYear);
		return new ResponseEntity<StudentYear>(studentYear, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentYear> getStudentYearById(@PathVariable Long id) {
		Optional<StudentYear> studentYear = sys.getStudentYear(id);
		if(studentYear.isPresent()) {
			return new ResponseEntity<StudentYear>(studentYear.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentYear>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentYear> removeStudentYear(@PathVariable Long id) {
		try {
			sys.deleteStudentYear(id);
		}catch (Exception e) {
			return new ResponseEntity<StudentYear>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudentYear>(HttpStatus.NO_CONTENT);
	}
	
}
