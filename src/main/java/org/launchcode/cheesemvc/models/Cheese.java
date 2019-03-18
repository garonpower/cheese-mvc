package org.launchcode.cheesemvc.models;

public class Cheese {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

/*Refactor the CheeseController to use Cheese objects rather than the strings that were used previously.
        You'll need to update your views as well.*/
