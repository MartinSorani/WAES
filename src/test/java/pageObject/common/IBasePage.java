package src.test.java.pageObject.common;

import org.openqa.selenium.support.ui.ExpectedCondition;

public interface IBasePage {

    void setRelativeUri(String relativeUri);
    String getRelativeUri();
    void assertUrl();
    IBasePage assertThat(ExpectedCondition<Boolean> condition);
}
