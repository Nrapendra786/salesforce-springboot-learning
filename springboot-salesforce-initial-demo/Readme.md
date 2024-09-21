created demo application for Java, Spring-Boot and Salesforce

Required Steps for Salesforce
1) create an account at https://developer.salesforce.com/signup
2) Login to Salesforce and navigate to SetUp section
3) Click 'New Connected App' Tab
4) Fill in the form and click on save Button
5) Verify an app creation and make a note of Consumer-Key and Consumer-Secret

# create the SpringBoot Application
1) create spring boot application using spring initializer and include web, lombok and other dependencies.
2) create basic RestExample for Account(mentioned in the code)
3) set credentials in environment variables and referred them in application.properties file using ${VARIABLE_NAME} 

# start the application
cd [path to application]
mvn spring-boot:run

once the application is started, then user can invoke Rest Call either through CURL command or RestClient like Postman 

GET : [hostname]:[portnumber]/accountsr