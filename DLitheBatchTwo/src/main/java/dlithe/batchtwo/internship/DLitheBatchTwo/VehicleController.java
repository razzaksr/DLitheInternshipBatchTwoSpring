package dlithe.batchtwo.internship.DLitheBatchTwo;

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
}
