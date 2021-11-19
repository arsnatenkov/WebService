package activity;

import entity.Source;
import entity.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    @Test
    void makeFirstConnection() {
        String query = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";
        Connection connection = new Connection();
        assertEquals(4, connection.makeFirstConnection(query).size());
    }

    @Test
    void makeCameraSourceInfoConnection() {
        String query = "http://www.mocky.io/v2/5c51b230340000094f129f5d";
        Source source = new Source("LIVE", "rtsp://127.0.0.1/1");
        Connection connection = new Connection();
        assertEquals(source.getUrlType(), connection.makeCameraSourceInfoConnection(query).getUrlType());
        assertEquals(source.getVideoUrl(), connection.makeCameraSourceInfoConnection(query).getVideoUrl());
    }

    @Test
    void makeCameraTokenInfoConnection() {
        String query = "http://www.mocky.io/v2/5c51b5b6340000554e129f7b?mocky-delay=1s";
        Token token = new Token("fa4b588e-249b-11e9-ab14-d663bd873d93", 120);
        Connection connection = new Connection();
        assertEquals(token.getValue(), connection.makeCameraTokenInfoConnection(query).getValue());
        assertEquals(token.getTtl(), connection.makeCameraTokenInfoConnection(query).getTtl());
    }
}