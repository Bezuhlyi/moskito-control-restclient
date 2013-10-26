package org.moskito.control.restclient.data.response;

import org.moskito.control.restclient.data.Chart;
import org.moskito.control.restclient.data.Response;

import java.util.List;

/**
 * @author: Vladyslav Bezuhlyi
 */
public class ChartsResponse extends Response {

    private List<Chart> charts;


    public ChartsResponse() {
    }

    public ChartsResponse(List<Chart> charts) {
        this.charts = charts;
    }


    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }

    @Override
    public String toString() {
        return "ChartsResponse{" +
                "charts=" + charts +
                '}';
    }

}
