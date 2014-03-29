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
import javax.json.JsonObject;
import org.beastiebots.utilities.Timestamped;

/**
 *
 * @author Jacob Burroughs
 */
public class Team {

    private int number;
    private ArrayList<MatchData> data;
    private PreComments preComments;

    public Team(int number) {
        this();
        this.number = number;
        this.preComments = new PreComments();
    }

    public Team() {
        this.data = new ArrayList<MatchData>();
    }

    public Team(JsonObject obj) {
        this();
        this.readJson(obj);
    }

    public PreComments getPreComments() {
        return preComments;
    }

    public void setPreComments(PreComments preComments) {
        this.preComments = preComments;
    }

    public int getNumber() {
        return number;
    }

    public void addMatchData(MatchData data) {
        this.data.add(data);
    }

    public List<MatchData> getMatchData() {
        return Collections.unmodifiableList(data);
    }

    public MatchData getMatchDataByNumber(String matchNumber) {
        for (MatchData match : data) {
            if (match.getMatchNumber().equals(matchNumber)) {
                return match;
            }
        }
        return null;
    }

    public boolean removeMatchDataByNumber(String matchNumber) {
        for (MatchData match : data) {
            if (match.getMatchNumber().equals(matchNumber)) {
                return data.remove(match);
            }
        }
        return false;
    }

    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder matchArrBuild = factory.createArrayBuilder();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                matchArrBuild.add(data.get(i).toJson());
            }
        }

        JsonObject out = factory.createObjectBuilder()
                .add("number", number)
                .add("preComments",preComments.toJson())
                .add("matches", matchArrBuild.build()).build();
        return out;
    }

    public void readJson(JsonObject obj) {
        number = obj.getJsonNumber("number").intValue();

        JsonArray matches = obj.getJsonArray("matches");
        for (int i = 0; i < matches.size(); i++) {
            if (getMatchDataByNumber(matches.getJsonObject(i).getString("number")) == null) {
                data.add(new MatchData(matches.getJsonObject(i)));
            } else {
                getMatchDataByNumber(matches.getJsonObject(i).getString("number")).readJson(matches.getJsonObject(i));
            }
        }
        
        if (obj.containsKey("preComments")) {
            PreComments preCommentsTmp = new PreComments(obj.getJsonObject("preComments"));
            if (preComments == null || preCommentsTmp.getDate().after(preComments.getDate())) {
                preComments = preCommentsTmp;
            }
        }
    }
}
