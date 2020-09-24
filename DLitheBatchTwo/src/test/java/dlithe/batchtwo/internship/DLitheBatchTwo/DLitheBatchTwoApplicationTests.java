package dlithe.batchtwo.internship.DLitheBatchTwo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

@SpringBootTest
@RunWith(SpringRunner.class)
class DLitheBatchTwoApplicationTests 
{
	@MockBean
	VehicleRepository repo;
	@Autowired
	VehicleService serv;
	
	@Test
	public void testAdd()
	{
		Vehicle veh=new Vehicle(12, "Himalayan", "Gear", 500, 2019, 10, 20, 198700.8);
		Vehicle ve=null;
		when(repo.save(veh)).thenReturn(veh);
		assertEquals(veh, serv.newadd(veh));
		assertNotNull(serv.newadd(veh));// 
		ve=new Vehicle(10, "R15", "Gear", 150, 2020, 20, 30, 98700.3);
		assertFalse(serv.newadd(veh).getStkid()==10);
	}
	
	@Test
	public void testIterate()
	{
		List<Vehicle> storage=new Vector<Vehicle>();
		Vehicle veh1=new Vehicle(12, "Himalayan", "Gear", 500, 2019, 10, 20, 198700.8);
		Vehicle veh2=new Vehicle(10, "R15", "Gear", 150, 2020, 20, 30, 98700.3);
		Vehicle veh3=new Vehicle(10, "Avenger Cruise", "Gear", 220, 2016, 20, 40, 99700.3);
		storage.add(veh1);storage.add(veh2);storage.add(veh3);
		
		when(repo.findAll()).thenReturn(storage);
		assertTrue(serv.every().get(0).getCc()>=400);
		assertNull(serv.every().get(2));
	}
}
