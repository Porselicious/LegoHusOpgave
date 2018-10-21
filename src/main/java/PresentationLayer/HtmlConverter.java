/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Legohouse;
import FunctionLayer.Order;
import java.util.ArrayList;

/**
 *
 * @author porse
 */
class HtmlConverter {

    public static String legohouseToHtml(Legohouse house) {
        String cartTable = "<table id=\"house\">"
                + "<tr><th>Legohouse</th><th>Length = " + house.getLength() + "</th><th>Width = " + house.getWidth() + "</th><th>Height = " + house.getHeight() + "</th></tr>"
                + "<tr><th>Layer</th><th>Side 1&3 (Length)</th><th>Side 2&4 (Width)</th></tr>";
        for (int i = 0; i < house.getLayers().size(); i++) {
            cartTable += "<tr><td>" + (i + 1) + "</td>"
                    + "<td>" + house.getLayers().get(i).getLength().toString() + "</td>"
                    + "<td>" + house.getLayers().get(i).getWidth().toString() + "</td></tr>";
        }
        return cartTable;
    }

    public static String generateOrdersHTML(ArrayList<Order> orders) {
        String cartTable = "<table id=\"orders\">"
                + "<tr><th>Order ID </th><th>Length </th><th>Width </th><th>Height </th><th>User </th><th>Shipped\t</th></tr>";
        for (int i = 0; i < orders.size(); i++) {
            cartTable += "<tr><td>" + orders.get(i).getOrderID() + " </td>"
                    + "<td>" + orders.get(i).getLength() + " </td>"
                    + "<td>" + orders.get(i).getWidth() + " </td>"
                    + "<td>" + orders.get(i).getHeight() + " </td>"
                    + "<td>" + orders.get(i).getUser().toString() + " </td>"
                    + "<td>" + orders.get(i).getStatus() + " </td></tr>";
        }
        return cartTable;
    }

}
