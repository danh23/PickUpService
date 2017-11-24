package ro.pickupservice.controllers.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.data.sport.entity.Sport;
import ro.pickupservice.exception.CustomException;
import ro.pickupservice.services.sport.SportService;

@RestController
@RequestMapping(value = "/sport")
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	@RequestMapping(value = "/setSport" , method = RequestMethod.POST)
	public ResponseEntity<Sport> setSport(@RequestBody Sport sport) throws CustomException {
		Sport sportResponse = sportService.setSport(sport);  
	    return new ResponseEntity<>(sportResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllSports" , method = RequestMethod.GET)
	public ResponseEntity<List<Sport>> getAllSports() {
		List<Sport> sportResponse = sportService.getAllSports();  
	    return new ResponseEntity<>(sportResponse, HttpStatus.OK);
	}
	  
	  

}
