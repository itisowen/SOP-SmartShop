package com.example.SmartShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SmartShopApplication {
	private static List<Book> allBooks = new ArrayList<Book>();
	static {
		allBooks.add(BooksFactory.createBook(1, "OnePiece", "manga", "สนุกมากกก ยังไม่จบ", 65));
		allBooks.add(BooksFactory.createBook(2, "Naruto", "manga", "สนุกก แต่จบไปแล้ว", 65));
		allBooks.add(BooksFactory.createBook(3, "หนูน้อยหมวกแดง", "fiction", "อ่านเมื่อนานมากกๆแล้วว", 50));
	}

	@RequestMapping("/")
	String home(){
		return "TEST";
	}
	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping("/books")
	public List<Book> getAllBooks(){
		return this.allBooks;
//				new Book(1, "One Piece", "การ์ตูน", "สนุกมากกก ยังไม่จบ", 65),
//				new Book(2, "Naruto", "การ์ตูน", "สนุกก จบไปแล้ว", 65),
//				new Book(3, "หนูน้อยหมวกแดง", "นิทาน", "อ่านเมื่อนานมากกๆแล้วว", 50)
	}

	@RequestMapping("/searchname/{name}")
	public List<Book> getName(@PathVariable String name){
		List<Book> sh = new ArrayList<Book>();
		for (Book list: getAllBooks()){
			if (list.getName().toLowerCase().equals(name)){
				sh.add(list);
			}
		}
		return sh;

	}

	@RequestMapping("/searchtype/{type}")
	public List<Book> getType(@PathVariable String type){
		List<Book> sh = new ArrayList<Book>();
		for (Book list: getAllBooks()){
			if (list.getType().toLowerCase().equals(type)){
				sh.add(list);
			}
		}
		return sh;

	}

	@PostMapping("/addbook")
	public List<Book> newBook(@RequestParam(value = "name", defaultValue = "name") String name,
							  @RequestParam(value = "type", defaultValue = "type") String type,
							  @RequestParam(value = "description", defaultValue = "description") String description,
							  @RequestParam(value = "price", defaultValue = "0") int price
	){
		int id = this.allBooks.size();
		id++;
		String typeBook = "manga";
		if (type.equals("manga")){
			typeBook = "manga";
		}else if (type.equals("history")){
			typeBook = "history";
		}else if (type.equals("fiction")){
			typeBook = "fiction";
		}else {
			typeBook = "novel";
		}
		this.allBooks.add(BooksFactory.createBook(id, name, type, description, price));
		return this.allBooks;
	}



}
