package view;

import controller.OrderController;
import controller.ProductController;
import model.Category;
import model.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductView {
    private static final ProductView instance = new ProductView();

    private ProductView() {
    }

    public static ProductView getInstance(){
        return instance;
    }

    Scanner scanner = new Scanner(System.in);

    public void showProductView(){
        System.out.println("===========================");
        System.out.println("====== Product view ======|");
        System.out.println("===|1. Show all product ==|");
        System.out.println("===|2. Cart ==============|");
        System.out.println("===|3. Add product =======|");
        System.out.println("===|4. Back ==============|");
        int choice = 0;
        try {
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("pls enter a number!");
            showProductView();
        }

        switch (choice){
            case 1:
                ProductController.getInstance().showListProduct();
                break;
            case 2:
                OrderController.getInstance().showCart();
                break;
            case 3:
                ProductController.getInstance().AddProduct();
                break;
            case 4:
                MainMenu.getInstance().mainMenu();
                break;
            default: showProductView();
        }
    }

    public Product addProductView() {
        scanner.nextLine();
        System.out.println("======== Add product =========");
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter category: ");
        System.out.println("|1. Android ");
        System.out.println("|2. IOS ");
        int catChoice = 0;

        while (catChoice <= 0 || catChoice >2){
            try {
                System.out.println("choice:");
                catChoice  = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("pls choose 1 or 2!");
                catChoice = 3;
            }
        }
        System.out.println("catchoi");
        System.out.println(catChoice);
        String category = "no";
        switch (catChoice){
            case 1:
                 category = "Android";
                break;
            case 2:
                category = "IOS";
                break;
            default:
        }
        System.out.println("Enter product price: ");
        float price = scanner.nextFloat();

        Product product = new Product(name, category, price);
        return product;
    }

    public void showListProduct(Map<String,Product> products){
        System.out.println("==== List product ====");
        if (products.size() <= 1){
            System.out.println("You have no product!");
        }else {
            for (Product product: products.values()) {
                if (product.getName().equals("id")) continue;
                System.out.println(product.toString());
            }
        }
        System.out.println("|== 1. Back ==================|");
        System.out.println("|== 2. Detail product ========|");
        int choice = 0;
        try {
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("pls enter a number!");
            showListProduct(products);
        }
        switch (choice){
            case 1:
                showProductView();
                break;
            case 2:
                System.out.println("Enter product ID: ");
                int productId = scanner.nextInt();
                ProductController.getInstance().detailProduct(productId);
                break;
            default:
                showListProduct(products);
        }
    }


    public void detailProduct(Product product){
        System.out.println("|==== Product detail ====");
        System.out.println("|Name: " + product.getName());
        System.out.println("|Price: " + product.getPrice());
        System.out.println("|Category: " + product.getCategory());
        System.out.println("=======================");
        System.out.println("|== 1. Back ==========|");
        System.out.println("|== 2. Add to cart ===|");

        int choice = 0;
        try {
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("pls enter a number!");
            detailProduct(product);
        }

        switch (choice){
            case 1:
                showProductView();
                break;
            case 2:
                OrderController.getInstance().addToCart(product);
                break;
            default:
                detailProduct(product);
        }
    }
}
