package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Title;
import wis.repository.TitleRepository;

@Service
public class TitleService {
	@Autowired
	TitleRepository tr;

	public TitleService() {
	}

	public Iterable<Title> getTitle() {
		return tr.findAll();
	}

	public Optional<Title> getTitle(Long id) {
		return tr.findById(id);
	}

	public void addTitle(Title title) {
		tr.save(title);
	}

	public void deleteTitle(Long id) {
		Optional<Title> title = tr.findById(id);
		tr.delete(title.get());
	}
	
	public void updateTitle(Long id, Title title) {
		Optional<Title> ttls = tr.findById(id);
		if(ttls.isPresent()) {
			title.setId(ttls.get().getId());
			tr.save(title);
		}
	}
}
