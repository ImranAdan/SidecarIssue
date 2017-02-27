package test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("PythonSidecar")
public interface PythonFeignClient {

    
    @RequestMapping(value = "/echo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String testPostContentTypeJson(@RequestBody(required = true) String message);

    @RequestMapping(value = "/echo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String testPostContentTypeWWWForm(@RequestBody(required = true) String message);
    
    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    public String testPostNoHeaders(@RequestBody(required = true) String message);

}
