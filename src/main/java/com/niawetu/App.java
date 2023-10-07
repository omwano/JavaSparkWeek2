package com.niawetu;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    private static final List<Hero>heroes = new ArrayList<>();
    private static final List<Squad>squads = new ArrayList<>();

    public static void main(String[] args){
        staticFiles.location("/public");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroes",heroes);
            model.put("squads",squads);
            return new ModelAndView(model,"index.hbs");
        },
        new HandlebarsTemplateEngine());

        post( "/heroes",(req,res)-> {
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            Hero hero = new Hero(name, age, power, weakness);
            heroes.add(hero);
            res.redirect("/");
            return null;
        });

        post("/squads", (req,res) ->{
            String name = req.queryParams("name");
            int maxSize = Integer.parseInt(req.queryParams("maxSize"));
            String cause = req.queryParams("cause");
            Squad squad = new Squad(maxSize,name,cause);
            squads.add(squad);
            res.redirect("/");
            return null;
                }
                );

        post("/squads/:id/assign",(req,res)->{
            int squadId = Integer.parseInt(req.params("id"));
            int heroIndex = Integer.parseInt(req.queryParams("hero"));

            Squad squad = squads.get(squadId);
            Hero hero = heroes.get(heroIndex);
            squad.addHero(hero);
            res.redirect("/");
            return null;
        });
         exception(Exception.class, (exception,request,response)->
         {
             response.status(500);
             response.body("Internal Server Error");
         });
    }
}
