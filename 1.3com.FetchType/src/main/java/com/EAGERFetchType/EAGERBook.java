package com.EAGERFetchType;

import javax.persistence.*;

@Entity
public class EAGERBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private EAGERAuthor author;

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

	public EAGERAuthor getAuthor() {
		return author;
	}

	public void setAuthor(EAGERAuthor author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "EAGERBook [id=" + id + ", title=" + title + ", author=" + author + "]";
	}


}

