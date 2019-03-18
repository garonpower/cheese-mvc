package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();
    static ArrayList<String> removedCheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {

        cheeses.put(cheeseName, description);

        return "redirect:";
    }
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeseForm(@RequestParam String cheese) {

// find out if checkbox is checked.  cheese=on, then add cheese name to array//
        if (cheese.equals("on")) {  // How to determine if box is check? also tried cheese == "on"
            removedCheeses.add(cheese);
        }

// iterate through array and remove any present cheese names from hashmap
        for (String type : removedCheeses) {
            cheeses.remove(type);
        }

        return "redirect";
    }

}
