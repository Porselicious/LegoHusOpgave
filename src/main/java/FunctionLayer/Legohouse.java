/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author porse
 */
public class Legohouse {

    private int length;
    private int width;
    private int height;
    private ArrayList<Layer> layers;

    public Legohouse(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        layers = new ArrayList();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public HashMap<String, Integer> getTotalBricks() {
        HashMap<String, Integer> totalBricks = new HashMap();
        totalBricks.put("fourTwo", 0);
        totalBricks.put("twoTwo", 0);
        totalBricks.put("oneTwo", 0);

        for (Layer l : layers) {
            int fourXtwo = totalBricks.get("fourTwo");
            totalBricks.put("fourTwo", l.getLength().getBricks().get("fourTwo") + fourXtwo);
            int twoXtwo = totalBricks.get("twoTwo");
            totalBricks.put("twoTwo", l.getLength().getBricks().get("twoTwo") + twoXtwo);
            int oneXtwo = totalBricks.get("oneTwo");
            totalBricks.put("oneTwo", l.getLength().getBricks().get("oneTwo") + oneXtwo);
        }

        return totalBricks;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    @Override
    public String toString() {
        return "Legohouse{" + "length=" + length + ", width=" + width + ", height=" + height + ", layers=" + layers + '}';
    }
}
