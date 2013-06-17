package org.craftedsw.tictactoe.controller;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.craftedsw.tictactoe.ViewRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

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

    private Pair keyValue(String key, Object value) {
        return new ImmutablePair(key, value);
    }

    private Map<String, Object> model(Pair... values) {
        Map<String, Object> model = new HashMap<String, Object>();
        addValuesTo(model, values);
        return model;
    }

    private void addValuesTo(Map<String, Object> model, Pair[] values) {
        for (Pair<String, Object> value : values) {
            model.put(value.getLeft(), value.getRight());
        }
    }

}
