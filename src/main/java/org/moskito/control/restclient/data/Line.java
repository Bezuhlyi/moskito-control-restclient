package org.moskito.control.restclient.data;

import java.util.List;

/**
 * @author: Vladyslav Bezuhlyi
 */
public class Line {

    private String name;

    private List<Point> points;


    public Line() {
    }

    public Line(String name, List<Point> points) {
        this.name = name;
        this.points = points;
    }


    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }

}


