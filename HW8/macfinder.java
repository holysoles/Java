package MYCODE.HW8;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Written by Patrick Evans on 3/19/2019
 * Script to collect all of a local machine's MAC addresses
 * Credit to Dr. Lyon's StreamGobbler class for collecting input from a bash command
 */

public class macfinder extends Thread {
    public static void main(String[] args) throws IOException {
        //Run bash command "ipconfig /all"
        String cmd = "ipconfig /all";
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(cmd);

        //Collect output from bash
        BufferedReader outputGobbler = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        //Declare Array List so that it can be append with each MAC address, without predetermining size
        List<String> macList = new ArrayList<String>();

        //Loop to parse and split the output from the bash command results, and append each address
        while (true) {
            String dataRead = outputGobbler.readLine();
            String searchtext = "Physical Address";
            if (dataRead == null)
                break;
            if (dataRead.contains(searchtext)) {
                String[] inData = dataRead.split(" ");
                int i = 0;
                while (i < inData.length){
                    if (inData[i].contains("-")) {
                        macList.add(inData[i]);
                    }
                    i++;
                }
            }
        }
        //Print list of device's MAC addresses
        System.out.println("The local device MAC addresses are:" + macList);
    }
}
