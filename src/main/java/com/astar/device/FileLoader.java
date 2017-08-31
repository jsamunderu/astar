package com.astar.device;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
public class FileLoader {
	public static void load(String fileName, List<String> data)
	{
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			BufferedReader bufReader = new BufferedReader(reader);
        
			String line = null;
			while ((line = bufReader.readLine()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace(System.out);
				}
			}
		}
	}
}
