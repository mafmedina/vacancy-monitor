package ar.com.vm.vacancymonitor.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.com.vm.vacancymonitor.models.VirtualMachine;

public interface VirtualMachineRepository extends CrudRepository<VirtualMachine, String> {
	@Override
	VirtualMachine findOne(String id);
	
	
	List<VirtualMachine> findByName(String name);
	//@Query("SELECT TOP 1 vm FROM VirtualMachine vm " +
	//		"WHERE vm.name = :name")
	//VirtualMachine findByName(@Param("name") String name);

	@Override
	void delete(VirtualMachine deleted);
}