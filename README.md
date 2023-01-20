# user-service
___
For run jar file you have to run 
"java -jar user-service.jar" 
in command line with path
___
EndPoints
/users (POST & GET)

Example (for get) - http://localhost:8080/users?id=2
Example (for post) - Postman -> POST -> headers (-> add content-Type - application/json)
http://localhost:8080/users
-> body -> raw ->  {"name":"John", "lastName":"Doe", "birthday":"01-01-1900"}
                                                        |_ day, month, year