package com.astar;
import java.util.ArrayList;
import java.util.List;
import com.astar.device.FileLoader;
import com.astar.device.FileWriter;
import com.astar.path.PathFinder;
import com.astar.path.Coordinate;
import com.astar.exception.Unsolvable;

public class App {
	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.out.println("Usage: java -jar astar-1.0-SNAPSHOT.jar <maze_file> <out_put_file>");
			return;
		}
		List<String> data = new ArrayList<String>();
		FileLoader.load(args[0], data);

		PathFinder path = new PathFinder(data);
		try {
			while (path.advance() != false) {
			}
		} catch (Unsolvable e) {
			System.out.println("Error: " + e.getMessage());
			List<String> map = path.generateMap();
			for (String line : map) {
				System.out.println(line);
			}
			return;
		}

		List<String> map = path.generateMap();
		FileWriter.save(args[1], map);
	}
}
