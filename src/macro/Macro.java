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

	ArrayList<Pair<Long, List[]>> macro;
	private long lastWriteTime;

	/**
	 *
	 * @param buttonArray
	 *            - 12 long array of booleans
	 * @param axisArray
	 *            - 3 long array of doubles, ranging from -1 to 1 in this order:
	 *            X axis, Y axis, Twist
	 */
	public Macro(ArrayList buttonArray, ArrayList axisArray) {
		macro = new ArrayList<>();
		macro.add(new Pair<>(0l, new List[] { buttonArray, axisArray }));
		lastWriteTime = System.currentTimeMillis();
	}

	public void addData(ArrayList buttonArray, ArrayList axisArray) {
		macro.add(new Pair<Long, List[]>(System.currentTimeMillis()
				- lastWriteTime, new List[] { buttonArray, axisArray }));
		lastWriteTime = System.currentTimeMillis();
	}

	public List<Pair<Long, List[]>> getData() {
		return (ArrayList) macro.clone();
	}

}
