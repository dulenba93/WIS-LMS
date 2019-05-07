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

import wis.domain.Result;
import wis.service.ResultService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/result")
public class ResultController {
	
	@Autowired
	ResultService rs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Result>> getAllResult() {
		return new ResponseEntity<Iterable<Result>>(rs.getResult(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Result> addResult(@RequestBody Result result) {
		rs.addResult(result);
		return new ResponseEntity<Result>(result, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result result) {
		rs.updateResult(id, result);
		return new ResponseEntity<Result>(result, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Result> getResultById(@PathVariable Long id) {
		Optional<Result> result = rs.getResult(id);
		if(result.isPresent()) {
			return new ResponseEntity<Result>(result.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Result> removeResult(@PathVariable Long id) {
		try {
			rs.deleteResult(id);
		}catch (Exception e) {
			return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Result>(HttpStatus.NO_CONTENT);
	}
	
}
