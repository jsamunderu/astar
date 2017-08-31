package com.astar;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.astar.path.PathFinder;
import com.astar.device.FileLoader;
import com.astar.exception.Unsolvable;

public class AppTest extends TestCase
{
	public AppTest( String testName )
	{
		super( testName );
	}

	public static Test suite()
	{
		return new TestSuite( AppTest.class );
	}

	public void testApp()
	{
		List<String> sample1 = new ArrayList(Arrays.asList("@*^^^", "~~*~.", "**...", "^..*~", "~~*~X"));
		PathFinder path1 = new PathFinder(sample1);

		try {
			while (path1.advance() != false) {
			}
			assertTrue( false ); // this sample has errors
		} catch (Unsolvable e) {
			assertTrue( true );
		}



		List<String> sample2 = new ArrayList(Arrays.asList("@*^^^", "~~*~.", "**...", "^..*^", "~~**X"));
		PathFinder path2 = new PathFinder(sample2);

		try {
			while (path2.advance() != false) {
			}
			assertTrue( true );
		} catch (Unsolvable e) {
			assertTrue( false ); // this sample is correct no exception should be thrown
		}
	}
}
