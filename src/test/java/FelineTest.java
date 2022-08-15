import com.example.Feline;
import com.sun.jdi.PrimitiveValue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import java.util.PrimitiveIterator;

@RunWith(Parameterized.class)
public class FelineTest {
    private Feline feline;
    private int getKittensParameter;


    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][]{{1}, {2}, {3}};
    }

    public FelineTest(int getKittensParameter) {
        this.getKittensParameter = getKittensParameter;
    }

    @Test
    public void eatMeatCorrectValueTest() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        feline = new Feline();
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Method eatMeat returns incorrect value", actual, actual);
    }

    @Test
    public void getFamilyCorrectValue() {
        feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals("Method getFamily returns incorrect values", expected, actual);
    }

    @Test
    public void getKittensCorrectValueWithoutParameters() {
        feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals("Method getKittens returns incorrect value", expected, actual);
    }

    @Test
    public void getKittensCorrectValuesWithParameters() {
        feline = new Feline();
        int actual = feline.getKittens(getKittensParameter);
        Assert.assertEquals("Method getKittens returns incorrect value", getKittensParameter, actual);
    }
}
