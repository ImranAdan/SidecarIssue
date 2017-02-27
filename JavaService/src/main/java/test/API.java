/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adam
 */
@RestController
public class API {
    
    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public String testPostRequest(@RequestBody(required = true) String message){
    	return message + " received";
    }
    
}
