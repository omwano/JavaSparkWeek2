package com.niawetu;

import org.sql2o.Sql2o;
public class DbConfig {

    public static Sql2o getDatabase() {
        return new Sql2o("jdbc:postgresql://localhost:5432/hero-squads");


    }

}