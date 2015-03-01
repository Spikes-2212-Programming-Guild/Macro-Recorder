/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ThinkRedstone
 */
public class Macro implements Serializable {

    Map<Long, List[]> macro;
    private long lastWriteTime;

    public Macro(ArrayList buttonArray, ArrayList axisArray) {
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
