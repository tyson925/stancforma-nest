package com.stancforma.nesting;

import com.qunhe.util.nest.data.NestPath;
import com.qunhe.util.nest.data.Placement;
import com.qunhe.util.nest.util.Config;
import com.qunhe.util.nest.util.SvgUtil;
import com.stancforma.util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Nest {

    private Util util;

    public Nest() {
        util = new Util();
    }

    public void runNesting(File slicedDataFile, double binWidth, double binHeight) throws Exception {
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
        System.out.println(appliedPlacement);
        List<String> strings = SvgUtil.svgGenerator(polygons, appliedPlacement, binWidth, binHeight);

        util.saveSvgFile(strings, "./data/stancCikk/nestedData/" + slicedDataFile.getName().replace(".txt", ".html"));
    }

    public static void main(String[] args) {

        Nest nesting = new Nest();

        //String fileName = args[0];
        //double binWidth = Double.parseDouble(args[1]);
        //double binHeight = Double.parseDouble(args[2]);

        try {

//            for (File slicedDescriptionFile : new File("./data/stancCikk/descriptions/").listFiles()) {
//            //for (File slicedDescriptionFile : new File("./data/stancCikk/output/").listFiles()) {
//                long startTime = System.nanoTime();
//                nesting.runNesting(slicedDescriptionFile, 500, 2000);
//                long endTime = System.nanoTime();
//                Double totalTime = (endTime - startTime) / 1000.0 / 1000 / 1000;
//                System.out.println(totalTime);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./data/stancCikk/nestTime/" + slicedDescriptionFile.getName() + "_time.txt")));
//                writer.write(totalTime.toString());
//                writer.flush();
//            }

            nesting.runNesting(new File("/Users/istvannagy/Projects/my/Nest4J/data/stancCikk/descriptions/Sz-M-2018-11-0110gumi.dxf_700.txt"), 500.0,487.0);
//            for (File file : new File("./data/stanc_tdk/").listFiles()){
//                if (file.getName().endsWith("560.txt")){
//                    nesting.runNesting(file.getCanonicalPath());
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
