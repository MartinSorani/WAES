package pageObject.common;

public interface IBasePage {

    void setRelativeUri(String relativeUri);
    String getRelativeUri();
    void assertUrl();
}
