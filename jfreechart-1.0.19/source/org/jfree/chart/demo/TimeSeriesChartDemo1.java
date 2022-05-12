/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2014, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.]
 *
 * -------------------------
 * TimeSeriesChartDemo1.java
 * -------------------------
 * (C) Copyright 2003-2014, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   ;
 *
 * Changes
 * -------
 * 09-Mar-2005 : Version 1, copied from the demo collection that ships with
 *               the JFreeChart Developer Guide (DG);
 *
 */

package org.jfree.chart.demo;

import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

/**
 * An example of a time series chart.  For the most part, default settings are
 * used, except that the renderer is modified to show filled shapes (as well as
 * lines) at each data point.
 */
public class TimeSeriesChartDemo1 extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    static {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow",
                true));
    }

    /**
     * A demonstration application showing how to create a simple time series
     * chart.  This example uses monthly data.
     *
     * @param title the frame title.
     */
    public TimeSeriesChartDemo1(String title) {
        super(title);
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     *
     * @param dataset a dataset.
     * @return A chart.
     */
    private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "coolness graphed over time",  // title
                "Date",             // x-axis label
                "coolness index",   // y-axis label
                dataset,            // data
                true,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return chart;

    }

    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return The dataset.
     */
    private static XYDataset createDataset() {

        TimeSeries s1 = new TimeSeries("uly");
        s1.add(new Month(11, 2004), 630.56);
        s1.add(new Month(3, 2005), 546);
        s1.add(new Month(8, 2005), 600.5);
        s1.add(new Month(6, 2006), 590.2);
        s1.add(new Month(12, 2006), 740);
        s1.add(new Month(8, 2007), 356);
        s1.add(new Month(4, 2008), 560);
        s1.add(new Month(8, 2008), 575);
        s1.add(new Month(6, 2009), 677);
        s1.add(new Month(1, 2010), 780);
        s1.add(new Month(12, 2010), 745);
        s1.add(new Month(5, 2011), 777);
        s1.add(new Month(1, 2012), 800);
        s1.add(new Month(11, 2012), 2000);
        s1.add(new Month(6, 2013), 788);
        s1.add(new Month(1, 2014), 1000);
        s1.add(new Month(6, 2015), 689);
        s1.add(new Month(7, 2016), 891);
        s1.add(new Month(8, 2016), 901);
        s1.add(new Month(9, 2017), 945);
        s1.add(new Month(10, 2018), 955);
        s1.add(new Month(11, 2018), 1000);
        s1.add(new Month(6, 2019), 789);
        s1.add(new Month(3, 2020), 234);
        s1.add(new Month(4, 2021), 967);
        s1.add(new Month(11, 2021), 2000);
        s1.add(new Month(5, 2022), 1100);

        TimeSeries s2 = new TimeSeries("else");
        s2.add(new Month(11, 2004), 64);
        s2.add(new Month(3, 2005), 234);
        s2.add(new Month(8, 2005), 243);
        s2.add(new Month(6, 2006), 212);
        s2.add(new Month(12, 2006), 213);
        s2.add(new Month(8, 2007), 154);
        s2.add(new Month(4, 2008), 190);
        s2.add(new Month(8, 2008), 179);
        s2.add(new Month(6, 2009), 344);
        s2.add(new Month(1, 2010), 234);
        s2.add(new Month(12, 2010), 212);
        s2.add(new Month(5, 2011), 322);
        s2.add(new Month(1, 2012), 232);
        s2.add(new Month(11, 2012), 123);
        s2.add(new Month(6, 2013), 344);
        s2.add(new Month(1, 2014), 332);
        s2.add(new Month(6, 2015), 123);
        s2.add(new Month(7, 2016), 1200);
        s2.add(new Month(8, 2016), 790);
        s2.add(new Month(9, 2017), 343);
        s2.add(new Month(10, 2018), 243);
        s2.add(new Month(11, 2018), 318);
        s2.add(new Month(6, 2019), 123);
        s2.add(new Month(3, 2020), 334);
        s2.add(new Month(4, 2021), 234);
        s2.add(new Month(11, 2021), 345);
        s2.add(new Month(5, 2022), 123);

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {

        TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1(
                "coolness charted over time");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
