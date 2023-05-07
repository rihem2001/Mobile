/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author rihem
 */
public class Categorie {
     private int id;
      private String name;
      private String slug;
    

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, String type_categorie) {
        this.id = id_categorie;
        this.name = nom_categorie;
        this.slug = type_categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id + ", nom_categorie=" + name + ", type_categorie=" + slug + '}';
    }
     
     
}
