package model;

import java.awt.*;

public class Node {
    public String text;
    public int x, y;
    public Color color;

    public Node(String text, int x, int y, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
