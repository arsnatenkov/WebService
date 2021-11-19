package activity;


import entity.Source;
import entity.StartInfo;
import entity.Token;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for connection
 */
public class Connection {
    HttpURLConnection connection = null;

    /**
     * Method for connecting with first url
     * @param query url for connection
     * @return List of start information
     */
    public List<StartInfo> makeFirstConnection(String query) {
        List<StartInfo> informations = new ArrayList<>();
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Data data = new Data();
                informations = data.makeFirstInfo(connection);
                System.out.println("ok");
                return informations;
            } else {
                System.out.println("fall: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
                return informations;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return informations;
    }

    /**
     * Method for connecting with sourceDataUrl
     * @param query url for connection
     * @return Source data
     */
    public Source makeCameraSourceInfoConnection(String query){
        Source source = null;
        try{
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                Data data = new Data();
                source = data.makeSourceInfo(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
        return source;
    }

    /**
     * Method for connecting with tokenUrlData
     * @param query url for connection
     * @return Token data
     */
    public Token makeCameraTokenInfoConnection(String query){
        Token token = null;
        try{
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                Data data = new Data();
                token = data.makeTokenInfo(connection);
                return token;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
        return token;
    }

}
