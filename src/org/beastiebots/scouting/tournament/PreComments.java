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
public class PreComments extends Timestamped {

    String preComments;
    String prepreComments;

    public PreComments() {
        super(0);
        preComments = "";
        prepreComments = "";
    }

    public PreComments(JsonObject obj) {
        this();
        this.readJson(obj);
    }

    public String getPreComments() {
        return preComments;
    }

    public void setPreComments(String preComments) {
        this.preComments = preComments;
        updateDate();
    }

    public String getPrepreComments() {
        return prepreComments;
    }

    public void setPrepreComments(String prepreComments) {
        this.prepreComments = prepreComments;
        updateDate();
    }

    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject out = factory.createObjectBuilder()
                .add("modified", getDate().getTime())
                .add("prepreComments", prepreComments)
                .add("preComments", preComments).build();
        return out;
    }

    private void readJson(JsonObject obj) {
        JsonNumber date = obj.getJsonNumber("modified");
        setDate(date.longValue());

        preComments = obj.getString("preComments");
        prepreComments = obj.getString("prepreComments");
    }
}
