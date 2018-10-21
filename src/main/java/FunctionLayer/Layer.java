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
public class Layer {

    private Side length;
    private Side width;

    @Override
    public String toString() {
        return "Layer{" + "length side=" + length + ", width side=" + width + '}';
    }

    public Side getLength() {
        return length;
    }

    public void setLength(Side length) {
        this.length = length;
    }

    public Side getWidth() {
        return width;
    }

    public void setWidth(Side width) {
        this.width = width;
    }
}
