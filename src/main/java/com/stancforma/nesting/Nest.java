package com.stancforma.nesting;

import com.qunhe.util.nest.data.NestPath;
import com.qunhe.util.nest.data.Placement;
import com.qunhe.util.nest.util.Config;
import com.qunhe.util.nest.util.SvgUtil;
import com.stancforma.util.Util;

import java.util.List;

public class Nest {

    private Util util;

    public Nest() {
        util = new Util();
    }

    public void runNesting(String fileName, double binWidth, double binHeight) throws Exception {
        List<NestPath> polygons = util.readData(fileName);//transferSvgIntoPolygons();
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
        util.saveSvgFile(strings, fileName.replace(".txt", ".html"));
    }

    public static void main(String[] args) {

        Nest nesting = new Nest();

        String fileName = args[0];
        double binWidth = Double.parseDouble(args[1]);
        double binHeight = Double.parseDouble(args[2]);

        try {
            nesting.runNesting(fileName, binWidth, binHeight);
            //nesting.runNesting("./data/stanc_tdk/Sz-M-2018-10-0401gumi.dxf_280.txt", binWidth,binHeight);
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
