package com.example.galitogali.entity;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class payLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    @Column(name = "name" )
    private String name;
    @Column(name = "price" )
    private long price;
    @Column(name = "description" )
    private String description;
    @Column(name = "availability" )
    private Boolean availability;

    public payLoad() {
        super();
    }

    public payLoad(String name, long price, String description, Boolean availability) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
