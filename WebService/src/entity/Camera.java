package entity;


public final class Camera {
    private Long id;
    private String urlType;
    private String videoUrl;
    private String value;
    private int ttl;


    public Camera(Long id, Source source, Token token) {
        this.id = id;
        this.urlType = source.getUrlType();
        this.videoUrl = source.getVideoUrl();
        this.value = token.getValue();
        this.ttl = token.getTtl();
    }

    public Camera() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
