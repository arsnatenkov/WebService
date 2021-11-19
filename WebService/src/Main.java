import activity.Connection;
import activity.JSON;
import entity.Camera;
import entity.Source;
import entity.StartInfo;
import entity.Token;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String query = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";
        Connection connection = new Connection();
        List<StartInfo> results = connection.makeFirstConnection(query);
        JSON json = new JSON();
        List<Camera> cameras = json.makeListOfCamera(results, connection);
        System.out.println(json.makeJson(cameras));
    }
}
