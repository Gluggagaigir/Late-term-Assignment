package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testEmptyString(){
        assertEquals(0, TicTacToe.add("")));
    }

}