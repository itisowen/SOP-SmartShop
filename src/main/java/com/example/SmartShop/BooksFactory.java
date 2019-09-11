package com.example.SmartShop;

public class BooksFactory {
    public static Book createBook(String name, String type, String description, double price) {
        if (type.equals("manga")) {
            return new manga(name, type, description, price);
        }else if (type.equals("history")
        ) {
            return new history(name, type, description, price);
        }else if (type.equals("fiction")) {
            return new fiction(name, type, description, price);
        }else{
            return new novel(name, type, description, price);
        }

    }
}
