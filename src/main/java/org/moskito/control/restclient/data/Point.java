package org.moskito.control.restclient.data;

/**
 * @author: Vladyslav Bezuhlyi
 */
public class Point {

    private String x;

    private String y;

    private long timestamp;


    public Point() {
    }

    public Point(String x, String y, long timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
