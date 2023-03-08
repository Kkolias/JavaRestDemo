package com.harjotus.items;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ItemRestController {

   @Autowired
   private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(
            new Item("karkki", 2)
        );
    }

    @GetMapping("/api/items")
    public List<Item> listAll() {
        return itemRepository.findAll();
    }




}
