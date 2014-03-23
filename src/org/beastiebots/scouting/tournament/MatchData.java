/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.beastiebots.scouting.tournament;

import java.awt.geom.Point2D;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

/**
 *
 * @author 142burroughsj
 */
public class MatchData {

    private String matchNumber;
    private AutonomousRoutine auto;
    private TeleopPerformance teleop;

    public MatchData(String matchNumber, AutonomousRoutine auto, TeleopPerformance teleop)
    {
        this.matchNumber = matchNumber;
        this.auto = auto;
        this.teleop = teleop;
    }
    
    public MatchData(JsonObject obj)
    {
        this.readJson(obj);
    }
    
    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public AutonomousRoutine getAuto() {
        return auto;
    }

    public void setAuto(AutonomousRoutine auto) {
        this.auto = auto;
    }

    public TeleopPerformance getTeleop() {
        return teleop;
    }

    public void setTeleop(TeleopPerformance teleop) {
        this.teleop = teleop;
    }
    
    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
            JsonObject out = factory.createObjectBuilder()
                    .add("number", matchNumber)
                    .add("autonomous", auto.toJson())
                    .add("teleop", teleop.toJson()).build();
            return out;
    }

    private void readJson(JsonObject obj) {
        matchNumber = obj.getJsonString("number").getString();
        auto = new AutonomousRoutine(obj.getJsonObject("autonomous"));
        teleop = new TeleopPerformance(obj.getJsonObject("teleop"));
    }
}
