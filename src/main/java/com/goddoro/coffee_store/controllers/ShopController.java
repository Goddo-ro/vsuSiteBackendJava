package com.goddoro.coffee_store.controllers;

import com.goddoro.coffee_store.models.Item;
import com.goddoro.coffee_store.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/shop")
    public String items(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        System.out.println(items);
        model.addAttribute("items", items);
        return "shop";
    }
}
