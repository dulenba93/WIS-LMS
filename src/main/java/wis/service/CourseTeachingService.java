package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseTeaching;
import wis.repository.CourseTeachingRepository;

@Service
public class CourseTeachingService {
	@Autowired
	CourseTeachingRepository ct;

	public CourseTeachingService() {
	}

	public Iterable<CourseTeaching> getCourseTeaching() {
		return ct.findAll();
	}

	public Optional<CourseTeaching> getCourseTeaching(Long id) {
		return ct.findById(id);
	}

	public void addCourseTeaching(CourseTeaching courseTeaching) {
		ct.save(courseTeaching);
	}

	public void deleteCourseTeaching(Long id) {
		Optional<CourseTeaching> courseTeaching = ct.findById(id);
		ct.delete(courseTeaching.get());
	}
	
	public void updateCourseTeaching(Long id, CourseTeaching courseTeaching) {
		Optional<CourseTeaching> crts = ct.findById(id);
		if(crts.isPresent()) {
			courseTeaching.setId(crts.get().getId());
			ct.save(courseTeaching);
		}
	}
	
	
}