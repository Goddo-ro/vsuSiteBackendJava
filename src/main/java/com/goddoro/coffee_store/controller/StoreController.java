package com.goddoro.coffee_store.controller;

import com.goddoro.coffee_store.entity.Image;
import com.goddoro.coffee_store.entity.Item;
import com.goddoro.coffee_store.repository.ImageRepository;
import com.goddoro.coffee_store.repository.ItemRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class StoreController {
    @Resource(name="itemRepository")
    private ItemRepository itemRepository;

    @Resource(name="imageRepository")
    private ImageRepository imageRepository;

    @GetMapping("/store")
    public String items(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "store";
    }

    @GetMapping("/store/{id}")
    public String getItem(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);

        return "store_details";
    }

    @PostMapping("/store/{id}/remove")
    public String removeItem(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);

        return "redirect:/store";
    }

    @GetMapping("/store/{id}/edit")
    public String editItem(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);

        return "store_edit";
    }

    @PostMapping("/store/{id}/edit")
    public String editItemPost(@PathVariable Long id, @RequestParam MultipartFile file, @RequestParam String title,
                               @RequestParam double price, @RequestParam String description,
                               Model model) throws IOException {
        Item item = itemRepository.findById(id).orElseThrow();

        if (!file.isEmpty()) {
            Image image = item.getImage();
            image.setName(file.getName());
            image.setContent(file.getBytes());
            imageRepository.save(image);
        }

        item.setTitle(title);
        item.setPrice(price);
        item.setDescription(description);
        itemRepository.save(item);

        return "redirect:/store";
    }

    @GetMapping("/store/add")
    public String addItem(Model model) {
        return "store_add";
    }

    @PostMapping("/store/add")
    public String addItemPost(@RequestParam MultipartFile file, @RequestParam String title,
                              @RequestParam double price, @RequestParam String description,
                              Model model) throws Exception {
        Image img = new Image();
        img.setName(file.getName());
        img.setContent(file.getBytes());
        imageRepository.save(img);

        Item item = new Item(title, description, img, price);
        itemRepository.save(item);

        return "redirect:/store";
    }
}
