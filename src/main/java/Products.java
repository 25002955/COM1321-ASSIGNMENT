/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 25002955
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    private ArrayList<Products> productList;
    private Scanner scanner;
    private String code;
    private String name;
    private String category;
    private String warranty;
    private double price;
    private int stockLevel;
    private String supplier;
    
    public Products() {
        productList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public Products(String code, String name, String category, String warranty, double price, int stockLevel, String supplier) {
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
     
     public void setName(String name) { this.name = name; }
     public void setCategory(String category) { this.category = category; }
     public void setWarranty(String warranty) { this.warranty = warranty; }
     public void setPrice(double price) { this.price = price; }
     public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
     public void setSupplier(String supplier) { this.supplier = supplier; }
     
    public void displayMenu(){
        System.out.println("Extreme IT Products");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String choice = scanner.nextLine();
        
        if (choice.equals("1")) {
            showMainMenu();
        }
        else{
            System.out.println("Exiting application");
            System.exit(0);
        }
    }
    
    private void showMainMenu(){
        while(true){
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new product.");
            System.out.println("(2) Search for a product.");
            System.out.println("(3) Update a product.");
            System.out.println("(4) Delete a product.");
            System.out.println("(5) Print report.");
            System.out.println("(6) Exit Application.");
            
            String option = scanner.nextLine();
            
            switch(option){
                case "1":
                    saveProduct();
                    break;
                case "2":
                    searchProduct();
                    break;
                case "3":
                    updateProduct();
                    break;
                case "4":
                    deleteProduct();
                    break;
                case "5":
                    printReport();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public void saveProduct(){
        System.out.println("\nCAPTURE A NEW PRODUCT");
        
        System.out.println("Enter the product code: ");
        String code = scanner.nextLine();
        
        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();
        
        int categoryChoice = getValidCategory();
        String category = getCategoryName(categoryChoice);
        
        String warranty = getWarrantyOption();
        
        System.out.println("Enter the price for " + name + ">>");
        double price = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Enter the stock level for " + name + ">>");
        int stockLevel = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Enter the supplier for " + name + ">>");
        String supplier = scanner.nextLine();
        
        Products product = new Products (code, name, category, warranty, price, stockLevel, supplier);
        productList.add(product);
        
        System.out.println("Product details have been saved succesfully!!!");
        returnToMenu();
    }
    
private int getValidCategory(){
    int choice;
    while(true){
        System.out.println("\nSelect the product category:");
        System.out.println("Desktop Computer - 1");
        System.out.println("Laptop - 2");
        System.out.println("Tablet - 3");
        System.out.println("Printer - 4");
        System.out.println("Gaming Console - 5");
        System.out.println("Product Category >> ");
        
        try{
            choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= 5) {
                return choice;
            } else {
                System.out.println("Invalid category. Please enter a number between 1 and 5.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    }

private String getCategoryName(int choice) {
    switch (choice) {
        case 1: return "Desktop Computer";
        case 2: return "Laptop";
        case 3: return "Tablet";
        case 4: return "Printer";
        case 5: return "Gaming Console";
        default: return "Unknown";
    }
}

private String getWarrantyOption() {
    System.out.println("\nIndicate the product warranty.");
    System.out.println("Enter (1) for 6 months or any other key for 2 years.");
    String input = scanner.nextLine();
    
    if (input.equals("1")) {
        return "6 months" ;
    } else {
        return "2 years";
    }
}

public void searchProduct() {
    System.out.println("\nPlease enter the product code to search: ");
    String code = scanner.nextLine();
    
    Products foundProduct = findProductByCode(code);
    
    if (foundProduct != null) {
        System.out.println("\nPRODUCT SEARCH RESULTS");
        System.out.println("PRODUCT CODE: " + foundProduct.getCode());
        System.out.println("PRODUCT NAME: " + foundProduct.getName());
        System.out.println("PRODUCT WARRANTY: " + foundProduct.getWarranty());
        System.out.println("PRODUCT CATEGORY: " + foundProduct.getCategory());
        System.out.println("PRODUCT PRICE: R " + foundProduct.getPrice());
        System.out.println("PRODUCT STOCK LEVELS: " + foundProduct.getStockLevel());
        System.out.println("PRODUCT SUPPLIER: " + foundProduct.getSupplier());
    } else {
        System.out.println("The product cannot be located. Invalid Product.");
    }
    returnToMenu();
}

private Products findProductByCode(String code) {
    for (Products product : productList) {
        if (product.getCode().equalsIgnoreCase(code)) {
            return product;
        }
    }
    return null;
}

public void deleteProduct() {
    System.out.println("\nPlease enter the product code to delete: ");
    String code = scanner.nextLine();
    
    Products foundProduct = findProductByCode(code);
    
    if (foundProduct != null) {
        System.out.println("Are you sure you want to delete " + foundProduct.getName() + "? (y/n)");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            productList.remove(foundProduct);
            System.out.println("Product deleted succesfully!");
        } else {
            System.out.println("Deletion cancelled,");
        }
    } else {
        System.out.println("Product not found.");
    }
    returnToMenu();
}

public void updateProduct() {
    System.out.println("\nPlease enter the product code to update: ");
    String code = scanner.nextLine();
    
    Products foundProduct = findProductByCode(code);
    
    if (foundProduct != null) {
        System.out.println("Update the warranty? (y) Yes, (n) No");
        String updateWarranty = scanner.nextLine();
        if (updateWarranty.equalsIgnoreCase("y")) {
            String newWarranty = getWarrantyOption();
            foundProduct.setWarranty(newWarranty);
        }
        
        System.out.println("Update the product price? (y) Yes, (n) No");
        String updatePrice = scanner.nextLine();
        if (updatePrice.equalsIgnoreCase("y")) {
            System.out.println("Enter the new price for " + foundProduct.getName() + ">>");
            double newPrice = Double.parseDouble(scanner.nextLine());
            foundProduct.setPrice(newPrice);
        }
        
        System.out.println("Update the stock level? (y) Yes, (n) No");
        String updateStock = scanner.nextLine();
        if (updateStock.equalsIgnoreCase("y")) {
            System.out.println("Enter the new stock level for " + foundProduct.getName() + ">>");
            int newStock = Integer.parseInt(scanner.nextLine());
            foundProduct.setStockLevel(newStock);
        }
        
        System.out.println("Product details has been updated successfully!!!");
    } else {
        System.out.println("Product not found.");
    }
    returnToMenu();
}

public void printReport() {
    System.out.println("\nPRODUCT REPORT");
    
    if (productList.isEmpty()){
        System.out.println("No producte available.");
        returnToMenu();
        return;
    }
    
    int productCount = 0;
    double totalValue = 0;
    
    for (Products product : productList) {
        productCount++;
        System.out.println("PRODUCT " + productCount);
        System.out.println("PRODUCT CODE >" + product.getCode());
        System.out.println("PRODUCT NAME >" + product.getName());
        System.out.println("PRODUCT CATEGORY >" + product.getCategory());
        System.out.println("PRODUCT WARRANTY >" + product.getWarranty());
        System.out.println("PRODUCT PRICE >" + product.getPrice());
        System.out.println("PRODUCT LEVEL >" + product.getStockLevel());
        System.out.println("PRODUCT SUPPLIER >" + product.getSupplier());
        totalValue += product.getPrice();
    }
    
    double averageValue = totalValue / productCount;
    
    System.out.println("TOTAL PRODUCT COUNT: " + productCount);
    System.out.println("TOTAL PRODUCT VALUE: " + totalValue);
    System.out.println("AVERAGE PRODUCT VALUE: R " + String.format("%.2f", averageValue));
    
    returnToMenu();
}

private void returnToMenu() {
    System.out.println("\nEnter (1) to launch menu or any other key to exit");
    String choice = scanner.nextLine();
    if (choice.equals("1")) {
        showMainMenu();
    } else {
        System.out.println("Exiting application...");
        System.exit(0);
    }
}
}

