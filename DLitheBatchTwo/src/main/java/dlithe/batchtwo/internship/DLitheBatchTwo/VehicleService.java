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
	
}
