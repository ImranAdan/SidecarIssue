package test;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {
    
    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public String testPostRequest(@RequestBody(required = true) String message){
    	return message + " received";
    }
    
}
