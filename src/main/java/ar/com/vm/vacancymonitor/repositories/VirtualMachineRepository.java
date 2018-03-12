package ar.com.vm.vacancymonitor.repositories;

import org.springframework.data.repository.CrudRepository;

import ar.com.vm.vacancymonitor.models.VirtualMachine;

public interface VirtualMachineRepository extends CrudRepository<VirtualMachine, String> {
	@Override
	VirtualMachine findOne(String id);

	@Override
	void delete(VirtualMachine deleted);
}