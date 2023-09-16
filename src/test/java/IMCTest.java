import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMCTest {

    @Test
    public void test1() {
        double imc = IMC.calcularImc(60, 160);
        assertEquals(23.44, imc, 0.01);
    }
}