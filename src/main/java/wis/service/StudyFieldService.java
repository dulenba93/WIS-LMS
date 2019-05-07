package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.StudyField;
import wis.repository.StudyFieldRepository;

@Service
public class StudyFieldService {
	@Autowired
	StudyFieldRepository sr;

	public StudyFieldService() {
	}

	public Iterable<StudyField> getStudyField() {
		return sr.findAll();
	}

	public Optional<StudyField> getStudyField(Long id) {
		return sr.findById(id);
	}

	public void addStudyField(StudyField studyField) {
		sr.save(studyField);
	}

	public void deleteStudyField(Long id) {
		Optional<StudyField> studyField = sr.findById(id);
		sr.delete(studyField.get());
	}
	
	public void updateStudyField(Long id, StudyField studyField) {
		Optional<StudyField> stfs = sr.findById(id);
		if(stfs.isPresent()) {
			studyField.setId(stfs.get().getId());
			sr.save(studyField);
		}
	}
	
	
}
