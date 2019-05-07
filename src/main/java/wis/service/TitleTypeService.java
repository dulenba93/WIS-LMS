package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.TitleType;
import wis.repository.TitleTypeRepository;

@Service
public class TitleTypeService {
	@Autowired
	TitleTypeRepository tr;

	public TitleTypeService() {
	}

	public Iterable<TitleType> getTitleType() {
		return tr.findAll();
	}

	public Optional<TitleType> getTitleType(Long id) {
		return tr.findById(id);
	}

	public void addTitleType(TitleType titleType) {
		tr.save(titleType);
	}

	public void deleteTitleType(Long id) {
		Optional<TitleType> titleType = tr.findById(id);
		tr.delete(titleType.get());
	}
	
	public void updateTitleType(Long id, TitleType titleType) {
		Optional<TitleType> tltp = tr.findById(id);
		if(tltp.isPresent()) {
			titleType.setId(tltp.get().getId());
			tr.save(titleType);
		}
	}
}
