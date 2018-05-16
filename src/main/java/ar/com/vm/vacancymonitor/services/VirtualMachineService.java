package ar.com.vm.vacancymonitor.services;

import java.io.IOException;

import org.json.JSONException;

import ar.com.vm.vacancymonitor.models.VirtualMachine;

public interface VirtualMachineService {

	public void sendSlackPostRequest (String jsonText) throws IOException , JSONException;
	
	public VirtualMachine save(String name, String currentIP, String installedInstances, String currentUser);
	
	public VirtualMachine update(String id, String name, String currentIP, String installedInstances);
}
