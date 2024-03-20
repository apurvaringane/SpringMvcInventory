package org.jspiders.SpringMvcInventory.controller;

import jakarta.validation.Valid;
import org.jspiders.SpringMvcInventory.domain.Item;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {
    private List<String> categories = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    {
        categories.add("ELECTRONICS");
        categories.add("GADGETS");
        categories.add("STATIONARY");
        categories.add("FURNITURE");
    }
    @GetMapping("/")
    public String getInventoryForm(Model model) {
        model.addAttribute("categories", categories);
       Item item=new Item();
       model.addAttribute("item",item);
//       // model.addAttribute("product",new Item());
        return "itemform";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("item",itemList);
        return "inventory";
    }

    @PostMapping("/saveitem")
    public String saveItem(@Valid Item item,BindingResult result,Model model) {
        if (item.getPrice()<item.getDiscount())
            result.rejectValue("price","","disount should be less than price");

        boolean status=result.hasErrors();
        if (status)
            return "/itemform";
        itemList.add(item);
        return "redirect:/inventory";
    }

    @GetMapping("delete/{name}")
    public String deleteItem(@PathVariable(name = "name") String name){
        Item i1=null;
        for (Item i:itemList){
            if (i.getName().equals(name)){
                i1=i;
            }
        }
        itemList.remove(i1);
        return "redirect:/inventory";
    }
}