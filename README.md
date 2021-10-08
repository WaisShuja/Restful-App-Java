# Restful-App-Java
Restful Service Task 

Creating a restful service using Spring Boot and Java skills and methodology in Software design and development.

Having Product table that has the following columns:
ID
Name
Color
Brand
Price
Creation date
Last modification date

Defining the required classes to handle the Product table, using MySQL relational database.

Created products listing api that satisfies: 
The user can filter by: 
Brand
Price range
Price range and brand 

The user can sort by any of: name, price, or creation date.

If the user filtered by a negative price, the service should return an error. 

Having a new field to the response in each product called isExpensive, it will be true only if price > 1000. This threshold may change in the future occasionally.

Th home page (most visited page) will always retrieve the products sorted by descending creation date.

We have a separate page for each brand (commonly visited pages), in each page we display the products belonging to that brand sorted by descending creation date.

Implementing pagination.





