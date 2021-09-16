package ca.sheridancollege.mislim.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.mislim.FileUploadDirectory;

@Controller
public class FileUploadController {

	@Autowired
	FileUploadDirectory fileUploadDirectory;

	@RequestMapping("/")
	public String UploadPage() {
		return "uploadFiles.html";
	}

	@RequestMapping("/upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) {

		if (files[0].isEmpty()) {

			model.addAttribute("msg", "Please uplode at least one file ");
			return "uploadStatus.html";

		} else {

			StringBuilder fileNames = new StringBuilder();
			for (MultipartFile file : files) {
				Path fileNameAndPath = Paths.get(fileUploadDirectory.uploadDirectory,
						file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename() + " ");
				try {
					Files.write(fileNameAndPath, file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			model.addAttribute("msg", "Successfully uploaded files: " + fileNames.toString());
			return "uploadStatus.html";
		}
	}

}