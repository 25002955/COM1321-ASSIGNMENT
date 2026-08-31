/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 25002955
 */
public class ReportData {
    private String productCode;
    private String productName;
    private String productCategory;
    private String productWarranty;
    private double productPrice;
    private int stockLevel;
    private String supplier;
    
    public ReportData(String productCode, String productName, String productCategory, String productWarranty, double productPrice, int stockLevel, String supplier) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productWarranty = productWarranty;
        this.productPrice = productPrice;
        this.stockLevel = stockLevel;
        this.supplier = supplier;
    }
    
public String getProductCode() {
    return productCode;
}

public String getProductName() {
    return productName;
}

public String getProductCategory() {
    return productCategory;
}

public String getProductWarranty() {
    return productWarranty;
}

public double getProductPrice() {
    return productPrice;
}

public int getStockLevel() {
    return stockLevel;
}

public String getSupplier() {
    return supplier;
}

public void setProductCode(String productCode) {
    this.productCode = productCode;
}

public void setProductName(String productName) {
    this.productName = productName;
}

public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
}

public void setProductWarranty(String productWarranty) {
    this.productWarranty = productWarranty;
}

public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
}

public void setStockLevel(int stockLevel) {
    this.stockLevel = stockLevel;
}

public void setSupplier(String supplier) {
    this.supplier = supplier;
}
}
