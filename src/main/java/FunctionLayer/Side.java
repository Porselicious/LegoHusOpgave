/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.HashMap;

/**
 *
 * @author porse
 */
public class Side {
   
    private HashMap<String, Integer> bricks;

    public Side() {
        bricks = new HashMap();
    }

    public void setBricks(String brickSize, Integer amount) {
        bricks.put(brickSize, amount);
    }

    public HashMap<String, Integer> getBricks() {
        return bricks;
    }

    @Override
    public String toString() {
        return "" + bricks;
    }
}
