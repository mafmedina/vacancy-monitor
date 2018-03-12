package ar.com.vm.vacancymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("ar.com.vm.vacancymonitor.repositories")
public class VacancyMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacancyMonitorApplication.class, args);
	}
}
