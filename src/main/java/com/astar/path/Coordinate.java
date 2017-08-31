package com.astar.path;
public class Coordinate {
	private int x;
	private int y;
	public Coordinate()
	{
		this.x = 0;
		this.y = 0;
	}
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		if (this.x == ((Coordinate)o).getX() && this.y == ((Coordinate)o).getY()) {
			return true;
		}
		return false;
	}
}
