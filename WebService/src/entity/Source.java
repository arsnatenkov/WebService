package entity;

public class Source {
    private String urlType;
    private String videoUrl;


    public Source(String urlType, String videoUrl) {
        this.urlType = urlType;
        this.videoUrl = videoUrl;
    }

    public Source() {

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
}
