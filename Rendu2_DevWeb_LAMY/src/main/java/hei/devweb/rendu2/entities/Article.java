package hei.devweb.rendu2.entities;

import javax.servlet.annotation.WebServlet;


public class Article {

    private Integer id ;
    private String name ;
    private String brand ;
    private String gender ;
    private String price ;

       public Article (Integer id,String name,String brand,String gender,String price){
        super();
        this.id = id ;
        this.name = name ;
        this.brand = brand ;
        this.gender = gender ;
        this.price = price ;}




    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}

}
