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

import wis.domain.Teacher;
import wis.service.TeacherService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService ts;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Teacher>> getAllTeacher() {
		return new ResponseEntity<Iterable<Teacher>>(ts.getTeacher(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		ts.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		ts.updateTeacher(id, teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
		Optional<Teacher> teacher = ts.getTeacher(id);
		if(teacher.isPresent()) {
			return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Teacher> removeTeacher(@PathVariable Long id) {
		try {
			ts.deleteTeacher(id);
		}catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	
}

