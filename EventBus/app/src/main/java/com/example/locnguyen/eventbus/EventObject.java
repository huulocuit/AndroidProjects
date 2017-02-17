package com.example.locnguyen.eventbus;

/**
 * Created by loc.nguyen on 2/16/2017.
 */

public class EventObject {

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EventObject(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
