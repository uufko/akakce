import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addProductTest extends addProduct {
    @BeforeClass
    public void setDriverTest() {
        setDriver();
    }
    @Test(priority = 1)
    public void goPageTest ()  throws InterruptedException{
        goPage();
    }

    @Test(priority = 2)
    public void loginPageTest() throws InterruptedException {
        loginPage();
    }

    @Test(priority = 3)
    public void searchItemTest() throws InterruptedException{
        searchItem();
    }

    @Test(priority = 4)
    public void getItemListTest() throws InterruptedException{
        getItemList();
    }
    @Test(priority = 5)
    public void addToListTest() throws InterruptedException{
        addToList();
    }


    @Test(priority = 7)
    public void myListPageTest() throws InterruptedException {
        myListPage();
    }


}
