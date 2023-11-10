package com.example.gcccylclingmobileapplication;

public class Event {
    String eid;
    String name;
    String type;
    String[] requirements;

    // getters and setters
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setRequirements(String[] requirements) { this.requirements = requirements; }
    public void setEID(String eid) { this.eid = eid; }

    public String getName() { return name; }
    public String getType() { return type; }
    public String[] getRequirements() { return requirements; }
    public String getEID() { return eid; }
}
