package main;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class FirewallTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Firewall.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    Firewall firewall;

    @Before
    public void setUp() throws IOException {
        firewall = new Firewall("input.csv");
    }

    @Test
    public void test1() {
        assertEquals(true, firewall.accept_packet("inbound", "udp", 53, "192.168.2.1"));
    }

    @Test
    public void test2() {
        assertEquals(true, firewall.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
    }

    @Test
    public void test3() {
        assertEquals(false, firewall.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
    }

    @Test
    public void test4() {
        assertEquals(false, firewall.accept_packet("inbound", "udp", 24, "52.12.48.92"));
    }

}
