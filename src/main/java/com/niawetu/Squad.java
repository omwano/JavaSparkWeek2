package com.niawetu;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private int maxSize;
    private String name;
    private String cause;
    private List<Hero> heroes;

    public Squad(int maxSize, String name, String cause) {
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        this.heroes = new ArrayList<>();
    }
    public void addHero(Hero hero){
        this.heroes.add(hero);
    }

}
