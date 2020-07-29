# Food_delivery
//Guidelines Before running the project, 
Please update the database data in "/src/main/resources/application.properties"
//Order details
For POST request, url is "/order/save" 
For GET request, url is "/order/get/{id}"
For Delete request url is "/order/remove"

//Order Summary
For GET Request url is "/summary/order/{orderid}"

//Search Restaurant by location
For GET request url is "/location//origin"

//Search Restaurant by RestaurantId
For GET request  url is "/restaurent/get/{id}"
For POST and PUT request  url is "/restaurent/save"
For DELETE request  url is "/restaurent/remove"

//search Restaurant by price and Rating
For GET request  url is "/restaurent/get/{price}/{rating}"

//Search Restaurant by destination location
For GET request  url is "/restaurent/get/{destination}"
