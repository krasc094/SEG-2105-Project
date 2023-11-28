package com.example.gcccylclingmobileapplication;

import java.util.Random;

public class Event {
    String eid;
    String name;
    String type;
    String[] requirements;

    public Event() {
        generateEID();
    }

    public Event(String name, String type, String[] requirements) {
        this.name = name;
        this.type = type;
        this.requirements = requirements;
    }

    // getters and setters
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setRequirements(String[] requirements) { this.requirements = requirements; }
    public void generateEID() {
        String eventID = "";

        String NUMS = "1234567890";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String POSSIBLE = NUMS + LOWER + UPPER;

        Random rnd = new Random();

        while (eventID.length() < 32) {
            int index = (int) (rnd.nextFloat() * POSSIBLE.length());
            eventID += POSSIBLE.charAt(index);
        }

        this.eid = eventID;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String[] getRequirements() { return requirements; }
    public String getEID() { return eid; }

}
