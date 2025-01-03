package com.LAZYFetchType;

import javax.persistence.*;
import java.util.List;

@Entity
public class LAZYAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Using FetchType.LAZY here to load books only when we need them
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<LAZYBook> books;


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

	public List<LAZYBook> getBooks() {
		return books;
	}

	public void setBooks(List<LAZYBook> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "LAZYAuthor [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	

   
}
