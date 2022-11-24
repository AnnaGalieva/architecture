package Homework.modelelements;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Полигон
 */
public class Poligon {

    private Collection<Point3D> points = new ArrayList<>();

    public Collection<Point3D> getPoints() {
        return points;
    }

    public void setPoints(Collection<Point3D> points) {
        this.points = points;
    }
}