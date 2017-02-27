Installing Python Sidecar Application
===================

This project contains a simple python server application that listens for POST request and then prints the contents of the requests. The python application runs on port 8000. 


### Python Prerequisites

You will need to install Flask to run the sample python application.  Flask can be installed via pip, you can install pip from  https://pip.pypa.io/en/stable/installing/

Once pip is installed you can then install Flask

```
pip install flask
```

If you are having issues with installing pip, then follow some of comments on this thread: https://github.com/spring-cloud/spring-cloud-netflix/issues/1705#issuecomment-282309247

----------

Once the flask is installed run the sample python app: 


Running Python Application 
-------------

From PythonSidecar directory: 

```
cd python 
python app.py
```

This should start the sample python application running on localhost:8000. The application runs in debug mode, so you should see some debug messages. 

 

Running Sidecar Application 
-------------
 
The PythonSidecar is a standard Springboot app and can be started in the usual manner as a runnable jar: 

```
mvn clean package 
java -jar target/PythonSidecar-0.0.1-SNAPSHOT.jar
```

Additional Notes
-------------

The python application starts a web server that runs in debug mode. The function ``` def testPostReqeust() ``` prints the header and the data contents associated wit each request it receives.
The issue here is that when requests are coming from the Sidecar, then the content is somehow lost in tranist and as a result the contents are not printed on the console.  

