Sidecar - POST not forwarding request body 
===================

This is a simple example that demonstrates POST not forwarding request body. You will need to install Flask to run the sample python application. 

Flask can be installed via pip, you can install pip from  https://pip.pypa.io/en/stable/installing/

Once pip is installed you can then install Flask

```
pip install flask
```
----------

Once the flask is installed run the sample python app: 

Running Sample Application 
-------------

From PythonSidecar directory: 
```
cd python 
python app.py
```

This should start the sample python application running on localhost:8000
 
The PythonSidecar is a standard Springboot app and can be started in the usual manner as a runnable jar: 

```
mvn clean package 
java -jar target/PythonSidecar-0.0.1-SNAPSHOT.jar
```

How to Reproduce 
-------------

The simplest  way to reproduce the issue is to use a REST client such as PostMan to issue the relevant POST and GET requests.

1. Python App -- http://localhost:8000/testGet?test=Hello%20World (WORKS FINE)
2. Python App -- http://localhost:8000/testPost (WORKS FINE, You will need to provide form-data where key = test, value = Hello World)


3. Sidecar -- http://localhost:8080/testGet?test=Hello%20World (WORKS FINE, Sidecar is able to forward GET @RequestParams) 
4. Sidcar -- http://localhost:8080/testPost (DOES NOT WORK, Sidecar is not able to forward POST @RequestBody content. We provide POST Body as form-data where key = test, value = Hello World )

The following error message is produced: 

```
{
  "timestamp": 1487610252713,
  "status": 400,
  "error": "Bad Request",
  "exception": "org.springframework.http.converter.HttpMessageNotReadableException",
  "message": "Required request body is missing: public java.lang.String org.example.pythonsidecar.Controller.testPost(java.lang.String)",
  "path": "/testPost"
}
```

In Spring Cloud ANGEL SR4 this was working correctly.
