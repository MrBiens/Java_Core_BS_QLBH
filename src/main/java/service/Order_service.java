package src.main.java.service;

import src.main.java.Main;
import src.main.java.model.Order;
import src.main.java.model.Order_detail;
import src.main.java.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Order_service {
    public void Order(){
        Scanner input=new Scanner(System.in);
        System.out.println("Mua san pham:");
        try {
            System.out.println("Id:");
            int id = input.nextInt();

            input.nextLine();

            System.out.println("CustomerName:");
            String customerName = input.nextLine();

            System.out.println("Number phone:");
            String numberPhone = input.nextLine();

            System.out.println("Email:");
            String email = input.nextLine();

            Order order = new Order(id, customerName, numberPhone, email);

            boolean continueAdding;
            boolean check = false;
                do {
                    System.out.println("Product Id");
                    int productID = input.nextInt();
                    for (Product p : Main.products) {
                        if (p.getId().equals(productID)) {
                           check=true;
                           break;
                        }
                    }
                    //check=true
                    if(check){
                        System.out.println("Product quantity:");
                        int quantity=input.nextInt();
                        System.out.println("Product price:");
                        float price=input.nextFloat();
                        input.nextLine();

                        Order_detail orderDetail= new Order_detail(1,order.getId(),productID,price,quantity);
                        // Thêm chi tiết đơn hàng mới vào danh sách chi tiết đơn hàng của đối tượng order
                        order.getOrderDetailList().add(orderDetail);

                        System.out.println("Ban co muon tiep tuc mua hang? (0: Yes, 1: No)");
                        int userChoice = input.nextInt();
                        continueAdding = (userChoice == 0); // Nếu người dùng chọn 0, tiếp tục thêm sản phẩm
                    }else{
                        System.out.println("Ma san pham khong ton tai.Vui long nhap lai!");
                        continueAdding=true;
                    }
                    //lap lai neu contineAdding=true.Vi vong lap while lap den khi dieu kien sai
                }while (continueAdding);
                Main.orders.add(order);
            }catch(InputMismatchException EX){
                System.out.println("Ban da nhap sai gia tri.Vui long nhap lai!");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
    public void show(){
        System.out.println("Danh sach dat hang");
        if(Main.orders.isEmpty()){
            System.out.println("Khong co don hang nao.Hay them don hang de xem.");
        }else{
            // Duyet qua tat ca cac don hang trong danh sach orders
            for(Order order :Main.orders){
                System.out.println("Don hang ID:"+ order.getId());
                System.out.println("Ten khach hang:"+order.getCustomerName());
                //order.getOrderDetailList().add(orderDetail);
                List<Order_detail> orderDetailList = order.getOrderDetailList();
                if(orderDetailList.isEmpty()){
                    System.out.println("Khong co chi tiet don hang.");
                }else  {
                    for (Order_detail orderDetail: orderDetailList){
                        System.out.println(orderDetail);
                    }
                }
            }

        }
    }


}
