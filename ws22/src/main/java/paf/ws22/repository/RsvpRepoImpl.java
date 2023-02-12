package paf.ws22.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.ws22.model.RSVP;

@Repository
public class RsvpRepoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    //SQL Commands
    private final String insertSQL = "INSERT INTO rsvp (full_name, email, phone, confirmation_date, comments) " +
    "VALUES (?, ?, ?, ?, ?)";

    private final String findAllSQL = "SELECT * FROM rsvp";
    private final String findByIdSQL = "SELECT * FROM rsvp WHERE id = ?";
    private final String findByNameSQL = "SELECT * FROM rsvp WHERE full_name = ?";
    private final String countSQL = "SELECT count(*) AS cnt FROM rsvp";

    private final String updateSQL = "UPDATE rsvp SET full_name = ?, email = ?, phone = ?, " +
    "confirmation_date = ?, comments = ? WHERE id = ?";

    //Method to create record in RSVP
    //private final String insertSQL = "INSERT INTO rsvp (full_name, email, phone, confirmation_date, comments) VALUES (?, ?, ?, ?, ?)"
    public Boolean create (RSVP rsvp) {
        Integer createRSVP = jdbcTemplate.update(insertSQL, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhone(),
        rsvp.getConfirmationDate(), rsvp.getComments());

        return createRSVP > 0? true:false;
    }

    //Method to read all records in RSVP
    //private final String findAllSQL = "SELECT * FROM rsvp"
    public List <RSVP> findAll () {
        List<RSVP> allNames = new ArrayList<RSVP>();
        allNames = jdbcTemplate.query(findAllSQL, BeanPropertyRowMapper.newInstance(RSVP.class));
        return allNames;
    } 

    //Method to read a record based on id in RSVP
    //private final String findByIdSQL = "SELECT * FROM rsvp WHERE id = ?"
    public RSVP findById(Integer id) {
        RSVP rsvpId = new RSVP();
        rsvpId = jdbcTemplate.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(RSVP.class), id);
        return rsvpId;
    }

    //Method to read a record based on "like '%?%" in RSVP
    //private final String findByNameSQL = "SELECT * FROM rsvp WHERE full_name LIKE ?"
    public List <RSVP> findByName (String name) {
        List<RSVP> allLikeNames = new ArrayList<RSVP>();
        allLikeNames = jdbcTemplate.query(findByNameSQL, BeanPropertyRowMapper.newInstance(RSVP.class), name);
        return allLikeNames;

    } 

    //Method to count total number of records
    //private final String countSQL = "SELECT count(*) AS cnt FROM rsvp"
    public Integer countAll() {
        Integer result = jdbcTemplate.queryForObject(countSQL, Integer.class);
        return result;
    }

    //Method to update RSVP records
    //private final String updateSQL = "UPDATE rsvp SET full_name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? WHERE id = ?";
    public Boolean update (RSVP rsvp) {
        Integer updateRSVP = jdbcTemplate.update(updateSQL, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhone(),
        rsvp.getConfirmationDate(), rsvp.getComments(), rsvp.getId());

        return updateRSVP > 0? true:false;
    }

}
