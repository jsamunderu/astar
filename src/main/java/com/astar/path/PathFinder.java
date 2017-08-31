package com.astar.path;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import com.astar.exception.Unsolvable;
public class PathFinder {
	private List<String> originalMap = null;
	private List<StringBuilder> finalMap = null;
	private Coordinate position = null;
	private Coordinate destination = null;
	private Stack<Coordinate> backTrack = null;
	public PathFinder(List<String> originalMap)
	{
		this.originalMap = originalMap;
		position = new Coordinate();
		if (this.originalMap.size() > 0) {
			destination = new Coordinate(this.originalMap.size() - 1, this.originalMap.get(0).length() - 1);
		} else  {
			destination = new Coordinate();
		}
		finalMap = new ArrayList<StringBuilder>();
		for (String line : originalMap) {
			finalMap.add(new StringBuilder(line));
		}
		backTrack = new Stack<Coordinate>();
	}

	public boolean advance() throws Unsolvable
	{
		//if (originalMap.get(position.getY()).charAt(position.getX()) == 'X') {
		if (position.equals(destination)) {
			return false;
		}
		if (move() == false) {
			if (backTrack.empty()) {
				throw new Unsolvable();
			}
			//backtrack and restore
			Coordinate oldPosition = position;
			position = backTrack.pop();
			advance();
			finalMap.get(oldPosition.getY()).setCharAt(oldPosition.getX(), originalMap.get(oldPosition.getY()).charAt(oldPosition.getX()));
		} else {
			finalMap.get(position.getY()).setCharAt(position.getX(), '#');
			backTrack.push(new Coordinate(position.getX(), position.getY()));
		}

		return true;
	}

	public Coordinate getCurrentPosition()
	{
		return position;
	}

	public Coordinate getDestinationPosition()
	{
		return destination;
	}

	public List<String> generateMap()
	{
		List<String> map = new ArrayList<String>();
		for (StringBuilder line : finalMap) {
			map.add(line.toString());
		}
		return map;
	}

	private int getDistToFinalDest()
	{
		return calculateDistance(position.getX(), position.getY());
	}

	private int calculateDistance(int x, int y)
	{
		return Math.abs(x - destination.getX()) + Math.abs(y - destination.getY());
	}

	private boolean move()
	{
		int leastCost = 0, north = 0, east = 0, south = 0, west = 0;
		if ((position.getY() + 1) < originalMap.size()) {
			int cost = Cost.getCost(finalMap.get(position.getY() + 1).charAt(position.getX()));
			if (cost != -1) {
				south = 1;
				leastCost = cost + calculateDistance(position.getX(), position.getY() + 1);
			}
		}
		if ((position.getX() + 1) < originalMap.get(position.getY()).length()) {
			int cost = Cost.getCost(finalMap.get(position.getY()).charAt(position.getX() + 1));
			if (cost != -1) {
				cost += calculateDistance(position.getX() + 1, position.getY());
				if (cost < leastCost || leastCost == 0) {
					south = 0;
					east = 1;
					leastCost = cost;
				}
			}
		}
		if ((position.getY() - 1) >= 0) {
			int cost = Cost.getCost(finalMap.get(position.getY() - 1).charAt(position.getX()));
			if (cost != -1) {
				cost += calculateDistance(position.getX(), position.getY() - 1);
				if (cost < leastCost || leastCost == 0) {
					east = 0;
					south = 0;
					north = -1;
					leastCost = cost;
				}
			}
		}
		if ((position.getX() - 1) >= 0) {
			int cost = Cost.getCost(finalMap.get(position.getY()).charAt(position.getX() - 1));
			if (cost != -1) {
				cost += calculateDistance(position.getX() - 1, position.getY());
				if (cost < leastCost || leastCost == 0) {
					east = 0;
					south = 0;
					north = 0;
					west = -1;
					leastCost = cost;
				}
			}
		}
		position.setX(position.getX() + east + west);
		position.setY(position.getY() + north + south);
		return (east + west + north + south) != 0;
	}
}
