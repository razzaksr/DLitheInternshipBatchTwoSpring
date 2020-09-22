package dlithe.batchtwo.internship.DLitheBatchTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleController 
{
	@Autowired
	private VehicleService service;
	// requesting import.jsp to add new vehicle
	@RequestMapping("/add")
	public ModelAndView askToAdd()
	{
		return new ModelAndView("import");
	}
	// adding new vehicle
	@RequestMapping(value="/newstock",method=RequestMethod.POST)
	public ModelAndView addSubmit(Vehicle veh)
	{
		service.newadd(veh);
		return new ModelAndView("import");
	}
}
