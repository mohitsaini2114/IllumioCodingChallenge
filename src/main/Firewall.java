package main;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Firewall {

    Set<Rules> rulesSet;

    public Firewall(String filePath) throws IOException {
        rulesSet = new HashSet<>();

        //read the input file
        readInputFile(filePath);
    }

    private void readInputFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //adding all data from file to Set
        String line;
        while ((line = reader.readLine()) != null) {
            String[] dataFromFile = line.split(",");
            rulesSet.add(new Rules(
                    dataFromFile[0],
                    dataFromFile[1],
                    dataFromFile[2],
                    dataFromFile[3]
            ));
        }

    }

    public boolean accept_packet(String direction, String protocol, int port, String ipAddress) {
        Rules rules = new Rules(direction, protocol, String.valueOf(port), ipAddress);

        //comparing the input data with rules
        for(Rules dataFromSet : rulesSet){
            if(rules.equals(dataFromSet)){
                return true;
            }
        }

       return false;
    }
}
