package com.goddoro.coffee_store.models;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private String title, description;
    private Double price;

    public Item() {
    }

    public Item(String title, String description, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Item(String title, String description, Image image, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
