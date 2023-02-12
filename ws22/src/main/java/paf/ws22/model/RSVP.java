package paf.ws22.model;

import java.sql.Date;

/*
CREATE TABLE rsvp (
	id int not null auto_increment,
    full_name varchar(100) not null,
    email varchar(50) not null,
    phone numeric (8),
    confirmation_date date,
    comments varchar(255),
	constraint rsvp_id primary key(id)
);
*/

public class RSVP {

    private Integer id;
    private String fullName;
    private String email; 
    private Integer phone;
    private Date confirmationDate;
    private String comments;
    
    //No Arg Constructor
    public RSVP() {
    }

    //Getters
    public Integer getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public Integer getPhone() {
        return phone;
    }
    public Date getConfirmationDate() {
        return confirmationDate;
    }
    public String getComments() {
        return comments;
    }
    
    //Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

}
