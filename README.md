# Hotel_User_Rating-Proj



This Project Consistes three microservices 
1. Hotel Microservices
2. User Microservices
3. Rating Microservices
 
so a User can create its profile and can give rating to hotels ,
so while accesing perticular user , user services can communitcate to Rating service to fetch the ratings and
to hotel microservices to fetch the hotlel information (this internal communication has been done by restTemplate)

A hotel microservices is used to create a Hotel profile and it coomunicate User and Raiting microservices 
to fetch information realted to Rating like which user has given what ratings to that perticular Hotel

Similarly a Rating Profile can be created with Rating id can be used a primary key it can br used to fetch 
information to User and Hotel details ..


..............

