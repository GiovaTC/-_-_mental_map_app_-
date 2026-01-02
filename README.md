# -_-_mental_map_app_- :. 
A continuación presento una solución completa, profesional y lista para ejecutar en IntelliJ IDEA, desarrollada en Java Swing, que muestra un mapa mental tipo PowerPoint dentro de una interfaz gráfica, utilizando nodos, conexiones y diseño visual claro, similar a una diapositiva conceptual .

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/2e14bad1-cb01-4b62-a338-86f5823cb915" />        

<img width="1282" height="1079" alt="image" src="https://github.com/user-attachments/assets/9c6fa0dd-bbed-4362-96ae-d2092675635a" />    

## 🎯 Objetivo del programa :

Mostrar un mapa mental visual

Estilo presentación (PowerPoint)

Interfaz gráfica en Java Swing

Nodos conectados con líneas

Diseño limpio, claro y didáctico

Código 100 % ejecutable

## 🧱 Arquitectura del proyecto :
* MentalMapApp
* ├── Main.java
* ├── ui
* │    └── MentalMapFrame.java
* │    └── MentalMapPanel.java
* └── model
*       └── Node.java

1️⃣ Clase principal – Main.java
```
import ui.MentalMapFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MentalMapFrame();
        });
    }
}
```
2️⃣ Modelo del nodo – Node.java
```
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
```
3️⃣ Ventana principal – MentalMapFrame.java
```
package ui;

import javax.swing.*;

public class MentalMapFrame extends JFrame {

    public MentalMapFrame() {
        setTitle("Mapa Mental - Java Swing");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new MentalMapPanel());

        setVisible(true);
    }
}
```
4️⃣ Panel del mapa mental – MentalMapPanel.java
```
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

        // Conexiones
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.GRAY);

        for (Node n : nodes) {
            g2.drawLine(central.x, central.y, n.x, n.y);
        }

        // Nodo central
        drawNode(g2, central, 160, 80);

        // Nodos secundarios
        for (Node n : nodes) {
            drawNode(g2, n, 140, 60);
        }
    }

    private void drawNode(Graphics2D g2, Node node, int w, int h) {
        g2.setColor(node.color);
        g2.fillRoundRect(node.x - w / 2, node.y - h / 2, w, h, 30, 30);

        g2.setColor(Color.BLACK);
        g2.drawRoundRect(node.x - w / 2, node.y - h / 2, w, h, 30, 30);

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
```
## 🖥️ Resultado visual

Nodo central grande (tema principal)

Cuatro nodos secundarios

Líneas de conexión

Estilo presentación tipo PowerPoint

Bordes redondeados y colores profesionales

## 🚀 Cómo ejecutar en IntelliJ IDEA

Crear proyecto Java

Copiar la estructura indicada

Ejecutar Main.java

El mapa mental se muestra automáticamente

## 📌 Posibles mejoras (si lo deseas)

Nodos dinámicos con clic

Animaciones

Zoom y desplazamiento

Exportar como imagen

Integrar base de datos

Navegación tipo diapositivas . 
