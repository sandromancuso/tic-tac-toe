package org.craftedsw.tictactoe.controller;

import org.craftedsw.tictactoe.view.ViewRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

import static org.craftedsw.tictactoe.view.ViewModel.keyValue;
import static org.craftedsw.tictactoe.view.ViewModel.model;
import static spark.Spark.get;

public class MainController {

    private final ViewRenderer view;

    public MainController(ViewRenderer viewRenderer) {
        this.view = viewRenderer;
        defineMappings();
    }

    void defineMappings() {

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return view.render("index.jade",
                        model(keyValue("pageTitle", "Blah")));
            }
        });

    }

}
