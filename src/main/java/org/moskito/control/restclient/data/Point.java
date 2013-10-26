package org.moskito.control.restclient.data;

/**
 * @author: Vladyslav Bezuhlyi
 */
public class Point {

    private String x;

    private String y;


    public Point() {
    }

    public Point(String x, String y) {
        this.x = x;
        this.y = y;
    }


    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }

}
