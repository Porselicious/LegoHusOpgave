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
public class CalcBillOfMat {
        public static Legohouse createPartList(Legohouse house) {
        for (int i = 0; i < house.getHeight(); i++) {
            boolean evenLayer = (i % 2 == 0);
            house.addLayer(createLayer(house.getLength(), house.getWidth(), evenLayer));
        }
        return house;
    }

    private static Layer createLayer(int length, int width, boolean even) {
        Layer layer = new Layer();
        Side side1And3;
        Side side2And4;
        if (even) {
            side1And3 = createSide(length);
            side2And4 = createSide(width - 4);
        } else {
            side1And3 = createSide2(length - 4);
            side2And4 = createSide2(width); 
        }
        layer.setLength(side1And3);
        layer.setWidth(side2And4);
        return layer;
    }

    private static Side createSide(int dots) {
        int fourTwo = dots / 4; // number of 4x2 bricks
        int twoTwo = (dots % 4) / 2;
        int oneTwo = ((dots % 4) - twoTwo * 2);
        Side side = new Side();
        side.setBricks("fourTwo", fourTwo);
        side.setBricks("twoTwo", twoTwo);
        side.setBricks("oneTwo", oneTwo);
        return side;
    }
    
    private static Side createSide2(int dots) {
        int fourTwo = dots / 4; // number of 4x2 bricks
        int twoTwo = (dots % 4) / 2;
        int oneTwo = ((dots % 4) - twoTwo * 2);
        Side side = new Side();
        side.setBricks("fourTwo", fourTwo);
        side.setBricks("twoTwo", twoTwo);
        side.setBricks("oneTwo", oneTwo);
        return side;
    }

}
