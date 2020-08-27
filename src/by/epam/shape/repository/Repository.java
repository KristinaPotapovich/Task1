package by.epam.shape.repository;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private static Repository instance = new Repository();
    private List<Tetragon> tetragons = new ArrayList<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<Tetragon> query(Specification specification) {
        List<Tetragon> resultTetragons = tetragons.stream()
                .filter(tetragon -> specification.specify(tetragon))
                .collect(Collectors.toList());
        return resultTetragons;
    }


    public void sort(Comparator<Tetragon> c) {
        tetragons.sort(c);
    }

    public boolean add(Tetragon tetragon) {
        return tetragons.add(tetragon);
    }

    public boolean remove(Tetragon tetragon) {
        return tetragons.remove(tetragon);
    }

    public Tetragon get(int index) {
        return tetragons.get(index);
    }

    public List<Tetragon> getTetragons() {
        List<Tetragon> unModifileTetragons = Collections.unmodifiableList(tetragons);
        return unModifileTetragons;
    }

    public void add(int index, Tetragon element) {
        tetragons.add(index, element);
    }

    public Tetragon remove(int index) {
        return tetragons.remove(index);
    }
}
