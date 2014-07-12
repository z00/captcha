Captcha is a webservice that allows users to get an image from text. 

Usage: access the service at {domainName}/captcha?text=SomeText where domain name is the host address where the web service is deployed.
SomeText will be return as a JPEG image bytes. Browser headers are set correctly so image can show in browsers.



If input text is too long, image "Long param" is returned. 

Technical stack:
Spring 4
Spring boot
Spring Rest
Embedded Tomcat

Deployment:

Application is run as a regular process with a main method. Which internally uses embedded Tomcat to listen on port 8080.
The final artifact is a single Jar file with all dependencies included. It can be run with java -jar captcha-rest-service-0.1.0.jar