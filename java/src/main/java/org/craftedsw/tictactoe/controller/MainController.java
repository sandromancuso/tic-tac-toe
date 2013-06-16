package org.craftedsw.tictactoe.controller;

import org.craftedsw.tictactoe.ViewRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

public class MainController {

    private final ViewRenderer view;

    public MainController(ViewRenderer viewRenderer) {
        this.view = viewRenderer;
        defineMappings();
    }

    void defineMappings() {

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return view.render("index.jade", null);
            }
        });

    }

}
