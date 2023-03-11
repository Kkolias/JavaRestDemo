package com.harjotus.items;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "*")
public class ItemRestController {

   @Autowired
   private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(
            new Item("karkki", 2)
        );
    }

    @GetMapping("/api/items/get-all")
    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    
    @RequestMapping(
    value = "/api/items/new-item", 
    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> newItem( @RequestBody Item newItem) {
        
        try {
            Item created = itemRepository.save(
            new Item(newItem.name, newItem.price)
        );
            return new ResponseEntity<>(created, HttpStatus.OK);
        } catch(Exception  e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
    value = "/api/items/edit-item-name",
    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> editItemName( @RequestBody Item payload) {
            Long id = payload.id;
            String name = payload.name;
            Item item = itemRepository.findById(id).orElse(null);

            if(item == null) {
                return new ResponseEntity<>(false , HttpStatus.NOT_FOUND);
            }

            item.name = name;
            itemRepository.save(item);
            
            return new ResponseEntity<>(true , HttpStatus.OK);
        
    }


}
