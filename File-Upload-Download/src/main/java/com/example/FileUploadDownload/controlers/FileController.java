package com.example.FileUploadDownload.controlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileController {
	private final String uploadDirectory = "C:\\All_Works";
	private final String fileName = "upload_file.txt";

	@GetMapping("/")
	public String showuploadForm() {
		return "upload";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File destination = new File(uploadDirectory,fileName);
		file.transferTo(destination);
		return "redirect:/";		
	}

	@GetMapping("/download")
	public void downloadFile(HttpServletResponse response) throws IOException{
		File file = new File(uploadDirectory, fileName);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		try(InputStream inputStream = new FileInputStream(file);
				OutputStream outputStream = response.getOutputStream()){
			StreamUtils.copy(inputStream, outputStream);
		}
	}
}
