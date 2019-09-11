package com.example.SmartShop;

public class Publisher {
    public String name;
    public String phone;
    private static Publisher instance;

    private Publisher(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Publisher getInstance(){
        if (instance == null){
            instance = new Publisher();
        }
        return instance;
    }


}
