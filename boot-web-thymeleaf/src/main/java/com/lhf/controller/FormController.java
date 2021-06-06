package com.lhf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: lhf
 * @Date: 2021/5/26 16:42
 */
@Controller
@Slf4j
public class FormController {

    @GetMapping(value = "/toFromPage")
    public String toFromPage() {
        return "form/form_layouts";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws Exception {

        if(!headerImg.isEmpty()) {
            headerImg.transferTo(new File("D:\\tmp\\" + headerImg.getOriginalFilename()));
        }

        if(photos.length > 0) {
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()) {
                    photo.transferTo(new File("D:\\tmp\\photo\\" + photo.getOriginalFilename()));
                }
            }
        }
        return "index";
    }
}
