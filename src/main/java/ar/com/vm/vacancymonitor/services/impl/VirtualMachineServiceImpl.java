package ar.com.vm.vacancymonitor.services.impl;

import java.io.IOException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.com.vm.vacancymonitor.models.SlackOutgoingWebhook;
import ar.com.vm.vacancymonitor.models.VirtualMachine;
import ar.com.vm.vacancymonitor.repositories.VirtualMachineRepository;
import ar.com.vm.vacancymonitor.services.VirtualMachineService;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {

	@Autowired
	private VirtualMachineRepository virtualMachineRepository;

	@Value("${slack.hook.url}")
	private String slackHookUrl;

	public void sendSlackPostRequest(String jsonText) throws IOException, JSONException {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			JSONObject json = new JSONObject();
			json.put("text", jsonText);

		try {

			HttpPost request = new HttpPost(slackHookUrl);
			StringEntity params = new StringEntity(json.toString());
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			httpClient.execute(request);
			// handle response here...
		} catch (Exception ex) {
			// handle exception here
		} finally {
			httpClient.close();
		}
	}
	
    public VirtualMachine save(String name, String currentIP, String installedInstances, String currentUser) {
        VirtualMachine virtualMachine = new VirtualMachine();
        virtualMachine.setName(name);
        virtualMachine.setCurrentIP(currentIP);
        virtualMachine.setInstalledInstances(installedInstances);
        virtualMachine.setCurrentUser(currentUser);
        virtualMachineRepository.save(virtualMachine);
        return virtualMachine;
    }
    
    public VirtualMachine update(String id, String name, String currentIP, String installedInstances) {
    	VirtualMachine virtualMachine = virtualMachineRepository.findOne(id);
        virtualMachine.setName(name);
        virtualMachine.setCurrentIP(currentIP);
        virtualMachine.setInstalledInstances(installedInstances);
        virtualMachineRepository.save(virtualMachine);
        return virtualMachine;  
    }
    
    public String getVMList(){
		String vmList = "";
    	for (VirtualMachine vm : virtualMachineRepository.findAll()) {
    		vmList = vmList + vm.getName() + ": " + vm.getCurrentUser() + "\n";
    	}
    	return vmList;
    }
    
    public void remoteTake(SlackOutgoingWebhook outgoingWebhook) {
    	
    }
	
}
