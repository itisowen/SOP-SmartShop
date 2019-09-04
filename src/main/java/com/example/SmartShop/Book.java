package com.example.SmartShop;

public class Book {
    private int id;
    private String name;
    private String type;
    private String description;
    private int price;

    public Book(int id, String name, String type, String description, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public Book() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

class manga extends Book{
    public manga(int id, String name, String type, String description, int price){
        super(id, name, type, description, price);
    }
}

class history extends Book{
    public history(int id, String name, String type, String description, int price){
        super(id, name, type, description, price);
    }
}

class fiction extends Book{
    public fiction(int id, String name, String type, String description, int price){
        super(id, name, type, description, price);
    }
}

class novel extends Book{
    public novel(int id, String name, String type, String description, int price){
        super(id, name, type, description, price);
    }
}