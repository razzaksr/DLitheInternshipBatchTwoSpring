package dlithe.batchtwo.internship.DLitheBatchTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService
{
	@Autowired
	private VehicleRepository repo;
	public void newadd(Vehicle vehicle)
	{
		repo.save(vehicle);
	}
}
