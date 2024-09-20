created demo application for Java, Spring-Boot and Salesforce

Required Steps 
1) create an account at https://developer.salesforce.com/signup 
2) Login to Salesforce and navigate to SetUp section
3) Click 'New Connected App' Tab
4) Fill in the form and click on save Button
5) Verify an app creation and make a note of Consumer-Key and Consumer-Secret

Please Note: 

# create SpringBoot Application
1) create spring boot application using spring initializer and include web, lombok and other dependencies.
2) create basic RestExample for Account(mentioned in the code)
3) create secret.properties to make sure that user must not share credentials on github
4) set secret.properties in .gitignore

# start application 
cd [path to application]
mvn spring-boot:run
once application is started, then user can invoke following 

GET: [hostname]:[portnumber]/accounts
