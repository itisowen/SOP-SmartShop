//package com.example.SmartShop;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RW {
//
//    public List<Book> Read() {
//        try {
//            FileInputStream fi = new FileInputStream("check.txt");
//            ObjectInputStream oi = new ObjectInputStream(fi);
//            List<Book> books = (List<Book>) oi.readObject();
//            oi.close();
//            return books;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void Write(List<Book> books) {
//        try {
//            FileOutputStream fo = new FileOutputStream("check.txt");
//            ObjectOutputStream os = new ObjectOutputStream(fo);
//            os.writeObject(books);
//            os.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
