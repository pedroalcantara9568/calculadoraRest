package com.example.restful;

import java.io.Serializable;

public class Greeting implements Serializable {

    private final long id;

    private final String content;

    public Greeting(long id, String contente) {
        this.id = id;
        this.content = contente;
    }

    public long getId() {
        return id;
    }

    public String getContente() {
        return content;
    }
}
