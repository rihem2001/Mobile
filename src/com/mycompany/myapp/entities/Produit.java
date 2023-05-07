/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author rihem
 */
public class Produit {
    private int id;
    private String name;
    private String description;
    private double buyprice;
    private double sellprice;
    private int quantity;

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public double getSellprice() {
        return sellprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Produit(int id, String name, String description, double buyprice, double sellprice, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.buyprice = buyprice;
        this.sellprice = sellprice;
        this.quantity = quantity;
    }


  
 
}
