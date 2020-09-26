package dlithe.batchtwo.internship.DLitheBatchTwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService
{
	@Autowired
	private VehicleRepository repo;
	public Vehicle newadd(Vehicle vehicle)
	{
		return repo.save(vehicle);
	}
	
	public List<Vehicle> every()
	{
		return repo.findAll();
	}
	
	public Vehicle single(int id)
	{
		return repo.findById(id).orElse(new Vehicle());
	}
	
	public Vehicle alter(Vehicle vehicle)
	{
		return repo.save(vehicle);
	}
	
	public String remove(Vehicle vehicle)
	{
		String model=vehicle.getModel();
		repo.delete(vehicle);
		return model;
	}
	
	public List<Vehicle> getByMilage(int milage)
	{
		return repo.readByMilage(milage);
	}
	
	public List<String> getByCost(int price)
	{
		return repo.readByPrice(price);
	}
	
	public List<Vehicle> getByCc(int cc)
	{
		return repo.readByCc(cc);
	}
}
