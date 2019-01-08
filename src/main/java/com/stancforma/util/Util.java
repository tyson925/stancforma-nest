package com.stancforma.util;

import com.qunhe.util.nest.data.NestPath;
import com.qunhe.util.nest.data.Segment;
import com.qunhe.util.nest.util.GeometryUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<NestPath> readData(String inputFileName) {
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
                        //if (cx < cy) {
                        //    double tmp = cy;
                        //    cx = cy;
                        //    cy = tmp;
                        //}
                        double r = Double.parseDouble(pointDataValues[3]);

                        double a = Double.parseDouble(pointDataValues[4]);
                        double b = Double.parseDouble(pointDataValues[5]);
                        boolean isSweep = true;
                        if (a < b) {
                            isSweep = false;
                            //double tmp = a;
                            //a = b;
                            //b = tmp;
                        }

                        double x1 = cx + r * Math.cos(a);
                        double y1 = cy + r * Math.sin(a);
                        double x2 = cx + r * Math.cos(b);
                        double y2 = cy + r * Math.sin(b);

                        NestPath path = null;
                        if (isSweep ) {
                            path =GeometryUtil.linearize(new Segment(x1, y1),new Segment(x2, y2), r, r, 0,0,0,0.1);
                        } else {
                            path =GeometryUtil.linearize(new Segment(x1, y1),new Segment(x2, y2), r, r, 0,0,1,0.1);
                        }
                        for (Segment segment : path.getSegments()){
                            polygon.add(segment);
                        }
                    }

                }


                polygon.bid = count;
                polygon.setRotation(4);
                nestPaths.add(polygon);
                count++;

                //reader.readLine();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nestPaths;
    }

    public void saveSvgFile(List<String> strings, String fileName) throws Exception {
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
