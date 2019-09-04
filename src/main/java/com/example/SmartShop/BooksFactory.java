package com.example.SmartShop;

public class BooksFactory {
    public static Book createBook(int id, String name, String type, String description, int price) {
        if (type.equals("manga")) {
            return new manga(id, name, type, description, price);
        }else if (type.equals("history")
        ) {
            return new history(id, name, type, description, price);
        }else if (type.equals("fiction")) {
            return new fiction(id, name, type, description, price);
        }else{
            return new novel(id, name, type, description, price);
        }

    }
}
