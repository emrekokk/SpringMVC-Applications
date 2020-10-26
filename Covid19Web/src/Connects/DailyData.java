package Connects;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class DailyData {
    private int countryID;
    private String yil;
    private String ay;
    private String gun;
    private int numTest;
    private int numCase;
    private int numIntubated;
    private int numRecovered;
    private int numDeceased;
    private int numICU;

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public int getNumTest() {
        return numTest;
    }

    public void setNumTest(int numTest) {
        this.numTest = numTest;
    }

    public int getNumCase() {
        return numCase;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public int getNumIntubated() {
        return numIntubated;
    }

    public void setNumIntubated(int numIntubated) {
        this.numIntubated = numIntubated;
    }

    public int getNumRecovered() {
        return numRecovered;
    }

    public void setNumRecovered(int numRecovered) {
        this.numRecovered = numRecovered;
    }

    public int getNumDeceased() {
        return numDeceased;
    }

    public void setNumDeceased(int numDeceased) {
        this.numDeceased = numDeceased;
    }

    public int getNumICU() {
        return numICU;
    }

    public void setNumICU(int numICU) {
        this.numICU = numICU;
    }

    /*
    public JsonObject toJSON() {
        JsonObject jo = new JsonObject();

        jo.add("numtest", new JsonPrimitive(this.numTest));
        jo.add("numcase", new JsonPrimitive(this.numCase));
        jo.add("numicu", new JsonPrimitive(this.numICU));
        jo.add("numdeceased", new JsonPrimitive(this.numDeceased));
        jo.add("numrecovered", new JsonPrimitive(this.numRecovered));
        jo.add("numint", new JsonPrimitive(this.numIntubated));

        return jo;
    }

     */
}
