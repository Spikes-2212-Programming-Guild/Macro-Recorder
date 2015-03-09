/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinkRedstone
 */
public class Macro implements Serializable {

    ArrayList<List[]> macroDriving;
    ArrayList<List[]> macroNavigating;
    private long lastWriteTime;

    /**
     *
     * @param buttonArray - 12 long array of booleans
     * @param axisArray - 3 long array of doubles, ranging from -1 to 1 in this order: X axis, Y axis, Twist
     * @param buttonArrayNavig - buttonArray for the Navigator
     * @param axisArrayNavig - axisArray for the Navigator
     */
    public Macro(ArrayList buttonArray, ArrayList axisArray, ArrayList buttonArrayNavig, ArrayList axisArrayNavig) {
        macroDriving = new ArrayList<>();
        macroDriving.add(new List[]{buttonArray, axisArray});
        lastWriteTime = System.currentTimeMillis();

        macroNavigating = new ArrayList<>();
        macroNavigating.add(new List[]{buttonArrayNavig, axisArrayNavig});
        lastWriteTime = System.currentTimeMillis();
    }

    public void addDataDriving(ArrayList buttonArray, ArrayList axisArray) {
        macroDriving.add(new List[]{buttonArray, axisArray});
        lastWriteTime = System.currentTimeMillis();
    }

    public void addDataNavigating(ArrayList buttonArrayNav, ArrayList axisArrayNav) {
        macroNavigating.add(new List[]{buttonArrayNav, axisArrayNav});
        lastWriteTime = System.currentTimeMillis();
    }

    public List<List[]> getDataDriving() {
        return (ArrayList) macroDriving.clone();
    }

    public List<List[]> getDataNavigating() {
        return (ArrayList) macroNavigating.clone();
    }

}
