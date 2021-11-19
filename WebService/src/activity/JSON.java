package activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Camera;
import entity.Source;
import entity.StartInfo;
import entity.Token;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for JSON serialization
 */
public class JSON {
    /**
     * Method for serialization of List of cameras
     * @param cameras List of cameras
     */
    public String makeJson(List<Camera> cameras){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String result = gson.toJson(cameras);
        try {
            FileWriter writer = new FileWriter("result.json", false);
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "It's problem!";
        }
        return "File is ready!";
    }
    public List<Camera> makeListOfCamera(List<StartInfo> results, Connection connection){
        List<Camera> cameras = new ArrayList<>();
        for (var result:results) {
            Source source = connection.makeCameraSourceInfoConnection(result.getSourceDataUrl());
            Token token = connection.makeCameraTokenInfoConnection(result.getTokenDataUrl());
            cameras.add(new Camera(result.getId(), source, token));
        }
        return cameras;
    }
}
