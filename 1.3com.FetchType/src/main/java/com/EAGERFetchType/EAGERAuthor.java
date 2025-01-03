package com.EAGERFetchType;

import javax.persistence.*;
import java.util.List;

@Entity
public class EAGERAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Using FetchType.EAGER to load books immediately when the author is loaded
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<EAGERBook> books;

    // Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EAGERBook> getBooks() {
		return books;
	}

	public void setBooks(List<EAGERBook> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "EAGERAuthor [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
    

}
