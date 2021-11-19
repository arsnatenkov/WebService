package activity;

import entity.Camera;
import entity.StartInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONTest {

    @Test
    void makeJson() {
        String query = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";
        Connection connection = new Connection();
        List<StartInfo> results = connection.makeFirstConnection(query);
        JSON json = new JSON();
        List<Camera> cameras = json.makeListOfCamera(results, connection);
        assertEquals("File is ready!", json.makeJson(cameras));
    }

    @Test
    void makeListOfCamera() {
        String query = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";
        Connection connection = new Connection();
        List<StartInfo> results = connection.makeFirstConnection(query);
        JSON json = new JSON();
        assertEquals(4, json.makeListOfCamera(results, connection).size());
    }
}