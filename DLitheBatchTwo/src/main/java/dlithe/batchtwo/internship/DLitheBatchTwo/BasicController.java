package dlithe.batchtwo.internship.DLitheBatchTwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController 
{
	
	@RequestMapping(value="/log",method=RequestMethod.GET)
	public ModelAndView log()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public ModelAndView verify(@RequestParam("user") String user, @RequestParam("pass") String pass)
	{
		if(user.equalsIgnoreCase("dlithe")&&pass.equalsIgnoreCase("mangalore"))
		{return new ModelAndView("home");}
		else 
		{
			return new ModelAndView("login").addObject("msg", "Username/  Password is incorrect");
		}
	}
	
	@RequestMapping(value="/{got}",method=RequestMethod.GET)
	public ModelAndView hai(@PathVariable("got") String got)
	{
		return new ModelAndView("index").addObject("who",got);
	}
	
	@RequestMapping(value="/two",method=RequestMethod.GET)
	public ModelAndView hello()
	{
		ModelAndView mod=new ModelAndView("secondary");
		mod.addObject("data", "DLithe Consultancy Services");
		return mod;
	}
}
