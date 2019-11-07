package main;

public class Ports {

    private int startingPort;
    private int endingPort;

    public Ports(String ports){
        if(ports.indexOf('-') != -1){
            String[] splitPorts = ports.split("-");
            startingPort = Integer.parseInt(splitPorts[0]);
            endingPort = Integer.parseInt(splitPorts[1]);

        }else{
            startingPort = Integer.parseInt(ports);
            endingPort = Integer.parseInt(ports);
        }
    }

    public boolean inPortRange(Ports port) {
        return port.startingPort >= this.startingPort && port.endingPort <= this.endingPort;
    }

}
