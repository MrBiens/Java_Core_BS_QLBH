package src.main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private String customerName;
    private String numberPhone;
    private String email;

    private List<Order_detail> orderDetailList = new ArrayList<Order_detail>();

    //khoi tao khong tham so -- Order order = new Order();
    public Order() {
    }

    public Order(Integer id, String customerName, String numberPhone, String email) {
        this.id = id;
        this.customerName = customerName;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public List<Order_detail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<Order_detail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
