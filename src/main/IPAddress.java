package main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPAddress {

    private long startingIP;
    private long endingIP;

    public IPAddress(String ipString){
        if(ipString.indexOf('-') != -1){
            String[] ranges = ipString.split("-");
            startingIP = Long.parseLong(ranges[0].replaceAll("\\.", ""));
            endingIP = Long.parseLong(ranges[1].replaceAll("\\.", ""));

        }else{
            startingIP = Long.parseLong(ipString.replaceAll("\\.", ""));
            startingIP = Long.parseLong(ipString.replaceAll("\\.", ""));
        }
    }

    public boolean inIpRange(IPAddress inputIp) {
        return inputIp.startingIP >= this.startingIP && inputIp.endingIP <= this.endingIP;
    }

}
