package org.craftedsw.tictactoe.view;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {

    public static Pair keyValue(String key, Object value) {
        return new ImmutablePair(key, value);
    }

    public static Map<String, Object> model(Pair... values) {
        Map<String, Object> model = new HashMap<String, Object>();
        addValuesTo(model, values);
        return model;
    }

    private static void addValuesTo(Map<String, Object> model, Pair[] values) {
        for (Pair<String, Object> value : values) {
            model.put(value.getLeft(), value.getRight());
        }
    }

}
