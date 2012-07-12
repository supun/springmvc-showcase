package vikram.demo.springmvc.argresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vikram.demo.springmvc.domain.Person;

@Controller
public class ExampleArgResolveController {

	@RequestMapping(value = "/resolve", method = RequestMethod.GET)
	public ModelAndView demoArgResolve(@PersonEntity Person person){
		
		System.out.println("Data: " + person);
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("data", person);
		return mav;
	}
}
