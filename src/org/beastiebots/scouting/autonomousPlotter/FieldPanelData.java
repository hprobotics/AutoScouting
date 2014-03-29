/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.autonomousPlotter;

import java.awt.geom.Point2D;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.beastiebots.scouting.tournament.AutonomousRoutine;

/**
 *
 * @author Jacob Burroughs
 */
public class FieldPanelData {

    private AutonomousRoutine auto;
    private Point2D lastPoint;

    public FieldPanelData() {
        auto = new AutonomousRoutine();
    }

    public void reset() {
        auto = new AutonomousRoutine();
    }

    public void setAuto(AutonomousRoutine auto) {
        this.auto = auto;
    }

    public AutonomousRoutine getAuto() {
        return auto;
    }

    public Point2D getStart() {
        if (auto.getStart() != null) {
            return auto.getStart();
        } else {
            return lastPoint;
        }
    }

    public void setStart(Point2D start) {
        auto.setStart(start);
        auto.setFirstPoint(start);
    }

    public void replEndPoint(Point2D point) {
        lastPoint = point;
    }

    public void addPoint(Point2D point) {
        auto.addPoint(point);
        if (auto.getPoints().size() == 1) {
            auto.setStart(point);
        }
    }

    public List<Point2D> getPoints() {
        List<Point2D> ret = new ArrayList<Point2D>(auto.getPoints());
        if (lastPoint != null) {
            ret.add(lastPoint);
        }
        return ret;
    }

}
