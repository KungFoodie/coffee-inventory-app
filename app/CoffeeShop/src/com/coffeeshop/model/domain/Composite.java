package com.coffeeshop.model.domain;

/**
 * Composite object that holds the inventory information such as items
 *
 */
public class Composite {

    /** holds the items in inventory */
    private Coffee beans;
    private Food foods;
    private Syrup syrups;

    public Composite() {}

    /**
     * @return beans
     */
    public Coffee getBeans() {
        return beans;
    }

    /**
     * @param beans value to set
     */
    public void setBeans(Coffee beans) {
        this.beans = beans;
    }

    /**
     * @return foods
     */
    public Food getFoods() {
        return foods;
    }

    /**
     * @param foods value to set
     */
    public void setFoods(Food foods) {
        this.foods = foods;
    }

    /**
     * @return syrup
     */
    public Syrup getSyrups() {
        return syrups;
    }

    /**
     * @param syrups value to set
     */
    public void setSyrups(Syrup syrups) {
        this.syrups = syrups;
    }

    @Override
    public String toString() {

        StringBuffer strBfr = new StringBuffer();
        strBfr.append("\nInventory Info :\n");
        strBfr.append("\n\nAvailable Coffee Beans :\n");
        strBfr.append(beans);
        strBfr.append("\n\nAvailable Food Items :\n");
        strBfr.append(foods);
        strBfr.append("\n\nAvailable Syrups :\n");
        strBfr.append(syrups);
        return strBfr.toString();
    }
}
