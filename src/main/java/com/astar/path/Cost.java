package com.astar.path;
import java.util.Arrays;
class Cost {
	private static final int[] impediments;
	static {
		impediments = new int[256];
		Arrays.fill(impediments, -1);
		impediments['.' & 0xFF] = 1;
		impediments['X' & 0xFF] = 1;
		impediments['*' & 0xFF] = 2;
		impediments['^' & 0xFF] = 3;
	}
	public static int getCost(char c)
	{
		return impediments[c & 0xFF];
	}
}
