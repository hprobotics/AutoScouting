/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import org.beastiebots.utilities.Timestamped;

/**
 *
 * @author Jacob Burroughs
 */
public class AutonomousRoutine extends Timestamped {

    private ArrayList<Point2D> points;
    private Point2D start;
    private int goal;

    public AutonomousRoutine() {
        super(0);
        points = new ArrayList<Point2D>();
        start = null;
    }

    public AutonomousRoutine(JsonObject obj) {
        this();
        this.readJson(obj);
    }

    public List<Point2D> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public void setFirstPoint(Point2D point) {
        if (points.size() > 0) {
            points.set(0, point);
        } else {
            points.add(0, point);
        }
        updateDate();
    }

    public void addPoint(Point2D points) {
        this.points.add(points);
        updateDate();
    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        this.start = start;
        updateDate();
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
        updateDate();
    }

    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        if (start != null) {
            JsonArrayBuilder ptsArrBuild = factory.createArrayBuilder();
            for (int i = 0; i < points.size(); i++) {
                ptsArrBuild.add(factory.createObjectBuilder()
                        .add("x", points.get(i).getX())
                        .add("y", points.get(i).getY()).build());
            }

            JsonObject out = factory.createObjectBuilder()
                    .add("modified", getDate().getTime())
                    .add("start", factory.createObjectBuilder().add("x", start.getX()).add("y", start.getY()))
                    .add("goal", goal)
                    .add("points", ptsArrBuild.build()).build();
            return out;
        } else {
            return factory.createObjectBuilder()
                    .add("goal", goal)
                    .add("modified", getDate().getTime()).build();
        }
    }

    private void readJson(JsonObject obj) {
        JsonNumber date = obj.getJsonNumber("modified");
        setDate(date.longValue());

        goal = obj.getInt("goal");

        JsonObject startPt = obj.getJsonObject("start");
        if (startPt != null) {
            start = new Point2D.Double(startPt.getJsonNumber("x").doubleValue(), startPt.getJsonNumber("y").doubleValue());
        }

        JsonArray pts = obj.getJsonArray("points");
        if (pts != null) {
            for (int i = 0; i < pts.size(); i++) {
                Point2D tmpPt = new Point2D.Double(pts.getJsonObject(i).getJsonNumber("x").doubleValue(), pts.getJsonObject(i).getJsonNumber("y").doubleValue());
                points.add(tmpPt);
            }
        }
    }
}
