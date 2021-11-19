package activity;

import entity.Source;
import entity.StartInfo;
import entity.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating data
 */
public class Data {

    /**
     * Method for creating start information from first url
     * @param connection connection with url where we take information
     * @return List of StartInfo
     * @throws IOException can be thrown connection
     */
    public List<StartInfo> makeFirstInfo(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        List<StartInfo> informations = new ArrayList<>();
        String line;
        long id = 0;
        String sourceDataUrl = "";
        String tokenDataUrl = "";
        int counter = 0;
        while ((line = in.readLine()) != null) {
            if(line.contains(":")){
                switch (line.toCharArray()[line.indexOf("\"") + 1]){
                    case 'i':
                        id = Long.parseLong(line.split(":")[1].substring(1, line.split(":")[1].indexOf(',')));
                        counter++;
                        break;
                    case 's':
                        sourceDataUrl = (line.split(":")[1] + ":" + line.split(":")[2]).substring(2, (line.split(":")[1] + ":" + line.split(":")[2]).indexOf(',') - 1);
                        counter++;
                        break;
                    case 't':
                        tokenDataUrl = (line.split(":")[1] + ":" + line.split(":")[2]).substring(2, (line.split(":")[1] + ":" + line.split(":")[2]).lastIndexOf('"'));
                        counter++;
                        break;
                }
                if(counter == 3){
                    informations.add(new StartInfo(id, sourceDataUrl, tokenDataUrl));
                    counter = 0;
                }
            }
        }
        return informations;
    }

    /**
     * Method for creating source information from sourceDataUrl
     * @param connection connection with url where we take information
     * @return Class with source information
     * @throws IOException can be thrown connection
     */
    public Source makeSourceInfo(HttpURLConnection connection) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String urlType = "";
        String videoUrl = "";
        int counter = 0;
        String line;
        while((line = in.readLine()) != null){
            if(line.contains(":")){
                switch (line.toCharArray()[line.indexOf("\"") + 1]){
                    case 'u':
                        urlType = line.split(":")[1].substring(2, line.split(":")[1].indexOf(',') - 1);
                        counter++;
                        break;
                    case 'v':
                        videoUrl = (line.split(":")[1] + ":" + line.split(":")[2]).substring(2, (line.split(":")[1] + ":" + line.split(":")[2]).lastIndexOf('"'));
                        counter++;
                        break;
                }
                if(counter == 2){
                    counter = 0;
                    return new Source(urlType, videoUrl);
                }
            }
        }
        return new Source();
    }

    /**
     * Method for creating token information from tokenDataUrl
     * @param connection connection with url where we take information
     * @return Class with token information
     * @throws IOException can be thrown connection
     */
    public Token makeTokenInfo(HttpURLConnection connection) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String value = "";
        int ttl = 0;
        int counter = 0;
        String line;
        while((line = in.readLine()) != null){
            if(line.contains(":")){
                switch (line.toCharArray()[line.indexOf("\"") + 1]){
                    case 'v':
                        value = line.split(":")[1].substring(2, line.split(":")[1].indexOf(',') - 1);
                        counter++;
                        break;
                    case 't':
                        ttl = Integer.parseInt(line.split(":")[1].substring(1));
                        counter++;
                        break;
                }
                if(counter == 2){
                    counter = 0;
                    return new Token(value, ttl);
                }
            }
        }
        return new Token();
    }
}
