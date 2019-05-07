package wis.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Result;
import wis.repository.ResultRepository;

@Service
public class ResultService {
	@Autowired
	ResultRepository rr;

	public ResultService() {
	}

	public Iterable<Result> getResult() {
		return rr.findAll();
	}

	public Optional<Result> getResult(Long id) {
		return rr.findById(id);
	}

	public void addResult(Result result) {
		rr.save(result);
	}

	public void deleteResult(Long id) {
		Optional<Result> result = rr.findById(id);
		rr.delete(result.get());
	}
	
	public void updateResult(Long id, Result result) {
		Optional<Result> rslt = rr.findById(id);
		if(rslt.isPresent()) {
			result.setId(rslt.get().getId());
			rr.save(result);
		}
	}
}
