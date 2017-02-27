# Issue Description - Sidecar not Forwarding POST Requests

The following set of projects demonstrate how the Sidecar is not able to forward the POST request payload even though headers are configured through feign.

### Prerequisites Steps

1. Run the Eureka Service Registry, see EurekaServer README.md
2. Run the Python Application and the Sidecar, See PythonSideCar README.md
    -  _Note: When you run the python application, it should be running running in debug mode, and for each request you should see the headers and contents printed to the console._
3. Run the Java Service Application, see JavaService README.md
4. Run the TestHarness, See TestHarness README.md 

### Reproducing the Issues
The TestHarness project can be used to simulate the issues. You can use the following URLS to simulate the issue, change the ${port} to the respective port the service is running on:

 - TEST forwarding request to the standard Java Service (Works as expected)
    - http://localhost:${port}/testJavaService?message=Hello%20World
    
 - TEST forwarding request to the Sidecar Service, which should in trun forward to the python application (Content is lost)
    - http://localhost:${port}/testPythonService1?message=Hello%20World
    
- TEST forwarding request to the Sidecar Service, which should in trun forward to the python application (Content is lost)
    - http://localhost:${port}/testPythonService2?message=Hello%20World
    
- TEST forwarding request to the Sidecar Service, which should in trun forward to the python application (Content is lost)
    - http://localhost:${port}/testPythonService3?message=Hello%20World

### Additional Info 
- The sidecar application runs on port 8000, to test the server send a JSON message to http://localhost:8000/echo this should retrun the JSON message 
- We provide additional pom-${version}.xml files for previous releases of Spring Cloud, this issue is not present when running ALL the services with the 1.0.2.RELEASE version. Works as expected when hitting the URL http://localhost:${server.port}/testPythonService1?message=Hello%20World
