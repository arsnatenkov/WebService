package entity;

public class StartInfo {
    private Long id;
    private String sourceDataUrl;
    private String tokenDataUrl;

    public StartInfo(Long id, String sourceDataUrl, String tokenDataUrl) {
        this.id = id;
        this.sourceDataUrl = sourceDataUrl;
        this.tokenDataUrl = tokenDataUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceDataUrl() {
        return sourceDataUrl;
    }

    public void setSourceDataUrl(String sourceDataUrl) {
        this.sourceDataUrl = sourceDataUrl;
    }

    public String getTokenDataUrl() {
        return tokenDataUrl;
    }

    public void setTokenDataUrl(String tokenDataUrl) {
        this.tokenDataUrl = tokenDataUrl;
    }
}
