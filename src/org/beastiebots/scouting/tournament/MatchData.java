/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament;

import javax.json.Json;
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
    private SubjectiveComments comments;

    public MatchData(String matchNumber, AutonomousRoutine auto, TeleopPerformance teleop) {
        this();
        this.matchNumber = matchNumber;
        this.auto = auto;
        this.teleop = teleop;
    }
    
    public MatchData(String matchNumber, SubjectiveComments comments) {
        this();
        this.matchNumber = matchNumber;
        this.comments = comments;
    }

    public MatchData(JsonObject obj) {
        this();
        this.readJson(obj);
    }

    public MatchData() {
        comments = new SubjectiveComments();
        auto = new AutonomousRoutine();
        teleop = new TeleopPerformance();
        matchNumber = "";
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

    public SubjectiveComments getComments() {
        return comments;
    }

    public void setComments(SubjectiveComments comments) {
        this.comments = comments;
    }
    
    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject out = factory.createObjectBuilder()
                .add("number", matchNumber)
                .add("autonomous", auto.toJson())
                .add("teleop", teleop.toJson())
                .add("comments", comments.toJson()).build();
        return out;
    }

    public boolean readJson(JsonObject obj) {
        boolean changed = false;
        if (!obj.getString("number").equals(matchNumber)) {
            matchNumber = obj.getString("number");
            changed = true;
        }
        
        if (obj.containsKey("autonomous")) {
            AutonomousRoutine autoTmp = new AutonomousRoutine(obj.getJsonObject("autonomous"));
            if (auto == null || autoTmp.getDate().after(auto.getDate())) {
                auto = autoTmp;
                changed = true;
            }
        }
        if (obj.containsKey("teleop")) {
            TeleopPerformance teleopTmp = new TeleopPerformance(obj.getJsonObject("teleop"));
            if (teleop == null || teleopTmp.getDate().after(teleop.getDate())) {
                teleop = teleopTmp;
                changed = true;
            }
        }
        if (obj.containsKey("comments")) {
            SubjectiveComments commentsTmp = new SubjectiveComments(obj.getJsonObject("comments"));
            if (comments == null || !comments.getComments().contains(commentsTmp.getComments())) {
                comments.readJson(obj.getJsonObject("comments"));
                changed = true;
            }
        }
        return changed;
    }
}
