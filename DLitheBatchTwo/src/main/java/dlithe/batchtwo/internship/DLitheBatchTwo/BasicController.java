package dlithe.batchtwo.internship.DLitheBatchTwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController 
{
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView hai()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/two",method=RequestMethod.GET)
	public ModelAndView hello()
	{
		ModelAndView mod=new ModelAndView("secondary");
		mod.addObject("data", "DLithe Consultancy Services");
		return mod;
	}
}
