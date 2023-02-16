package com.goddoro.coffee_store.controllers;

import com.goddoro.coffee_store.models.Image;
import com.goddoro.coffee_store.models.Item;
import com.goddoro.coffee_store.repo.ImageRepository;
import com.goddoro.coffee_store.repo.ItemRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StoreController {
    @Resource(name="itemRepository")
    private ItemRepository itemRepository;

    @Resource(name="imageRepository")
    private ImageRepository imageRepository;

    @GetMapping("/store")
    public String items(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        System.out.println(items.iterator().next().getImage().getId());
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
