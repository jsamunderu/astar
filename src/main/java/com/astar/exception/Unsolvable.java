package com.astar.exception;
public class Unsolvable extends Exception {
    public Unsolvable() {
        super("The path to the destination could not be found!");
    }
}
