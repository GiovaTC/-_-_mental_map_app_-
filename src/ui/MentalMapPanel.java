package ui;

import model.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MentalMapPanel extends JPanel {

    private Node central;
    private List<Node> nodes;

    public MentalMapPanel() {
        setBackground(Color.WHITE);
        nodes = new ArrayList<>();

        central = new Node("JAVA\nMAPA MENTAL", 400, 250, new Color(52, 152, 219));

        nodes.add(new Node("Swing", 150, 120, new Color(46, 204, 113)));
        nodes.add(new Node("JDBC", 650, 120, new Color(241, 196, 15)));
        nodes.add(new Node("POO", 150, 380, new Color(231, 76, 60)));
        nodes.add(new Node("Arquitectura", 650, 380, new Color(155, 89, 182)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // conexiones
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.GRAY);

        for (Node n : nodes) {
            g2.drawLine(central.x, central.y, n.x, n.y);
        }

        // nodo central
        drawNode(g2, central, 160, 80);

        // nodos secundarios .
        for (Node n : nodes) {
            drawNode(g2, n, 140, 60);
        }
    }

    private void drawNode(Graphics2D g2, Node node, int w, int h) {
        g2.setColor(node.color);
        g2.fillRoundRect(node.x - w / 2, node.y - h / 2, w, h, 30, 30);

        g2.setColor(Color.BLACK);
        g2.fillRoundRect(node.x - w / 2, node.y - h / 2, w, h, 30, 30);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 14));

        drawCenteredText(g2, node.text, node.x, node.y);
    }

    private void drawCenteredText(Graphics2D g2, String text, int x, int y) {
        FontMetrics fm = g2.getFontMetrics();
        String[] lines = text.split("\n");
        int lineHeight = fm.getHeight();
        int totalHeight = lineHeight * lines.length;
        int startY = y - totalHeight / 2 + fm.getAscent();

        for (String line : lines) {
            int textWidth = fm.stringWidth(line);
            g2.drawString(line, x - textWidth / 2, startY);
            startY += lineHeight;
        }
    }
}
