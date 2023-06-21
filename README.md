# MovieTheaterAPI

## Description
MovieTheater API is a back end project created with Java and Spring Boot. It aims to show the list of movies(shows) and users. 
H2 database is used to store the show and user details.
The project includes the following features:

### Users

* GET all users
* GET one user
* GET all shows watched by a user
* PUT update and add a show if a user has watched it

### Shows

* GET all shows
* GET one show
* GET shows of a particular genre (genre in req.params)
* PUT update rating of a show that has been watched
* PUT update the status of a show
* Server side validation for updating rating and status
* DELETE a show

* An index.html is added to the project, however, it's a back end app so there is no code/integration added for the UI.

### Tests
* Test the routes using Postman

## Installation

Use Spring Initializr (https://start.spring.io/) to start the project and install required maven dependencies. 

## Usage
To use this project, follow the steps below:
1. Have the prerequisites installed and ensure the versions are up-to-date.
2. Set up your application properties accordingly if you plan to use H2 database. 
3. Follow the Spring Boot documentation.
4. Run the application and go to http://localhost:8080

```java
# get shows of a particular genre
add http Get request: localhost:8080/shows/genre/Comedy
```
Use your port number if you have a different port number.

## Contributing

Contributions to this project and pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

* Fork the repository.
* Create a new branch for your feature or to fix bug.
* Please make sure to update tests as appropriate.
* Commit your work after making necessary changes.
* Submit a pull request detailing your changes.

## License

[MIT](https://choosealicense.com/licenses/mit/)
