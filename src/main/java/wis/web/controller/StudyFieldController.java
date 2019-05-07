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

import wis.domain.StudyField;
import wis.service.StudyFieldService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studyField")
public class StudyFieldController {
	
	@Autowired
	StudyFieldService sfs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<StudyField>> getAllStudyField() {
		return new ResponseEntity<Iterable<StudyField>>(sfs.getStudyField(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<StudyField> addStudyField(@RequestBody StudyField studyField) {
		sfs.addStudyField(studyField);
		return new ResponseEntity<StudyField>(studyField, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StudyField> updateStudyField(@PathVariable Long id, @RequestBody StudyField studyField) {
		sfs.updateStudyField(id, studyField);
		return new ResponseEntity<StudyField>(studyField, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudyField> getStudyFieldById(@PathVariable Long id) {
		Optional<StudyField> studyField = sfs.getStudyField(id);
		if(studyField.isPresent()) {
			return new ResponseEntity<StudyField>(studyField.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyField>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudyField> removeStudyField(@PathVariable Long id) {
		try {
			sfs.deleteStudyField(id);
		}catch (Exception e) {
			return new ResponseEntity<StudyField>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudyField>(HttpStatus.NO_CONTENT);
	}
	
}
