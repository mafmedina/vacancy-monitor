package ar.com.vm.vacancymonitor.controllers;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vm.vacancymonitor.models.SlackOutgoingWebhook;
import ar.com.vm.vacancymonitor.models.VirtualMachine;
import ar.com.vm.vacancymonitor.repositories.VirtualMachineRepository;
import ar.com.vm.vacancymonitor.services.VirtualMachineService;

@RestController
@RequestMapping("/remote/")
public class RemoteVirtualMachinecontroller {

	@Autowired
	VirtualMachineRepository virtualMachineRepository;

	@Autowired
	VirtualMachineService virtualMachineService;

	@RequestMapping(path = "vmlist", method = RequestMethod.POST, consumes = { "application/json",
			"application/x-www-form-urlencoded" })
	public void listVirtualMachines(@ModelAttribute SlackOutgoingWebhook outgoingWebhook) {

		try {
			virtualMachineService.sendSlackPostRequest(virtualMachineService.getVMList());
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(path = "take", method = RequestMethod.POST, consumes = { "application/json",
			"application/x-www-form-urlencoded;charset=UTF-8" })
	public void remoteTake(@RequestParam("trigger_word") String triggerWord, @RequestParam("text") String text,
			@RequestParam("user_name") String userName) {
		VirtualMachine virtualMachine = virtualMachineRepository.findByName(text.replace(triggerWord, "")).get(0);
		if (virtualMachine != null) {
			virtualMachine.setCurrentUser(userName);
			virtualMachineRepository.save(virtualMachine);

			try {
				virtualMachineService.sendSlackPostRequest(
						"El usuario " + userName + " ha tomado " + virtualMachine.getName() + ".");
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(path = "release", method = RequestMethod.POST, consumes = { "application/json",
			"application/x-www-form-urlencoded" })
	public void remoteRelease(@RequestParam("trigger_word") String triggerWord, @RequestParam("text") String text) {
		VirtualMachine virtualMachine = virtualMachineRepository.findByName(text.replace(triggerWord, "")).get(0);
		if (virtualMachine != null) {
			virtualMachine.setCurrentUser("Libre");
			virtualMachineRepository.save(virtualMachine);

			try {
				virtualMachineService.sendSlackPostRequest(virtualMachine.getName() + " ha sido liberada.");
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
