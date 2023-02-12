CREATE TABLE rsvp (
	id int not null auto_increment,
    full_name varchar(100) not null,
    email varchar(50) not null,
    phone numeric (8),
    confirmation_date date,
    comments varchar(255),
	constraint rsvp_id primary key(id)
);