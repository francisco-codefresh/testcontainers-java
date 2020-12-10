package org.testcontainers.containers;
//import org.junit.*;
import org.junit.Test;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.Socket;


public class MongoDbContainerTest {
    public String hilera;
    // @Rule
    // public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
    //                                     .withExposedPorts(6379);
    // @Before
    // public void setUp() {
    //     String address = redis.getHost();
    //     Integer port = redis.getFirstMappedPort();

    //     // Now we have an address and port for Redis, no matter where it is running
    //     hilera = address + port;
    // }

    @Test
    public void testSimplePutAndGet() {
        try (GenericContainer container = new GenericContainer(DockerImageName.parse("franciscocodefresh/multistag:latest")).withExposedPorts(6379)) {
            container.start();
            hilera="something";
            Thread.sleep(10000);
            hilera.equals(hilera);
        } catch(InterruptedException e) {
             // this part is executed when an exception (in this example InterruptedException) occurs
             hilera=hilera+"error";
        }

    }

    @Test
    public void containerStartsAndPublicPortIsAvailable() {
        try (MongoDbContainer container = new MongoDbContainer(DockerImageName.parse("mongo:4.0"))) {
            container.start();
            assertThatPortIsAvailable(container);
        }
    }

    private void assertThatPortIsAvailable(MongoDbContainer container) {
        try {
            new Socket(container.getContainerIpAddress(), container.getPort());
        } catch (IOException e) {
            throw new AssertionError("The expected port " + container.getPort() + " is not available!");
        }
    }

}
