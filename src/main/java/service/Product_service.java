package src.main.java.service;

import src.main.java.Main;
import src.main.java.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product_service implements Service {

    @Override
    public void ThemSanPham() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ban chon chuc nang them san pham");
        System.out.println("Hay nhap thong tin!");
        boolean check=false;
        try{
            System.out.println("Id:");
            int id=input.nextInt();
            input.nextLine();
            for(Product p : Main.products){
                if(p.getId().equals(id)){
                    System.out.println("Ma san pham da ton tai.Vui long them ma san pham khac!");
                    check=true;
                    break;
                }
            }
            //check neu co bug thi se la true - va phu true la false => khong duoc thuc hien vi da bi phu lai => FALSE
            // neu check la false va khong tim thay gia tri ton tai. Thi if se ! false = true => se duoc thuc hien
            if(!check){
                System.out.println("Name:");
                String name=input.nextLine();

                System.out.println("Quantity:");
                int quantity=input.nextInt();

                System.out.println("Price:");
                float price=input.nextFloat();

                input.nextLine();

                System.out.println("Description:");
                String description=input.nextLine();

                Product product = new Product(id,name,quantity,price,description);
                Main.products.add(product);

            }

        }catch (InputMismatchException EM){
            System.out.println("Ban da nhap sai gia tri.Vui long nhap dung!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void HienThiSanPham() {
        System.out.println("Hien thi san pham.");
        //String header = String.format("%s%15s%30s%15s%15s","Mã","Tên","Số lượng","Giá","Mô tả");
        //System.out.println(header);
        if(Main.products.isEmpty()){
            System.out.println("Khong co san pham nao.Hay them san pham de xem");
        }else{
            for (Product p : Main.products) {
                System.out.println(p);
            }
        }

    }

    @Override
    public void SuaSanPham() {
        try {
                Scanner input = new Scanner(System.in);
                System.out.println("Nhap ma san pham can sua:");
                Integer id=input.nextInt();
                Product product = null;

                for (Product p : Main.products){
                    if(p.getId().equals(id)){
                        product=p;
                        break;
                    }
                }
                //if find sp then product not null  != -> else
                if(product==null){
                    System.out.println("Khong tim thay san pham.Vui long nhap lai ma !");
                }else{
                    System.out.println("Hay nhap thong tin moi ");
                    input.nextLine();
                    System.out.println("Name:");
                    String name=input.nextLine();

                    System.out.println("Quantity:");
                    int quantity=input.nextInt();

                    System.out.println("Price:");
                    float price=input.nextFloat();

                    input.nextLine();

                    System.out.println("Description:");
                    String description=input.nextLine();

                    product.setName(name);
                    product.setQuantity(quantity);
                    product.setPrice(price);
                    product.setDescription(description);


                    System.out.println("San pham sau khi sua:"+product);
            }
        }catch (InputMismatchException EX){
            System.out.println("Ban da nhap sai gia tri.Vui long nhap dung!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void XoaSanPham() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap ma san pham can xoa:");
            Integer id=input.nextInt();
            boolean check=false;

            for(int i = 0; i< Main.products.size(); i++){
                //lay phan tu i trong mang products va so sanh bang voi id
                if(Main.products.get(i).getId().equals(id)){
                    check = true;
                    //chi can toi 8 , boi vi dieu khien j+1 = pt 9
                    for(int j = i; j< Main.products.size()-1; j++){
                        //lay phan tu phia sau, day len phia truoc
                        Main.products.set(j, Main.products.get(j+1));
                    }
                    Main.products.removeLast(); // or (main.products.size()-1);
                    System.out.println("San pham da duoc xoa thanh cong!");
                    break;
                }
            }
            // ! phu check - not
            if(!check){
                System.out.println("Khong tim thay san pham voi ma nay.Vui long nhap lai");
            }

        }catch (InputMismatchException EX){
            System.out.println("Ban da nhap sai gia tri.Vui long nhap dung!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Delete with ForEach
        // Tìm sản phẩm dựa trên mã
        //        for (Product p : main.products) {
        //            if (p.getId().equals(id)) {
        //                productToRemove = p;
        //                break;
        //            }
        //        }
        //
        //        // Kiểm tra nếu tìm thấy sản phẩm
        //        if (productToRemove == null) {
        //            System.out.println("Khong tim thay san pham voi ma nay!");
        //        } else {
        //            // Xóa sản phẩm khỏi danh sách
        //            main.products.remove(productToRemove);
        //            System.out.println("San pham da duoc xoa thanh cong!");
        //        }
    }



}
