package com.stancforma.nesting;

import com.qunhe.util.nest.data.NestPath;
import com.qunhe.util.nest.data.Placement;
import com.qunhe.util.nest.util.Config;
import com.stancforma.util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class OptimizeNest {


    private Util util;

    public OptimizeNest() {
        util = new Util();
    }

    public List<List<Placement>> runNesting(File slicedDataFile, double binWidth, double binHeight) throws Exception {
        List<NestPath> polygons = util.readData(slicedDataFile.getCanonicalPath());//transferSvgIntoPolygons();
        NestPath bin = new NestPath();
        //double binWidth = 500;
        //double binHeight = 245;
        bin.add(0, 0);
        bin.add(binWidth, 0);
        bin.add(binWidth, binHeight);
        bin.add(0, binHeight);
        bin.bid = 0;
        Config config = new Config();
        config.USE_HOLE = true;
        config.SPACING = 0;
        config.POPULATION_SIZE = 135;

        com.qunhe.util.nest.Nest nest = new com.qunhe.util.nest.Nest(bin, polygons, config, 2);
        List<List<Placement>> appliedPlacement = nest.startNest();
        //System.out.println(appliedPlacement);
        //List<String> strings = SvgUtil.svgGenerator(polygons, appliedPlacement, binWidth, binHeight);

        return appliedPlacement;
    }


    public static void main(String[] args) {

        OptimizeNest nesting = new OptimizeNest();


        try {
            for (File slicedDescriptionFile : new File("./data/stancCikk/descriptions/").listFiles()) {
                long startTime = System.nanoTime();
                int startHeight = 1000;
                int d = 500;
                boolean isRun = true;
                //File slicedDescriptionFile = new File("/Users/istvannagy/Projects/my/Nest4J/data/stancCikk/descriptions/Sz-M-2018-11-0110gumi.dxf_700.txt");
                while (d > 50) {
                    System.out.println("applied height: " + (startHeight));
                    //for (File slicedDescriptionFile : new File("./data/stancCikk/output/").listFiles()) {

                    List<List<Placement>> appliedPlacement = nesting.runNesting(slicedDescriptionFile, 500, startHeight);
                    if (appliedPlacement.size() == 1) {
                        if (startHeight -  d == d){
                            //d = d/2;
                            startHeight = d;
                        } else if (startHeight -  d == 0){
                            d = d/2;
                            startHeight = d;
                        } else {
                            startHeight = startHeight - d;
                        }
                    } else {
                        d = d/2;
                        startHeight = startHeight + d;
                    }


                }
                /*isRun = true;
                while (isRun) {
                    startHeight = (int) Math.round(startHeight * 1.1);
                    long startTime = System.nanoTime();
                    List<List<Placement>> appliedPlacement = nesting.runNesting(slicedDescriptionFile, 500, startHeight);
                    if (appliedPlacement.size() == 1) {
                        isRun = false;
                    }
                    long endTime = System.nanoTime();
                    Double totalTime = (endTime - startTime) / 1000.0 / 1000 / 1000;
                    System.out.println(totalTime);
                }*/
                long endTime = System.nanoTime();
                Double totalTime = (endTime - startTime) / 1000.0 / 1000 / 1000;
                System.out.println("running time: " + totalTime);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/stancCikk/nestTime/" + slicedDescriptionFile.getName() + "_time.txt")));
                writer.write(totalTime.toString());
                writer.flush();
                System.out.println("final height to the file is: " + startHeight);
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/stancCikk/optimizeSize/" + slicedDescriptionFile.getName())));
                writer.write(new Integer(startHeight).toString());
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
