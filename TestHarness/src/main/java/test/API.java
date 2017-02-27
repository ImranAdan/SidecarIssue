package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {

	@Autowired
	private JavaFeignClient javaService;

	@Autowired
	private PythonFeignClient pythonService;

	@RequestMapping(value = "/testJavaService", method = RequestMethod.GET)
	public String invokeJavaService2(@RequestParam(value = "message", required = true) String message) {
		return javaService.testPost(message);
	}

	@RequestMapping(value = "/testPythonService1", method = RequestMethod.GET)
	public String invokePythonService(@RequestParam(value = "message", required = true) String message) {
		return pythonService.testPostContentTypeJson(message);
	}

	@RequestMapping(value = "/testPythonService2", method = RequestMethod.GET)
	public String invokePythonService2(@RequestParam(value = "message", required = true) String message) {
		return pythonService.testPostContentTypeWWWForm(message);
	}

	@RequestMapping(value = "/testPythonService3", method = RequestMethod.GET)
	public String invokePythonService3(@RequestParam(value = "message", required = true) String message) {
		return pythonService.testPostNoHeaders(message);
	}

}
