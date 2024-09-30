package src.main.java;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.model.Order_detail;
import src.main.java.model.Product;
import src.main.java.model.Order;
import src.main.java.service.Order_service;
import src.main.java.service.Product_service;


public class Main {
    public static List<Product> products=new ArrayList<Product>();
    public static List<Order> orders=new ArrayList<Order>();

    public static void menu(){
        System.out.println("----Danh sach chuc nang----");
        System.out.println("1.Them moi san pham");
        System.out.println("2.Hien thi san pham");
        System.out.println("3.Sua  san pham");
        System.out.println("4.Xoa san pham");
        System.out.println("5.Mua san pham");
        System.out.println("6.Hien thi danh sach don hang");
        System.out.println("7.Thoat");

    }
    public static void main(String[] args) {
        int function = 0;

        do {
            Product_service productService= new Product_service();
            Order_service orderService = new Order_service();
            Scanner input = new Scanner(System.in);
            menu();
            System.out.println("Hay chon chuc nang :");
            try{
                function=input.nextInt();
                switch (function){
                    case 1:
                        productService.ThemSanPham();
                        break;
                    case 2:
                        productService.HienThiSanPham();
                        break;
                    case 3:
                        productService.SuaSanPham();
                        break;
                    case 4:
                        productService.XoaSanPham();
                        break;
                    case 5:
                        orderService.Order();
                        break;
                    case 6:
                        orderService.show();
                        break;
                }
            }catch (InputMismatchException EM){
                System.out.println("Ban da nhap sai gia tri. Vui long nhap dung.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (function!=7);//lap den khi dieu kien sai - thoat
        System.out.println("Cam on da su dung phan mem");
    }



}
