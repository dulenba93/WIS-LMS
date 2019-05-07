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

import wis.domain.StudyProgram;
import wis.service.StudyProgramService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studyProgram")
public class StudyProgramController {
	
	@Autowired
	StudyProgramService sps;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<StudyProgram>> getAllStudyProgram() {
		return new ResponseEntity<Iterable<StudyProgram>>(sps.getStudyProgram(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<StudyProgram> addStudyProgram(@RequestBody StudyProgram studyProgram) {
		sps.addStudyProgram(studyProgram);
		return new ResponseEntity<StudyProgram>(studyProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StudyProgram> updateStudyProgram(@PathVariable Long id, @RequestBody StudyProgram studyProgram) {
		sps.updateStudyProgram(id, studyProgram);
		return new ResponseEntity<StudyProgram>(studyProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudyProgram> getStudyProgramById(@PathVariable Long id) {
		Optional<StudyProgram> studyProgram = sps.getStudyProgram(id);
		if(studyProgram.isPresent()) {
			return new ResponseEntity<StudyProgram>(studyProgram.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudyProgram> removeStudyProgram(@PathVariable Long id) {
		try {
			sps.deleteStudyProgram(id);
		}catch (Exception e) {
			return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudyProgram>(HttpStatus.NO_CONTENT);
	}
	
}

