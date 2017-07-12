package br.andre.cdp.cdp_android.domain;

/**
 * Created by andremiranda on 03/07/17.
 */

public class Pelada {

    private int id;
    private int arenaDefaultId;
    private String day;
    private String name;

    public Pelada() {
    }

    public Pelada(int id, int arenaDefaultId, String day, String name) {
        this.id = id;
        this.arenaDefaultId = arenaDefaultId;
        this.day = day;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArenaDefaultId() {
        return arenaDefaultId;
    }

    public void setArenaDefaultId(int arenaDefaultId) {
        this.arenaDefaultId = arenaDefaultId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
