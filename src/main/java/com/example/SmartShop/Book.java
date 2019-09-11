package com.example.SmartShop;

import java.io.*;

public class Book implements Serializable {
    private String name;
    private String type;
    private String description;
    private double price;

    public Book(String name, String type, String description, double price) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

class manga extends Book{
    public manga(String name, String type, String description, double price){
        super(name, type, description, price);
    }
}

class history extends Book{
    public history(String name, String type, String description, double price){
        super(name, type, description, price);
    }
}

class fiction extends Book{
    public fiction(String name, String type, String description, double price){
        super(name, type, description, price);
    }
}

class novel extends Book{
    public novel(String name, String type, String description, double price){
        super(name, type, description, price);
    }
}