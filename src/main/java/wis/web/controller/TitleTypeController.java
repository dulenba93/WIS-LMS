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

import wis.domain.TitleType;
import wis.service.TitleTypeService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/titleType")
public class TitleTypeController {
	
	@Autowired
	TitleTypeService tts;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<TitleType>> getAllTitleType() {
		return new ResponseEntity<Iterable<TitleType>>(tts.getTitleType(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<TitleType> addTitleType(@RequestBody TitleType titleType) {
		tts.addTitleType(titleType);
		return new ResponseEntity<TitleType>(titleType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<TitleType> updateTitleType(@PathVariable Long id, @RequestBody TitleType titleType) {
		tts.updateTitleType(id, titleType);
		return new ResponseEntity<TitleType>(titleType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TitleType> getTitleTypeById(@PathVariable Long id) {
		Optional<TitleType> titleType = tts.getTitleType(id);
		if(titleType.isPresent()) {
			return new ResponseEntity<TitleType>(titleType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<TitleType> removeTitleType(@PathVariable Long id) {
		try {
			tts.deleteTitleType(id);
		}catch (Exception e) {
			return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TitleType>(HttpStatus.NO_CONTENT);
	}
	
}