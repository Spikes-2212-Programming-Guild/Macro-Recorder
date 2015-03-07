/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ThinkRedstone
 */
public class Macro implements Serializable {

    LinkedHashMap <Long, List[]> macro;
    private long lastWriteTime;

    /**
     *
     * @param buttonArray - 12 long array of booleans
     * @param axisArray - 3 long array of doubles, ranging from -1 to 1 in this order: X axis, Y axis, Twist
     */
    public Macro(ArrayList buttonArray, ArrayList axisArray) {
        macro = new LinkedHashMap<>();
        macro.put(Long.valueOf(0), new List[]{buttonArray, axisArray});
        lastWriteTime = System.currentTimeMillis();
    }

    public void addData(ArrayList buttonArray, ArrayList axisArray) {
        macro.put(System.currentTimeMillis() - lastWriteTime, new List[]{buttonArray, axisArray});
        lastWriteTime = System.currentTimeMillis();
    }
    
    public Map<Long, List[]> getData(){
        return macro;
    }

}
