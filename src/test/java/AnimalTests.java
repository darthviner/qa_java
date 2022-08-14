import com.example.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTests {
    private List<String> expectedGetFood;
    private String expectedGetFamily;
    private String animalKind;
    //@Spy
    private Animal animal;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public AnimalTests(String animalKind, List<String> expectedGetFood, String expectedGetFamily){
        this.animalKind = animalKind;
        this.expectedGetFood = expectedGetFood;
        this.expectedGetFamily = expectedGetFamily;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        List<String> getFoodFirst = List.of("Животные", "Птицы", "Рыба");
        List<String> getFoodSecond = List.of("Трава", "Различные растения");
        return new Object[][]{
                {"Хищник",getFoodFirst,"Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи"},
                {"Травоядное",getFoodSecond,"Тест"}
        };

    }


    @Test
    public void getFoodTest() throws Exception {

        //Animal animal = Mockito.mock(Animal.class);
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals(expectedGetFood,actual);

    }
    @Test
    public void getFamilyTests(){

        //Animal animal = Mockito.mock(Animal.class);
        String actual = animal.getFamily();
        Assert.assertEquals(expectedGetFamily,actual);
    }
}
