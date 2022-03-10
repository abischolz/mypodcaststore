# mypodcaststore
CRUD Java backend 

This is the beta version of the podcast store! 

Installation instructions: 
-Deployed backend can be viewed here: https://podcaststore.herokuapp.com/ <br />
-To run the app, clone or fork and pull down to your local machine and open in a code editor like VSCode, IntelliJ or whatever you prefer. <br />
-This project was built using Maven and Springboot. In your terminal, first run mvn install (or ./mvnw install if that doesn't work). Project will definitely not work without installing dependencies. <br />
-To build the app and run on port 8080, run mvn spring-boot:run (or ./mvnw spring-boot: run)
-That's it! 
*Note - this is a backend repo. If you deploy, you will need to send all requests via cURL or Postman. You can view the full app here: https://abischolz.github.io/podcast_store/

Reqs for this project: 
-Create an application that can be interacted with at least 3 differnt ways. <br />

*This application has PUT, GET, DELETE and POST endpoints. It's currently possible to search the API, get a podcast by Id (along with their episodes), get best-podcasts, like a podcast, request to delete a podcast, and add a new podcast to the attached in-memory database (not the API). 

-Integration of a backend service deployed by you with CRUD applications <br />

*I chose to use Spring Boot because many of the tutorials that I folowed recommended this for a first project. Since I only started with Java 4ish weeks ago, that seemed like the way to go. In terms of functionality, this is test app, so Spring Boot can meet all needs (low traffic, not very complex, relatively light). I chose to use the H2 in-memory data base, as this app is primarily for testing. I had initially planned to add a PG database, but given the time constraints, that proved to be a bit more than I could realistically accomplish. I was also happy to learn that this package included Hibernate, as I did not also want to throw SQL in the mix. 

-Usage of a specific architecture pattern  <br />

*In part, I followed a Controller/Service/Repository architecture to separate concerns. Business logic is isolated to the Service class, the Controller is handling all REST requests/responses and the Repo is providing a way to save and mofify the data without writing SQL queries. Additionally, I have a Model which is controlling/modelling the data, a repository that is handling any interactions with the data directly, and a controller that is performing minimal logic and is primarily a passthrough. On the front end, I separate out my controllers (api calls) and within the components (except for the pages), I strove for minimal logic and made them as presentational as possible. 

-Integration with a 3rd-party API <br />
*I opted to use Listen API, which is a free podcast API. It is currently set up to point at test data, as I forgot to do this initially and very quickly almost exceeded the free quota. 

-Usage of at least one OO principle <br />
*Inheritance - I created a media class that acts as the parent class for the Podcast and Episode classes. I had planned out a much more ambitious app, so I planned to use this class for adding songs as well. 




Schema: https://www.figma.com/file/TCIBSDVqsHw8ukc0UurSLZ/PodcastStore?node-id=0%3A1
