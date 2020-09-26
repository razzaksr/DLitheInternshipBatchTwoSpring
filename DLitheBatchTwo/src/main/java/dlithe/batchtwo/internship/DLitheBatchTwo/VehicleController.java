package dlithe.batchtwo.internship.DLitheBatchTwo;

import java.util.ArrayList;
import java.util.List;

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
	// requesting import.jsp to add new vehicle
	@RequestMapping("/add")
	public ModelAndView askToAdd()
	{
		return new ModelAndView("import");
	}
	// adding new vehicle
	@RequestMapping(value="/newstock",method=RequestMethod.POST)
	public ModelAndView addSubmit(@Valid Vehicle veh, BindingResult bind)
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
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView traverse()
	{
		temp=service.every();
		return new ModelAndView("show").addObject("all", temp);
	}
	
	@RequestMapping(value="/editable",method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id") int id)
	{
		Vehicle v=service.single(id);
		return new ModelAndView("edit").addObject("one", v);
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public ModelAndView editResponse(Vehicle vehicle)
	{
		service.alter(vehicle);
		return traverse().addObject("msg", vehicle.getModel()+" has updated");
	}
	
	@RequestMapping(value="/deletable",method=RequestMethod.GET)
	public ModelAndView deleteRequest(@RequestParam("id") int id)
	{
		Vehicle temp=service.single(id);
		String hold=service.remove(temp);
		return traverse().addObject("msg",hold+" has deleted");
	}
	
	@RequestMapping(value="/short",method=RequestMethod.GET)
	public ModelAndView letShort()
	{
		return new ModelAndView("short");
	}
	
	@RequestMapping(value="/shortlist",method=RequestMethod.POST)
	public ModelAndView shortRequest(@RequestParam("stkid") String stkid,@RequestParam("milage") String milage,@RequestParam("cc") String cc,@RequestParam("price") String price)
	{
		if(stkid!=""&&cc==""&&milage==""&&price=="")
		{
			// Integer.parseInt(string), Long.parseLong(string)
			Vehicle tm=service.single(Integer.parseInt(stkid));
			temp=new ArrayList<Vehicle>();
			temp.add(tm);
			return new ModelAndView("show").addObject("all", temp);
		}
		return null;
	}
}
