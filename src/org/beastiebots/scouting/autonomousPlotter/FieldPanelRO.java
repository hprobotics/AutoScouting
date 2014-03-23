/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.autonomousPlotter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.beastiebots.scouting.tournament.AutonomousRoutine;

/**
 *
 * @author Jacob Burroughs
 */
public class FieldPanelRO extends JPanel {

    private FieldPanelData data;

    private double mult = 1.5;

    private Polygon[] goals;
    
    public void setAutonomousRoutine(AutonomousRoutine auto){
        data.setAuto(auto);
        this.repaint();
    }
    
    public AutonomousRoutine getAutonomousRoutine(){
        return data.getAuto();
    }

    public FieldPanelRO() {
        data = new FieldPanelData();

        goals = new Polygon[8];
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[0] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[1] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[2] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[3] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[4] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[5] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[6] = new Polygon(goalPtsX, goalPtsY, 4);
        }
        {
            int goalPtsX[] = {5, 5, 5, 5};
            int goalPtsY[] = {5, 5, 5, 5};
            goals[7] = new Polygon(goalPtsX, goalPtsY, 4);
        }
    }

    public double getMult() {
        return mult;
    }

    public void setMult(double mult) {
        this.mult = mult;
    }

    private int scale(double num) {
        return (int) Math.round(num * mult);
    }

    private Polygon scalePolygon(Polygon original) {
        Polygon scaled = new Polygon();
        double[] coords = new double[6];

        for (PathIterator pi = original.getPathIterator(null); !pi.isDone(); pi.next()) {
            // The type will be SEG_LINETO, SEG_MOVETO, or SEG_CLOSE
            // Because the Area is composed of straight lines
            pi.currentSegment(coords);
            scaled.addPoint(scale(coords[0]), scale(coords[1]));
        }

        return scaled;
    }

    private double unscale(double num) {
        return Math.round(num / mult);
    }

    public void reset() {
        data.reset();
        this.repaint();
    }

    public void setStart(Point2D start) {
        Point2D startUnscaled = new Point2D.Double(unscale(start.getX()), unscale(start.getY()));
        data.setStart(startUnscaled);
        this.repaint();
    }

    public void addPoint(Point2D point) {
        Point2D pointUnscaled = new Point2D.Double(unscale(point.getX()), unscale(point.getY()));
        data.addPoint(pointUnscaled);
        this.repaint();
    }

    public void updateEndPoint(Point2D point) {
        Point2D pointUnscaled = new Point2D.Double(unscale(point.getX()), unscale(point.getY()));
        data.replEndPoint(pointUnscaled);
        this.repaint();
    }

    public void clearEndPoint() {
        if (data.getPoints().size() - 2 >= 0) {
            data.replEndPoint((Point2D) data.getPoints().get(data.getPoints().size() - 2));
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

            Point2D start = data.getStart();

            for (Polygon goal : goals) {
                g2.setColor(Color.orange);
                g2.setStroke(new BasicStroke(3));
                Polygon scaledGoal = new Polygon();
                g2.draw(goal);
            }

            if (start != null) {
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(1));
                g2.drawLine(scale((int) start.getX() - 3), scale((int) start.getY() - 3), scale((int) start.getX() + 3), scale((int) start.getY() + 3));
                g2.drawLine(scale((int) start.getX() - 3), scale((int) start.getY() + 3), scale((int) start.getX() + 3), scale((int) start.getY() - 3));
            }

            List<Point2D> points = data.getPoints();

            if (points != null && points.size() > 0) {
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(1));
                GeneralPath path = new GeneralPath();
                path.moveTo(scale(points.get(0).getX()), scale(points.get(0).getY()));
                for (int i = 1; i < points.size(); i++) {
                    path.lineTo(scale(points.get(i).getX()), scale(points.get(i).getY()));
                }
                g2.draw(path);
            }

        }
    }

    public JsonObject getJsonData() {
        return Json.createObjectBuilder().build();//data.toJSON();
    }

    public void readJson(String str) {
        //data.readJson(str);
        this.repaint();
    }
}
