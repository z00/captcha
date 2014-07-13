Captcha is a webservice that allows users to get an image from entered text. 

Usage: access the service at http://captcha.cfapps.io/captcha?text=SomeText
The service will convert SomeText query param to JPEG image and return its bytes. Browser headers are set correctly so image can show in browsers.

If input text is longer than "Hello CF!", image "Long param" is returned. 

Technical stack:
Spring 4
Spring boot
Spring Rest
Embedded Tomcat

Deployment:

Application is run as a regular process with a main method. Which internally uses embedded Tomcat to listen on port 8080.
The final artifact is a single Jar file with all dependencies included. It can be run with java -jar captcha-rest-service-0.1.0.jar

Used command: cf push captcha -p captcha-rest-service-0.1.0.jar

Travis CI: https://travis-ci.org/z00/captcha