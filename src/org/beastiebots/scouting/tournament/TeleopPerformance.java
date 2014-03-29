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
public class TeleopPerformance extends Timestamped {

    boolean doubleHang;
    boolean hang;
    boolean flag;
    int numCubes;

    public TeleopPerformance() {
        super(0);
    }

    public TeleopPerformance(JsonObject obj) {
        super();
        this.readJson(obj);
    }

    public TeleopPerformance(boolean doubleHang, boolean hang, boolean flag, int numCubes) {
        this.doubleHang = doubleHang;
        this.hang = hang;
        this.flag = flag;
        this.numCubes = numCubes;
    }

    public boolean isDoubleHang() {
        return doubleHang;
    }

    public void setDoubleHang(boolean doubleHang) {
        this.doubleHang = doubleHang;
        updateDate();
    }

    public boolean isHang() {
        return hang;
    }

    public void setHang(boolean hang) {
        this.hang = hang;
        updateDate();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        updateDate();
    }

    public int getNumCubes() {
        return numCubes;
    }

    public void setNumCubes(int numCubes) {
        this.numCubes = numCubes;
        updateDate();
    }

    public static TeleopPerformance createTeleopPerformance(TeleopPerformance teleop) {
        return new TeleopPerformance(teleop.isDoubleHang(), teleop.isHang(), teleop.isFlag(), teleop.getNumCubes());
    }

    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject out = factory.createObjectBuilder()
                .add("modified", getDate().getTime())
                .add("doubleHang", doubleHang)
                .add("hang", hang)
                .add("flag", flag)
                .add("cubeCount", numCubes).build();
        return out;
    }

    private void readJson(JsonObject obj) {
        JsonNumber date = obj.getJsonNumber("modified");
        setDate(date.longValue());

        doubleHang = obj.getBoolean("doubleHang");
        hang = obj.getBoolean("hang");
        flag = obj.getBoolean("flag");
        numCubes = obj.getJsonNumber("cubeCount").intValue();
    }
}
