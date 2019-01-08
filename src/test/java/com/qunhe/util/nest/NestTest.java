package com.qunhe.util.nest;


import com.qunhe.util.nest.data.NestPath;
import com.qunhe.util.nest.data.Placement;
import com.qunhe.util.nest.data.Segment;
import com.qunhe.util.nest.util.Config;
import com.qunhe.util.nest.util.GeometryUtil;
import com.qunhe.util.nest.util.SvgUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class NestTest {


    @Test
    public void HoleTest() throws Exception {
        NestPath binPolygon = new NestPath();
        double width = 400;
        double height = 400;
        binPolygon.add(0, 0);
        binPolygon.add(0, height);
        binPolygon.add(width, height);
        binPolygon.add(width, 0);
        NestPath outer = new NestPath();
        outer.add(600, 0);
        outer.add(600, 200);
        outer.add(800, 200);
        outer.add(800, 0);
        outer.setRotation(0);
        outer.bid = 1;
        NestPath inner = new NestPath();
        inner.add(650, 50);
        inner.add(650, 150);
        inner.add(750, 150);
        inner.add(750, 50);
        inner.bid = 2;
        NestPath little = new NestPath();
        little.add(900, 0);
        little.add(870, 20);
        little.add(930, 20);
        little.bid = 3;
        little.setRotation(4);
        List<NestPath> list = new ArrayList<NestPath>();
        list.add(inner);
        list.add(outer);
        list.add(little);
        Config config = new Config();
        config.USE_HOLE = true;
        Nest nest = new Nest(binPolygon, list, config, 10);
        List<List<Placement>> appliedPlacement = nest.startNest();
        List<String> strings = SvgUtil.svgGenerator(list, appliedPlacement, width, height);
        saveSvgFile(strings, "test2.html");
        for (String s : strings) {
            System.out.println(s);
        }

    }


    @Test
    public void testSample() throws Exception {
        List<NestPath> polygons = readData("./slicer/Sz-M-2018-10-0195gumi.dxf.txt");transferSvgIntoPolygons();
        //List<NestPath> polygons = readData("./Downloads/RUBBER_I_10.txt");
        //List<NestPath> polygons = readData("./test.txt");
        //List<NestPath> polygons = new LinkedList<>();
        //System.out.println(polygons);
        //List<NestPath> polygons = new LinkedList<>();
        //NestPath nestPath = GeometryUtil.linearize(new Segment(80, 80), new Segment(125, 125), 10, 10, 0, 0, 0, 1);
        //NestPath nestPath = GeometryUtil.linearize(new Segment(1204.94, 1012.7), 1.5708, 2.16744, 7.85*10);
        double cx = 1145.07;
        double cy = 951.679;
        double r =7.85;
        double x1 = cx + r * Math.cos(4.71238);
        double y1 = cy + r * Math.sin(4.71238);
        double x2 = cx + r * Math.cos(6.28319);
        double y2 = cy + r * Math.sin(6.28319);
        NestPath nestPath2 = GeometryUtil.linearize(new Segment(x1,y1),new Segment(x2,y2),r,r,0,0,0,0.5);
        //polygons.add(nestPath2);
        //polygons.add(nestPath2);
        NestPath bin = new NestPath();
        double binWidth = 500;
        double binHeight = 300;
        bin.add(0, 0);
        bin.add(binWidth, 0);
        bin.add(binWidth, binHeight);
        bin.add(0, binHeight);
        bin.bid = -1;
        Config config = new Config();
        config.SPACING = 0;
        config.POPULATION_SIZE = 15;
        
        Nest nest = new Nest(bin, polygons, config, 2);
        List<List<Placement>> appliedPlacement = nest.startNest();
        System.out.println(appliedPlacement);
        List<String> strings = SvgUtil.svgGenerator(polygons, appliedPlacement, binWidth, binHeight);
        saveSvgFile(strings, "test.html");
    }

    private List<NestPath> readData(String inputFileName) {
        List<NestPath> nestPaths = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
            int count = 0;
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                NestPath polygon = new NestPath();
                String[] pointsData = line.split(" ");

                for (String pointData : pointsData) {
                    String[] pointDataValues = pointData.split(",");
                    if (pointDataValues[0].equals("L")) {
                        double x = Double.parseDouble(pointDataValues[1]);
                        double y = Double.parseDouble(pointDataValues[2]);
                        polygon.add(x, y);
                        double x1 = Double.parseDouble(pointDataValues[3]);
                        double y1 = Double.parseDouble(pointDataValues[4]);
                        polygon.add(x1, y1);

                    } else if (pointDataValues[0].equals("A")) {
                        double cx = Double.parseDouble(pointDataValues[1]);
                        double cy = Double.parseDouble(pointDataValues[2]);
                        double r = Double.parseDouble(pointDataValues[3]);
                        double x1 = cx + r * Math.cos(Double.parseDouble(pointDataValues[4]));
                        double y1 = cy + r * Math.sin(Double.parseDouble(pointDataValues[4]));
                        double x2 = cx + r * Math.cos(Double.parseDouble(pointDataValues[5]));
                        double y2 = cy + r * Math.sin(Double.parseDouble(pointDataValues[5]));

                        NestPath path = GeometryUtil.linearize(new Segment(x1, y1),new Segment(x2, y2), r, r, 0,0,1,0.1);
                        for (Segment segment : path.getSegments()){
                            polygon.add(segment);
                        }
                    }

                }


                polygon.bid = count;
                polygon.setRotation(4);
                nestPaths.add(polygon);
                count++;

                reader.readLine();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nestPaths;
    }

    private List<NestPath> transferSvgIntoPolygons() throws DocumentException {
        List<NestPath> nestPaths = new ArrayList<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read("test2.xml");
        List<Element> elementList = document.getRootElement().elements();
        int count = 0;
        for (Element element : elementList) {
            count++;
            if ("polygon".equals(element.getName())) {
                String datalist = element.attribute("points").getValue();
                NestPath polygon = new NestPath();
                for (String s : datalist.split(" ")) {
                    s = s.trim();
                    if (s.indexOf(",") == -1) {
                        continue;
                    }
                    String[] value = s.split(",");
                    double x = Double.parseDouble(value[0]);
                    double y = Double.parseDouble(value[1]);
                    polygon.add(x, y);
                }
                polygon.bid = count;
                polygon.setRotation(4);
                nestPaths.add(polygon);
            } else if ("rect".equals(element.getName())) {
                double width = Double.parseDouble(element.attribute("width").getValue());
                double height = Double.parseDouble(element.attribute("height").getValue());
                double x = Double.parseDouble(element.attribute("x").getValue());
                double y = Double.parseDouble(element.attribute("y").getValue());
                NestPath rect = new NestPath();
                rect.add(x, y);
                rect.add(x + width, y);
                rect.add(x + width, y + height);
                rect.add(x, y + height);
                rect.bid = count;
                rect.setRotation(4);
                nestPaths.add(rect);
            }
        }
        return nestPaths;
    }

    private void saveSvgFile(List<String> strings, String fileName) throws Exception {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
        Writer writer = new FileWriter(f, false);
        writer.write("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n" +
                "\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                " \n" +
                "<svg width=\"100%\" height=\"100%\" version=\"1.1\"\n" +
                "xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (String s : strings) {
            writer.write(s);
        }
        writer.write("</svg>");
        writer.close();
    }

}
