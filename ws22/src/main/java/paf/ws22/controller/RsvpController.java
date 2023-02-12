package paf.ws22.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paf.ws22.model.RSVP;
import paf.ws22.repository.RsvpRepoImpl;

@RestController
@RequestMapping("/api/rsvps")
public class RsvpController {

    @Autowired
    RsvpRepoImpl rsvpRepo;

    @GetMapping("/")
    public ResponseEntity<List<RSVP>> getAllRsvp () {

        List<RSVP> rsvpList = new ArrayList<RSVP>();
        rsvpList = rsvpRepo.findAll();

        if (rsvpList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(rsvpList, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<RSVP> getIdRsvp (@PathVariable("id") int id){
        RSVP findRsvp = new RSVP();
        findRsvp = rsvpRepo.findById(id);
        
        if (findRsvp == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(findRsvp, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<RSVP>> getNameRsvp (@RequestParam("name") String name){
        List<RSVP> findNameRsvp = new ArrayList<RSVP>();
        findNameRsvp = rsvpRepo.findByName(name);
        
        if (findNameRsvp == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(findNameRsvp, HttpStatus.OK);
        }
    }

    @GetMapping("/count")
    public Integer getRoomCount(){
        
    Integer rsvpCount = rsvpRepo.countAll();
    return rsvpCount;
    }

    @PostMapping("/")
    public ResponseEntity<String> createRsvp (@RequestBody RSVP rsvp) {
        RSVP newRSVP = rsvp;
        Boolean result = rsvpRepo.create(newRSVP);

        if(result){
            return new ResponseEntity<>("A new reservation has been added", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Failed to create new reservation", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
