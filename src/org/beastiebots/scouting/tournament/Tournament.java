/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament;

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
public class Tournament {

    private ArrayList<Team> teams;

    public Tournament() {
        super();
        teams = new ArrayList<>();
    }
    
    public Tournament(JsonObject obj) {
        super();
        teams = new ArrayList<>();
        this.readJson(obj);
    }
    
    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
    
    public Team getOrCreateTeamByNumber(int number) {
        Team ret = getTeamByNumber(number);
        if(ret == null)
        {
            return addTeamByNumber(number);
        }
        return ret;
    }

    public Team getTeamByNumber(int number) {
        for (Team team : teams) {
            if (team.getNumber() == number) {
                return team;
            }
        }
        return null;
    }

    public Team addTeamByNumber(int number) {
        Team ret = new Team(number);
        teams.add(ret);
        return ret;
    }

    public void removeTeamByNumber(int number) {
        teams.add(new Team(number));
    }
    
    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder teamArrBuild = factory.createArrayBuilder();
        if (teams != null) {
            for (int i = 0; i < teams.size(); i++) {
                teamArrBuild.add(teams.get(i).toJson());
            }
        }

        JsonObject out = factory.createObjectBuilder()
                .add("teams", teamArrBuild.build()).build();
        return out;
    }

    public void readJson(JsonObject obj) {
        JsonArray teamIn = obj.getJsonArray("teams");
        for (int i = 0; i < teamIn.size(); i++) {
            this.getOrCreateTeamByNumber(teamIn.getJsonObject(i).getJsonNumber("number").intValue()).readJson(teamIn.getJsonObject(i));
        }
    }
}
