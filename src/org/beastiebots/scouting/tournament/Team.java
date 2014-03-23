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

    public Team(int number) {
        super();
        this.number = number;
        this.data = new ArrayList<>();
    }
    
    public Team() {
        super();
        this.data = new ArrayList<>();
    }
    
    public Team(JsonObject obj){
        super();
        this.data = new ArrayList<>();
        this.readJson(obj);
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
                .add("matches", matchArrBuild.build()).build();
        return out;
    }

    public void readJson(JsonObject obj) {
        number = obj.getJsonNumber("number").intValue();
        
        JsonArray matches = obj.getJsonArray("matches");
        for (int i = 0; i < matches.size(); i++) {
            data.add(new MatchData(matches.getJsonObject(i)));
        }
    }
}
