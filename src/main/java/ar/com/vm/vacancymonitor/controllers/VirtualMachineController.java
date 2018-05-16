package ar.com.vm.vacancymonitor.controllers;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.vm.vacancymonitor.models.VirtualMachine;
import ar.com.vm.vacancymonitor.repositories.VirtualMachineRepository;
import ar.com.vm.vacancymonitor.services.VirtualMachineService;

@Controller
public class VirtualMachineController {


    @Autowired
    VirtualMachineRepository virtualMachineRepository;
    
    @Autowired
    VirtualMachineService virtualMachineService;

    @RequestMapping("/virtualMachine")
    public String virtualMachine(Model model) {
        model.addAttribute("virtualMachines", virtualMachineRepository.findAll());
        return "virtualMachine";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String name, @RequestParam String currentIP, @RequestParam String installedInstances, @RequestParam String currentUser) {
        return "redirect:/show/" + virtualMachineService.save(name, currentIP, installedInstances, currentUser).getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("virtualMachine", virtualMachineRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        VirtualMachine virtualMachine = virtualMachineRepository.findOne(id);
        virtualMachineRepository.delete(virtualMachine);

        return "redirect:/virtualMachine";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("virtualMachine", virtualMachineRepository.findOne(id));
        return "edit";
    }
    
    @RequestMapping("/take/{id}")
    public String take(@PathVariable String id, Model model) {
        model.addAttribute("virtualMachine", virtualMachineRepository.findOne(id));
        return "take";
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String name, @RequestParam String currentIP, @RequestParam String installedInstances) {
        return "redirect:/show/" + virtualMachineService.update(id, name, currentIP, installedInstances).getId();
    }
    
    @RequestMapping("/take")
    public String take(@RequestParam String id, @RequestParam String currentUser) {
    	VirtualMachine virtualMachine = virtualMachineRepository.findOne(id);
        virtualMachine.setCurrentUser(currentUser);
        virtualMachineRepository.save(virtualMachine);

        try {
			virtualMachineService.sendSlackPostRequest("El usuario " + currentUser + " ha tomado " + virtualMachine.getName()+ ".");
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "redirect:/show/" + virtualMachine.getId();
    }
    
    @RequestMapping("/release/{id}")
    public String release(@PathVariable String id) {
    	VirtualMachine virtualMachine = virtualMachineRepository.findOne(id);
        virtualMachine.setCurrentUser("");
        virtualMachineRepository.save(virtualMachine);
        
        try {
			virtualMachineService.sendSlackPostRequest(virtualMachine.getName() + " ha sido liberada.");
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return "redirect:/show/" + virtualMachine.getId();
    }
    
}
