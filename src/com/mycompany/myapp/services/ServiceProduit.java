/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rihem
 */
public class ServiceProduit {
     public ArrayList<Produit> produits;
    public static ServiceProduit instance ; 
    public boolean resultOK;
    private  ConnectionRequest req; 
 public static final String BASE_URL="http://127.0.0.1:8000/api";
 private ServiceProduit() {
        req = new ConnectionRequest() ; 
         }
    
    public static ServiceProduit getInstance() {
        if (instance == null)
        {
            instance = new ServiceProduit();
        }
         return instance;
    }
 
 public ArrayList<Produit> parseProduits(String jsonText){
        try {
            produits= new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> ProduitListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           List< Map<String,Object>> list =(List< Map<String,Object>>) ProduitListJson.get("root");
           for ( Map<String,Object> obj: list){
             Produit p = new Produit();
             float id = Float.parseFloat(obj.get("id").toString());
             float quantite = Float.parseFloat(obj.get("quantity").toString());

             p.setId((int)id);
           p.setName(obj.get("name").toString());
             p.setDescription(obj.get("description").toString());
             p.setBuyprice((double) obj.get("buyprice"));
             p.setSellprice((double) obj.get("sellprice"));

             p.setQuantity((int) quantite);
             produits.add(p);
         
        } }
           catch (IOException ex) {
//            Logger.getLogger(ServiceOeuvre.class.getName()).log(Level.SEVERE, null, ex);
             
        }
          return produits;
 }
     public ArrayList<Produit> getAllProduits(){
          String url = BASE_URL+"/productApi";
        req.setUrl(url);
        req.setPost(false);

                System.out.println(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduits(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
        public void Supprimer(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(BASE_URL+"/deleteProduitApi/"+id);
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
       public boolean addProd (TextField name,TextField Desc,TextField buyprice ,TextField sellprice,TextField quantite,Integer c)
    { 

       String url = BASE_URL+"/addProduitApi?name="+name.getText()+"&description="+Desc.getText()+"&buyprice="+buyprice.getText()+"&sellprice="+sellprice.getText()+"&cat="+c+"&quantity="+quantite.getText();
       req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>(){ 
           @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
             }
    });
        System.out.println(""+resultOK);
       NetworkManager.getInstance().addToQueue(req);
        return resultOK;
    }
           public boolean updateProd (TextField name,TextField Desc,TextField buyprice ,TextField sellprice,TextField quantite,Integer c,int id)
    { 

       String url = BASE_URL+"/editProduitApi/"+id+"?name="+name.getText()+"&description="+Desc.getText()+"&buyprice="+buyprice.getText()+"&sellprice="+sellprice.getText()+"&cat="+c+"&quantity="+quantite.getText();
       req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>(){ 
           @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
             }
    });
        System.out.println(""+resultOK);
       NetworkManager.getInstance().addToQueue(req);
        return resultOK;
    }
}
