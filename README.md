# tacoLocoDL

DOCUMENTATION:
Application built with:
-	Java
-	Spring Boot (to create RESTful Web Service)
-	Maven (as a project management tool)

How to use Taco Loco REST API:
	Taco Loco’s API endpoint uses the HTTP POST method. The URI to send a taco request is “/taco-order”. The format of the request message requires sending JSON objects in an array. Each JSON Object specifies the type of taco, price and quantity ordered. 
	Examples:
		For one taco type order:
			[{"name":"Chorizo Taco","price":3.5, "ordered":1}]
		For two taco type order:
			[{"name":"Chorizo Taco","price":3.5, "ordered":1},
 {"name":"Veggie Taco","price":2.5, "ordered":1}]
	The response message contains the order of tacos requested as well as cost of order, number of tacos ordered and whether or not a discount was applied.
How to run application:
1.	In the command line go to the directory where Taco Loco resides 
2.	Type: mvn spring-boot:run
