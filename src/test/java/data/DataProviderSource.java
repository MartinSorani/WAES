package data;

import org.testng.annotations.DataProvider;

public class DataProviderSource {
    @DataProvider(name = "usersDetails")
    public static Object[][] usersDataSets() {
        return new Object[][] {{"admin", "hero", "Amazing Admin"}, {"dev", "wizard", "Zuper Dooper Dev"}, {"tester", "maniac", "Al Skept-Cal Tester"}};
    }

    @DataProvider(name = "badLogin")
    public static Object[][] userNotExistent(){
        return new Object[][]{{"badUsername","wrongPassword"}};
    }
}
