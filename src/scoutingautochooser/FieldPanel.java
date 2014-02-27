/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutingautochooser;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Jacob
 */
public class FieldPanel extends JPanel {

    private final double mult = 1.5;

    private Point2D start;
    
    private ArrayList<Point2D> points;

    private int scale(int num) {
        return (int) Math.round(num * mult);
    }

    public FieldPanel() {
        points = new ArrayList<>();
    }
    
    public void reset() {
        points = new ArrayList<>();
        start = null;
        this.repaint();
    }

    public void setStart(Point2D start) {
        this.start = start;
        if(points.size()>0)
        {
            points.set(0,start);
        } else {
            points.add(0, start);
        }
        this.repaint();
    }
    
    public void addPoint(Point2D point) {
        points.add(point);
        if(points.size()==1){
            this.start=point;
        }
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(scale(240), scale(240));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Graphics2D.class.isAssignableFrom(g.getClass())) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.DARK_GRAY);
            g2.fillRect(scale(0), scale(0), scale(240), scale(240));

            g2.setStroke(new BasicStroke((float) scale(4)));

            g2.setColor(Color.red);
            g2.drawLine(scale(80), scale(0), scale(0), scale(80));
            g2.setColor(Color.blue);
            g2.drawLine(scale(160), scale(240), scale(240), scale(160));

            g2.setColor(Color.black);
            int[] xPosC = {scale(63), scale(120), scale(177), scale(120)};
            int[] yPosC = {scale(120), scale(63), scale(120), scale(177)};
            g2.fillPolygon(xPosC, yPosC, 4);

            g2.setColor(Color.red);
            g2.drawLine(scale(0), scale(238), scale(238), scale(0));
            g2.setColor(Color.blue);
            g2.drawLine(scale(3), scale(240), scale(240), scale(3));

            g2.setColor(Color.red);
            int[] xPosR = {scale(49), scale(106), scale(116), scale(59)};
            int[] yPosR = {scale(106), scale(49), scale(59), scale(116)};
            g2.fillPolygon(xPosR, yPosR, 4);

            g2.setColor(Color.blue);
            int[] xPosB = {scale(134), scale(191), scale(181), scale(124)};
            int[] yPosB = {scale(191), scale(134), scale(124), scale(181)};
            g2.fillPolygon(xPosB, yPosB, 4);

            g2.setColor(Color.white);
            int[] xPosC1 = {scale(0), scale(40), scale(0)};
            int[] yPosC1 = {scale(240), scale(240), scale(200)};
            g2.drawPolygon(xPosC1, yPosC1, 3);
            int[] xPosC2 = {scale(240), scale(240), scale(200)};
            int[] yPosC2 = {scale(0), scale(40), scale(0)};
            g2.drawPolygon(xPosC2, yPosC2, 3);
            g2.setStroke(new BasicStroke(scale(2)));
            g2.drawLine(scale(160), scale(0), scale(240), scale(80));
            g2.drawLine(scale(0), scale(160), scale(80), scale(240));

            if (start != null) {
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(1));
                g2.drawLine((int) start.getX() - scale(3), (int) start.getY() - scale(3), (int) start.getX() + scale(3), (int) start.getY() + scale(3));
                g2.drawLine((int) start.getX() - scale(3), (int) start.getY() + scale(3), (int) start.getX() + scale(3), (int) start.getY() - scale(3));
            }
            
            if(points != null && points.size()>0){
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(1));
                GeneralPath path = new GeneralPath();
                path.moveTo(points.get(0).getX(), points.get(0).getY());
                for(int i = 1; i<points.size(); i++)
                {
                    path.lineTo(points.get(i).getX(), points.get(i).getY());
                }
                g2.draw(path);
            }

        }
    }
}
