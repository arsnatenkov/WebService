package entity;

public class Token {
    private String value;
    private int ttl;

    public Token(String value, int ttl) {
        this.value = value;
        this.ttl = ttl;
    }

    public Token() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
}
