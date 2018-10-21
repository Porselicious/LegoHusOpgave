/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author porse
 */
public class Order {
    private int orderID;
    private boolean status;
    private int height;
    private int length;
    private int width;
    private String orderDate;
    private User user_email;

    public Order(int orderID, boolean status, int height, int length, int width, String orderDate, User user_email) {
        this.orderID = orderID;
        this.status = status;
        this.height = height;
        this.length = length;
        this.width = width;
        this.orderDate = orderDate;
        this.user_email = user_email;
    }

    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user_email;
    }

    public void setUser(User user_email) {
        this.user_email = user_email;
    }
    
}
