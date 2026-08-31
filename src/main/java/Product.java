/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 25002955
 */
public class Product {
    private String code;
    private String name;
    private String category;
    private String warranty;
    private double price;
    private int stockLevel;
    private String supplier;
    
public Product(String code, String name, String category, String warranty, double price, int stockLevel, String supplier){
    
    this.code = code;
    this.name = name;
    this.category = category;
    this.warranty = warranty;
    this.price = price;
    this.stockLevel = stockLevel;
    this.supplier = supplier;   
}

public String getCode() { return code; } 
public String getName() { return name; }
public String getCategory() { return category; }
public String getWarranty() { return warranty; }
public double getPrice() { return price; }
public int getStockLevel() { return stockLevel; }
public String getSupplier() { return supplier; }

public void setCode(String code) { this.code = code; }
public void setName(String name) { this.name = name; }
public void setCategory(String category) { this.category = category; }
public void setWarranty(String warranty) { this.warranty = warranty; }
public void setPrice(double price) { this.price = price; }
public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
public void setSupplier(String supplier) { this.supplier = supplier; }
}
