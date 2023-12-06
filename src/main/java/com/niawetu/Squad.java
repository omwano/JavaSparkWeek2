package com.niawetu;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private int maxSize;
    private String name;
    private String cause;
    private static ArrayList<Squad> instance = new ArrayList<Squad>();
    private int id;
    private List<Hero> Heroes;

    // Create a constructor
    public Squad(int maxSize, String name, String cause){
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        instance.add(this);
        this.id = instance.size();
        Heroes=new ArrayList<Hero>();

    }

    // Create get methods
    public int getMaxSize() {
        return maxSize;
    }
    public String getName(){
        return name;
    }
    public String getCause() {
        return cause;
    }
    public static  ArrayList<Squad> getAll(){
        return instance;
    }

    public int getId() {
        return id;
    }
    public static Squad findById(int id) {
        return instance.get(id - 1);
    }
    public List<Hero> getHeroes() {
        return Heroes;
    }

    public void addHero(Hero hero) {
        Heroes.add(hero);
    }

    public static boolean heroAlreadyExists(Hero newHero) {
        boolean exists = false;
        for (Squad squad : instance) {
            for (Hero hero : squad.getHeroes()) {
                if (hero.getName().equals(newHero.getName())) {
                    exists = true;
                }
            }
        }
        return exists;
    }
}