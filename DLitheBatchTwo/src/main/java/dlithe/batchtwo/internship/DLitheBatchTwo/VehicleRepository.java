package dlithe.batchtwo.internship.DLitheBatchTwo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> 
{
	@Query("from Vehicle where milage>= :milage")
	public List<Vehicle> readByMilage(int milage);
	@Query("from Vehicle where cc<= :cc")
	public List<Vehicle> readByCc(int cc);
	@Query("select model from Vehicle where price<=:price")
	public List<String> readByPrice(double price);
}
