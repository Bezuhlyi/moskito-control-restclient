package org.moskito.control.restclient.data;

import java.util.Iterator;
import java.util.List;

/**
 * @author: Vladyslav Bezuhlyi
 */
public class Chart {

    private String name;

    private List<Line> lines;


    public Chart() {
    }

    public Chart(String name, List<Line> lines) {
        this.name = name;
        this.lines = lines;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * Sets names to chart lines. Association executes by order.
     *
     * @param names lines names.
     */
    public void setLinesNames(List<String> names) {
        Iterator namesIterator = names.iterator();
        Iterator linesIterator = lines.iterator();
        while(namesIterator.hasNext() && linesIterator.hasNext()) {
            Line currentLine = (Line) linesIterator.next();
            currentLine.setName((String) namesIterator.next());
        }
    }

    @Override
    public String toString() {
        return "Chart{" +
                "name='" + name + '\'' +
                ", lines=" + lines +
                '}';
    }

}
