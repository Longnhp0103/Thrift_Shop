/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author buile
 */
public class Attribute {

    private int attributeID;
    private String attributeName;
    private String attributeUnit;
    private int displayIndex;
    Category category = new Category();

    public Attribute(int attributeID, String attributeName, String attributeUnit, int displayIndex, Category category) {
        this.attributeID = attributeID;
        this.attributeName = attributeName;
        this.attributeUnit = attributeUnit;
        this.displayIndex = displayIndex;
        this.category = category;
    }

    public Attribute() {
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeUnit() {
        return attributeUnit;
    }

    public void setAttributeUnit(String attributeUnit) {
        this.attributeUnit = attributeUnit;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
