package com.goddoro.coffee_store.controllers;

import com.goddoro.coffee_store.models.Item;
import com.goddoro.coffee_store.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/store")
    public String items(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "store";
    }

    @GetMapping("/store/add")
    public String addItem(Model model) {
        return "store_add";
    }
}
