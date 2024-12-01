package assignments.assignment_5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {
    List<BouncingBox> boxes = new ArrayList<>();
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        BouncingBox bouncingBox = new BouncingBox(200, 50, Color.RED);
        bouncingBox.setMovementVector(0, 5);
        boxes.add(bouncingBox);
        bouncingBox.setMovementVector(30, 25);
        boxes.add(bouncingBox);
        bouncingBox.setMovementVector(0, 50);
        boxes.add(bouncingBox);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        surface.drawOval(20, 100, 250, 100);
        surface.drawRect(20, 175, 200, 100);
        surface.drawRoundRect(95, 50, 200, 100, 15, 15);
        boxes.forEach(box -> box.draw(surface));
    }
} 