## Objective
Write a simple CRUD application, mapping the HTTP methods to SQL verbs.

### Task 1
Create a schema for your RSVP database.

### Task 2
Write REST controller(s) to process the following HTTP requests
- Get all RSVPs from the database (GET /api/rsvps  Accept: application/json).
- Search for a RSVP by name or parts of (GET /api/rsvp?q=fred  Accept: application/json). Return a 404 and an appropriate error object if you cannot find the RSVP.
- Add a new RSVP into the table. If it is an existing RSVP, overwrite the RSVP in the table with this new RSVP (POST /api/rsvp  Content-Type: application/x-www-form-urlencoded  Accept: application/json). Return a 201 if the operation is successful.
- Update an existing RSVP (PUT /api/rsvp/fred@gmail.com Content-Type: application/x-www-form-urlencoded Accept: application/json). Return a 201 if the update operation is successful; a 404 if the email is not found.
- Get the number of RSVPs (GET /api/rsvps/count  Accept: application/json). Return a 201 if the operation is successful.