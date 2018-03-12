package ar.com.vm.vacancymonitor.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "virtualMachines")
public class VirtualMachine {
	@Id
	String id;
	String name;
	String currentIP;
	String installedInstances;
	String currentUser;

	public VirtualMachine() {
	}

	public VirtualMachine(String id, String name, String currentIP, String installedInstances, String currentUser) {
		super();
		this.id = id;
		this.name = name;
		this.currentIP = currentIP;
		this.installedInstances = installedInstances;
		this.currentUser = currentUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentIP() {
		return currentIP;
	}

	public void setCurrentIP(String currentIP) {
		this.currentIP = currentIP;
	}

	public String getInstalledInstances() {
		return installedInstances;
	}

	public void setInstalledInstances(String installedInstances) {
		this.installedInstances = installedInstances;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

}
