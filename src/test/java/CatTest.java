import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import java.util.List;

public class CatTest {
    private Cat cat;
    private Predator predator;
    @Mock
    private Animal animal;
    @Spy
    private Feline feline;

    @Test
    public void getSoundReturnsCorrectValueTest(){
        feline = new Feline();
        cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Method getSound returns incorrec value", "Мяу", actual);
    }
    @Test
    public void getFoodCorrectValueTest() throws Exception {
        feline = new Feline();
        cat = new Cat(feline);
        List<String> array = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Method getFood returns incorrect value",expected,actual);
    }


}
