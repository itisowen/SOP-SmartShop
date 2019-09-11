package com.example.SmartShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SmartShopApplication {
	private static List<Book> listBooks = new ArrayList<Book>();
	{
		File file = new File("check.txt");
		if (file.exists()){
			System.out.println("TO0T0O");
			listBooks = Read();
		}
		else{
			listBooks.add(BooksFactory.createBook("One Piece", "การ์ตูน", "สนุกมากกก ยังไม่จบ", 65));
			listBooks.add(BooksFactory.createBook("Naruto", "การ์ตูน", "สนุกก จบไปแล้ว", 65));
			listBooks.add(BooksFactory.createBook("หนูน้อยหมวกแดง", "นิทาน", "อ่านเมื่อนานมากกๆแล้วว", 50));
			Write();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping(value = "getall")
	public List<Book> getall() {
		return listBooks;
	}

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Book> getType(@PathVariable int id) {
		int count = 0;
		for (Book i : listBooks) {
			count += 1;
			if (id == count) {
				return new ResponseEntity<Book>(i, HttpStatus.OK);
			}
		}
		return null;

	}

	@RequestMapping(value = "/searchtype/{type}")
	public List<Book> getType(@PathVariable String type) {
		List<Book> listType = new ArrayList<Book>();
		for (Book i : listBooks) {
			if (i.getType().toLowerCase().equals(type)) {
				listType.add(i);
			}
		}
		return listType;

	}

//	@RequestMapping(value = "/get")
//	public ResponseEntity<List<Book>> get() {
//		Book book = new Book();
//		book.setName("Naruto");
//		book.setType("novel");
//		book.setDescription("love fight");
//		book.setPrice(60);
//		this.listBooks.add(book);
//		return new ResponseEntity<List<Book>>(this.listBooks, HttpStatus.OK);
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<List<Book>> create(@RequestBody Book book) {
		String name = book.getName();
		String type = book.getType();
		String description = book.getDescription();
		double price = book.getPrice();
		this.listBooks.add(new Book(name, type, description, price));

		Write();
		return new ResponseEntity<List<Book>>(this.listBooks, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Book>> delete(@PathVariable int id) {
		int count = 0;
		for (Book i : this.listBooks) {
			count += 1;
			if (id == count) {
				this.listBooks.remove(i);
				break;
			}
		}
		Write();
		return new ResponseEntity<List<Book>>(this.listBooks, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
		String name = book.getName();
		String type = book.getType();
		String description = book.getDescription();
		double price = book.getPrice();
		int count = 0;
		for (Book i : this.listBooks) {
			count += 1;
			if (id == count) {
				i.setName(name);
				i.setType(type);
				i.setDescription(description);
				i.setPrice(price);
				return new ResponseEntity<Book>(i, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	public List<Book> Read(){
		try {
			FileInputStream fis = new FileInputStream("check.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Book> lstbook = (List<Book>) ois.readObject();
			ois.close();
			return lstbook;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Write(){

		try {
			FileOutputStream fos = new FileOutputStream("check.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.listBooks);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


