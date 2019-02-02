package com.example.maciek.hangman_wordschallenge;

/**
 * Created by Maciek on 2017-01-27.
 */

public class statistic {

    private long rowId;
    private String wygrane;
    private String przegrane;

    public statistic(long rowId, String wygrane, String przegrane) {
        this.rowId = rowId;
        this.wygrane = wygrane;
        this.przegrane = przegrane;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getWygrane() {
        return wygrane;
    }

    public void setWygrane(String wygrane) {
        this.wygrane = wygrane;
    }

    public String getPrzegrane() {
        return przegrane;
    }

    public void setPrzegrane(String przegrane) {
        this.przegrane = przegrane;
    }
}
