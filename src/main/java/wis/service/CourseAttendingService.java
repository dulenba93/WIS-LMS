package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseAttending;
import wis.repository.CourseAttendingRepository;

@Service
public class CourseAttendingService {
	@Autowired
	CourseAttendingRepository cr;

	public CourseAttendingService() {
	}

	public Iterable<CourseAttending> getCourseAttending() {
		return cr.findAll();
	}

	public Optional<CourseAttending> getCourseAttending(Long id) {
		return cr.findById(id);
	}

	public void addCourseAttending(CourseAttending courseattending) {
		cr.save(courseattending);
	}

	public void deleteCourseAttending(Long id) {
		Optional<CourseAttending> courseattending = cr.findById(id);
		cr.delete(courseattending.get());
	}
	
	public void updateCourseAttending(Long id, CourseAttending courseAttending) {
		Optional<CourseAttending> crsa = cr.findById(id);
		if(crsa.isPresent()) {
			courseAttending.setId(crsa.get().getId());
			cr.save(courseAttending);
		}
	}
}