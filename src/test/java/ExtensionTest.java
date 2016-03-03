

import org.junit.Rule;
import org.junit.Test;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilders;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.test.server.HTTP;

import java.io.File;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * Created by laeg on 03/03/2016.
 */
public class ExtensionTest {

    @Rule
    public Neo4jRule neo4j = new Neo4jRule()
            .withFixture("CREATE (p:Person {name: 'Nicole'})")
            .withFixture("CREATE (p:Person {name: 'Mark'})")
            .withExtension("/extensionTest", "com.gbgplc");


    @Test
    public void shouldReturnOnline()
    {
        URI serverURI = neo4j.httpsURI();

        HTTP.Response res = HTTP.GET(serverURI.resolve("/extensionTest/alive").toString());
        System.out.println(res.toString());

    }

}
