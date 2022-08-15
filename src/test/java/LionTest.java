import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private Lion lion;
    private Boolean actualResultlionDoesHaveMane;
    private Boolean expectedResultDoesHaveMane;
    private String sex;
    private List<String> expectedgetFoodTest;
    @Mock
    private Feline feline;

    public LionTest(Boolean actualResultlionDoesHaveMane, Boolean expectedResultDoesHaveMane, String sex, List<String> expectedgetFoodTest) {
        this.expectedResultDoesHaveMane = expectedResultDoesHaveMane;
        this.actualResultlionDoesHaveMane = actualResultlionDoesHaveMane;
        this.sex = sex;
        this.expectedgetFoodTest = List.of("Животные", "Птицы", "Рыба");
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] getData() {
        //Lion lion1 = new Lion("Самей")
        return new Object[][]{{true, true, "Самец", List.of("Животные", "Птицы", "Рыба")},
                {false, false, "Самка", List.of("Животные", "Птицы", "Рыба")},
                //{null,null,"блабла",null} //а как протестировать случай с неправильным значением sex?
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void lionDoesHaveManeCorrectValueTest() throws Exception {
        lion = new Lion(sex, feline);
        actualResultlionDoesHaveMane = lion.doesHaveMane();
        Assert.assertEquals("Method doesHaveMane returns incorrect value", expectedResultDoesHaveMane, actualResultlionDoesHaveMane);
    }

    @Test
    public void lionGetKittensCorrectValue() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion = new Lion(sex, feline);
        int actuaResult = lion.getKittens();
        Assert.assertEquals("Method getKittens returns incorrect value", 1, actuaResult);
    }

    @Test
    public void lionGetFoodCorrectValue() throws Exception {
        lion = new Lion(sex, feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(expectedgetFoodTest);
        List<String> actualGetFoodTestResult = lion.getFood();
        Assert.assertEquals("Method getFood returns incorrect value", expectedgetFoodTest, actualGetFoodTestResult);
    }
}
