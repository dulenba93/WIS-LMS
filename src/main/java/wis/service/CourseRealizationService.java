package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseRealization;
import wis.repository.CourseRealizationRepository;

@Service
public class CourseRealizationService {
	@Autowired
	CourseRealizationRepository cr;

	public CourseRealizationService() {
	}

	public Iterable<CourseRealization> getCourseRealization() {
		return cr.findAll();
	}

	public Optional<CourseRealization> getCourseRealization(Long id) {
		return cr.findById(id);
	}

	public void addCourseRealization(CourseRealization courseRealization) {
		cr.save(courseRealization);
	}

	public void deleteCourseRealization(Long id) {
		Optional<CourseRealization> courseRealization = cr.findById(id);
		cr.delete(courseRealization.get());
	}
	
	public void updateCourseRealization(Long id, CourseRealization courseRealization) {
		Optional<CourseRealization> creal = cr.findById(id);
		if(creal.isPresent()) {
			courseRealization.setId(creal.get().getId());
			cr.save(courseRealization);
		}
	}
}