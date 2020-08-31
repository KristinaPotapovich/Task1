package by.epam.shape.repository;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetragonRepository {
    private static TetragonRepository instance = new TetragonRepository();
    private List<Tetragon> tetragons = new ArrayList<>();

    private TetragonRepository() {

    }

    public static TetragonRepository getInstance() {
        if (instance == null) {
            instance = new TetragonRepository();
        }
        return instance;
    }

    public List<Tetragon> query(TetragonSpecification tetragonSpecification) {
        List<Tetragon> resultTetragons = tetragons.stream()
                .filter(tetragon -> tetragonSpecification.specify(tetragon))
                .collect(Collectors.toList());
        return resultTetragons;
    }


    public void sort(Comparator<Tetragon> comparator) {
        tetragons.sort(comparator);
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
        return Collections.unmodifiableList(tetragons);
    }

    public void add(int index, Tetragon element) {
        tetragons.add(index, element);
    }

    public Tetragon remove(int index) {
        return tetragons.remove(index);
    }
}
