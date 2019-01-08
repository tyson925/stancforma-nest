package com.stancforma.runner;
import java.io.*;

public class Runner {

    public static void main(String[] args) {


        try {
            Process proc = Runtime.getRuntime().exec("ls -l");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
