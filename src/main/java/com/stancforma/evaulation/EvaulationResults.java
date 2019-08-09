package com.stancforma.evaulation;

import java.io.*;

public class EvaulationResults {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.csv"),"UTF-8"));
writer.write("fileName,140,slicerTime,nestTime,allTime,280,slicerTime,nestTime,allTime,420,slicerTime,nestTime,allTime,560,slicerTime,nestTime,allTime,700,slicerTime,nestTime,allTime,\n");
            for (File dxfFile : new File("./data/stancCikk/data").listFiles()) {

                if (dxfFile.getName().endsWith("gumi.dxf")) {
                    System.out.println(dxfFile);
                    writer.write(dxfFile.getName()+",");
                    String outLine = "";
                    for (int minArea : new Integer[]{140, 280, 420, 560, 700}) {

                        String slicedDataFileName = dxfFile.getName() + "_" + minArea + ".txt";
                        int numberOfELements = getNumberOfElements("./data/stancCikk/descriptions/" + slicedDataFileName);
                        Double runTime = getRunTime("./data/stancCikk/times/" + dxfFile.getName() + "_" + minArea + "_time.txt");
                        Double nestRunTime = getRunTime("./data/stancCikk/nestTime_old3/" + slicedDataFileName + "_time.txt");
                        Double allRunTime = runTime+nestRunTime;
                        //System.out.println();
                        outLine += numberOfELements + "," + runTime +"," +nestRunTime+","+allRunTime+",";
                    }
                    writer.write(outLine+"\n");
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Integer getNumberOfElements(String fileName) throws IOException {

        if (!new File(fileName).exists()){
            System.out.println("missing file: "+fileName);
            return -1;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        int numberOfElements = 0;

        String line = null;

        while ((line = reader.readLine()) != null) {
            if (line.length() > 5) {
                numberOfElements++;
            }
        }
        return numberOfElements;

    }

    public static Double getRunTime(String fileName) throws IOException {

        if (!new File(fileName).exists()){
            return 1.0;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        return Double.parseDouble(reader.readLine());


    }
}
