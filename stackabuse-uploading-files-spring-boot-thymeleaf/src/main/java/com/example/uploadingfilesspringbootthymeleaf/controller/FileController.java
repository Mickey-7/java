package com.example.uploadingfilesspringbootthymeleaf.controller;

import com.example.uploadingfilesspringbootthymeleaf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping()
    public String index(){
        return "upload";
    }

    // note the url "/uploadFile" is connected to upload.html
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes){
        //invoke service
        fileService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded "+file.getOriginalFilename()+"!");
        return "redirect:/";
    }


    // added for multiple upload
    @PostMapping("/uploadFiles")
    public String uploadFiles(@RequestParam MultipartFile[] files, RedirectAttributes redirectAttributes){
        Arrays.asList(files)
                .stream()
                //invoke service
                .forEach(file -> fileService.uploadFile(file));
        redirectAttributes.addFlashAttribute("message","You successfully uploaded all files!");
        return "redirect:/";
    }
}
