package com.example.maciek.hangman_wordschallenge;

/**
 * Created by Maciek on 2017-01-25.
 */





public class panstwa {
    private long _id;
    private String panstwo;
    private String kontynent;
    public panstwa(long _id, String panstwo, String kontynent) {

        this._id = _id;
        this.panstwo = panstwo;
        this.kontynent = kontynent;
    }
    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(String panstwo) {
        this.panstwo = panstwo;
    }

    public String getKontynent() {
        return kontynent;
    }

    public void setKontynent(String kontynent) {
        this.kontynent = kontynent;
    }


}
