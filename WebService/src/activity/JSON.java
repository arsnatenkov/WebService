package activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Camera;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class for JSON serialization
 */
public class JSON {
    /**
     * Method for serialization of List of cameras
     * @param cameras List of cameras
     */
    public void makeJson(List<Camera> cameras){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String result = gson.toJson(cameras);
        try {
            FileWriter writer = new FileWriter("result.json", false);
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
