package com.astar.device;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
public class FileWriter {
	public static void save(String fileName, List<String> data)
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
			for (String line : data) {
				writer.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			return;
		}
		writer.close();
	}
}
