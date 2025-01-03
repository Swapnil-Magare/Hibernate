package com.LAZYFetchType;

import javax.persistence.*;

@Entity
public class LAZYBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private LAZYAuthor author;

    // Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LAZYAuthor getAuthor() {
		return author;
	}

	public void setAuthor(LAZYAuthor author) {
		this.author = author;
	}

//	@Override
//	public String toString() {
//		return "LAZYBook [id=" + id + ", title=" + title + ", author=" + author + "]";
//	}
	
    
    
}
