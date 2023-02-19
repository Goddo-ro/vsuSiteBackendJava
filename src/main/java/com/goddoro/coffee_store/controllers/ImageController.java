package com.goddoro.coffee_store.controllers;

import com.goddoro.coffee_store.entity.Image;
import com.goddoro.coffee_store.repo.ImageRepository;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ImageController {
    @Resource(name="imageRepository")
    ImageRepository imageRepository;

    @GetMapping("/image/get")
    public void getImage(@RequestParam("id") Long id, HttpServletResponse response) throws IOException {
        Image image = imageRepository.findById(id).orElseThrow();

        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(image.getContent());
        response.getOutputStream().close();
    }
}
