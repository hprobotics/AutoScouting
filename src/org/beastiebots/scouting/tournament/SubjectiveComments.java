/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import org.beastiebots.utilities.Timestamped;

/**
 *
 * @author Jacob
 */
public class SubjectiveComments extends Timestamped {

    String comments;

    public SubjectiveComments() {
        super(0);
        comments = "";
    }

    public SubjectiveComments(JsonObject obj) {
        this();
        this.readJson(obj);
    }

    public SubjectiveComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
        updateDate();
    }

    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject out = factory.createObjectBuilder()
                .add("modified", getDate().getTime())
                .add("comments", comments).build();
        return out;
    }

    void readJson(JsonObject obj) {
        JsonNumber date = obj.getJsonNumber("modified");
        setDate(date.longValue());
        System.out.println(comments);
        comments = comments + ((comments.equals(""))?"":"\n\n") + obj.getString("comments");
    }
}
