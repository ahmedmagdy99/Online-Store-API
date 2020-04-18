After running the program there are 3 webservices could be used with URLs: -

1)Localhost:8080/register (POST request)
This webservice is used to register a user in the Online_Store_API so you start entering the user data using  
(ex. Postman) in the body scope by (ex.JSON) enter user’s (Name, Email, Password, Phone number, Address and Role) 
and there are some validations as that the role should be either ROLE_ADMIN or ROLE_USER, password should be at least 8 chars. And more…

2)Localhost:8080/users (GET request)
This webservice is used to list all the users who are successfully registered in the database But, this webservice is authorized only by ADMIN roles means that if you are a normal user you can’t list the users in the database. 

3)Login
This webservice is used either by the browser as there will be an alert shown to enter your login data or by using Postman 
but you should first navigate to Authorization bar and choose *Basic Auth* type and then start entering your credentials and of course it should be valid.

Note
(when running the POST request (ex, registering) you should choose the type of Authorization to be *Inherit auth from parent* and then you can continue using program.

Framework used is: Spring Boot

Database used: MySQL

Dependencies used: 

	-Spring Web
	-Spring Data JPA
	-Spring Security
	-MySQL Driver
