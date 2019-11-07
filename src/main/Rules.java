package main;

public class Rules {

    private String direction;
    private String protocol;
    private Ports port;
    private IPAddress ipAddress;

    public Rules(String direction, String protocol, String port, String ipAddress){
        this.direction = direction;
        this.protocol = protocol;
        this.port = new Ports(port);
        this.ipAddress = new IPAddress(ipAddress);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Rules inputRule = (Rules) obj;

        return (
                inputRule.direction.equals(this.direction) &&
                        inputRule.protocol.equals(this.protocol) &&
                        inputRule.port.inPortRange(this.port) &&
                        inputRule.ipAddress.inIpRange(this.ipAddress)
        );
    }
}
