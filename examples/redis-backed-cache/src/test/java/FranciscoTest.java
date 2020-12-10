import com.mycompany.cache.Cache;
import com.mycompany.cache.RedisBackedCache;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

import java.util.Optional;

import static org.rnorth.visibleassertions.VisibleAssertions.assertEquals;
import static org.rnorth.visibleassertions.VisibleAssertions.assertFalse;
import static org.rnorth.visibleassertions.VisibleAssertions.assertTrue;

/**
 * Integration test for Redis-backed cache implementation.
 */
public class FranciscoTest {
    @Rule
    public GenericContainer<?> francisco = new GenericContainer<>(DockerImageName.parse("franciscocodefresh/private-redis:1.0.1"))
                                            .withExposedPorts(6379);

    // private Cache cache;

    // @Before
    // public void setUp() throws Exception {
    //     Jedis jedis = new Jedis(redis.getContainerIpAddress(), redis.getMappedPort(6379));

    //     cache = new RedisBackedCache(jedis, "test");
    // }

    // @Test
    // public void testFindingAnInsertedValue() {
    //     cache.put("foo", "FOO");
    //     Optional<String> foundObject = cache.get("foo", String.class);1

    //     assertTrue("When an object in the cache is retrieved, it can be found",
    //                     foundObject.isPresent());
    //     assertEquals("When we put a String in to the cache and retrieve it, the value is the same",
    //                     "FOO",
    //                     foundObject.get());
    // }

    // @Test
    // public void testNotFindingAValueThatWasNotInserted() {
    //     Optional<String> foundObject = cache.get("bar", String.class);

    //     assertFalse("When an object that's not in the cache is retrieved, nothing is found",
    //             foundObject.isPresent());
    //}

    // @Rule
    // public GenericContainer<?> francisco = new GenericContainer<>(DockerImageName.parse("franciscocodefresh/simple-web-app:c88df35"))
    //                                         .withExposedPorts(80);

    @Test
    public void franciscoTest() {
        assertFalse("should be false", false);
    }   

}

