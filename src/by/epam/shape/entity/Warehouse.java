package by.epam.shape.entity;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private Map<Long, TetragonParameters> parametres = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();

        }
        return instance;
    }


    public void put(long tetragonId, TetragonParameters tetragonParameters) {
        parametres.put(tetragonId, tetragonParameters);
    }

    public void remove(long tetragonId) {
        parametres.remove(tetragonId);
    }

    public TetragonParameters get(long tetragonId) {
        return parametres.get(tetragonId);
    }

    public Map<Long, TetragonParameters> getParametres() {
        Map<Long, TetragonParameters> unModifiableParametres = Collections.unmodifiableMap(parametres);
        return unModifiableParametres;
    }
}



