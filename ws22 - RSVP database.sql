-- Use hotelreservation as RSVP database
USE hotelreservation;

-- Create table called RSVP
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

-- CRUD SQL-Query
/*
INSERT INTO rsvp (full_name, email, phone, confirmation_date, comments)
VALUES ('Fred Perry', 'Fred@gmail.com', '91234567', '2023-02-01', 'Event B');

SELECT * FROM rsvp;
SELECT * FROM rsvp WHERE id = ?
SELECT * FROM rsvp WHERE full_name LIKE '%fred%';
SELECT count(*) AS cnt FROM RSVP;

UPDATE rsvp
SET full_name = 'David Goh', email = 'David@gmail.com', phone = '94567890', confirmation_date = '2023-02-15', comments = 'Event A'
WHERE id = 1;

DELETE from rsvp WHERE id = 3;
*/

-- Checking data
SELECT * FROM rsvp;