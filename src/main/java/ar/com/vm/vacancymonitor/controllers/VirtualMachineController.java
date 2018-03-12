package ar.com.vm.vacancymonitor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.vm.vacancymonitor.models.VirtualMachine;
import ar.com.vm.vacancymonitor.repositories.VirtualMachineRepository;

@Controller
public class VirtualMachineController {


    @Autowired
    VirtualMachineRepository virtualMachineRepository;

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
        VirtualMachine virtualMachine = new VirtualMachine();
        virtualMachine.setName(name);
        virtualMachine.setCurrentIP(currentIP);
        virtualMachine.setInstalledInstances(installedInstances);
        virtualMachine.setCurrentUser(currentUser);
        virtualMachineRepository.save(virtualMachine);

        return "redirect:/show/" + virtualMachine.getId();
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
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String name, @RequestParam String currentIP, @RequestParam String installedInstances, @RequestParam String currentUser) {
    	VirtualMachine virtualMachine = virtualMachineRepository.findOne(id);
        virtualMachine.setName(name);
        virtualMachine.setCurrentIP(currentIP);
        virtualMachine.setInstalledInstances(installedInstances);
        virtualMachine.setCurrentUser(currentUser);
        virtualMachineRepository.save(virtualMachine);

        return "redirect:/show/" + virtualMachine.getId();
    }
}
