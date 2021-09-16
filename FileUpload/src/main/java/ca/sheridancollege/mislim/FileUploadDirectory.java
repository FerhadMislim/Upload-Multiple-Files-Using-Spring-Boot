package ca.sheridancollege.mislim;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
public class FileUploadDirectory {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	public static void main(String[] args) {
	new File(uploadDirectory).mkdir();
	}
}



	
