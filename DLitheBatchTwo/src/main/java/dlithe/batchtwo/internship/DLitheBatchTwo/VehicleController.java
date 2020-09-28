package dlithe.batchtwo.internship.DLitheBatchTwo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleController 
{
	@Autowired
	private VehicleService service;
	List<Vehicle> temp;
	
	HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView begin()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView let(@RequestParam("user") String user, @RequestParam("pass") String pass, HttpServletRequest request)
	{
		if(user.equalsIgnoreCase("yamaha")&&pass.equalsIgnoreCase("mangalore"))
		{
			session=request.getSession();
			session.setAttribute("authorised", user);
			return new ModelAndView("home");
		}
		else {return new ModelAndView("index").addObject("msg", "Unauthorised login");}
	}
	
	@RequestMapping(value="/back")
	public ModelAndView again()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("home"); }
		else {return new ModelAndView("index");}
	}
	
	// requesting import.jsp to add new vehicle
	@RequestMapping("/add")
	public ModelAndView askToAdd()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("import");}
		else {return new ModelAndView("index");}
	}
	// adding new vehicle
	@RequestMapping(value="/newstock",method=RequestMethod.POST)
	public ModelAndView addSubmit(@Valid Vehicle veh, BindingResult bind)
	{
		if(session.getAttribute("authorised")!=null)
		{
			ModelAndView mod=new ModelAndView("import");
			if(bind.hasErrors()) {return mod;}
			if(service.newadd(veh)!=null)
			{
				mod.addObject("msg", "Vehicle "+veh.getModel()+" has added in stock");
			}
			else {mod.addObject("msg", "Vehicle "+veh.getModel()+" has not added in stock");}
			return mod;
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView traverse()
	{
		if(session.getAttribute("authorised")!=null)
		{
			temp=service.every();
			return new ModelAndView("show").addObject("all", temp);
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/editable",method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
			Vehicle v=service.single(id);
			return new ModelAndView("edit").addObject("one", v);
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public ModelAndView editResponse(Vehicle vehicle)
	{
		if(session.getAttribute("authorised")!=null)
		{
			service.alter(vehicle);
			return traverse().addObject("msg", vehicle.getModel()+" has updated");
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/deletable",method=RequestMethod.GET)
	public ModelAndView deleteRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
			Vehicle temp=service.single(id);
			String hold=service.remove(temp);
			return traverse().addObject("msg",hold+" has deleted");
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/short",method=RequestMethod.GET)
	public ModelAndView letShort()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("short");}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/shortlist",method=RequestMethod.POST)
	public ModelAndView shortRequest(@RequestParam("stkid") String stkid,@RequestParam("milage") String milage,@RequestParam("cc") String cc,@RequestParam("price") String price)
	{
		if(session.getAttribute("authorised")!=null)
		{
			if(stkid!=""&&cc==""&&milage==""&&price=="")
			{
				// Integer.parseInt(string), Long.parseLong(string)
				Vehicle tm=service.single(Integer.parseInt(stkid));
				temp=new ArrayList<Vehicle>();
				temp.add(tm);
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(stkid==""&&cc!=""&&milage==""&&price=="")
			{
				// Integer.parseInt(string), Long.parseLong(string)
				temp=service.getByCc(Integer.parseInt(cc));
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(stkid==""&&cc==""&&milage!=""&&price=="")
			{
				// Integer.parseInt(string), Long.parseLong(string)
				temp=service.getByMilage(Integer.parseInt(milage));
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(stkid==""&&cc==""&&milage==""&&price!="")
			{
				// Integer.parseInt(string), Long.parseLong(string)
				List<String> models=service.getByCost(Double.parseDouble(price));
				return new ModelAndView("models").addObject("all", models);
			}
			else {return null;}
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView out()
	{
		session.removeAttribute("authorised");
		session.setAttribute("authorised", null);
		return new ModelAndView("index").addObject("msg", "Logged out successfully");
	}
}
