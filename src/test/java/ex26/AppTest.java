package ex26;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @org.junit.jupiter.api.Test
    void calculateMonthsUntilPaidOff() {
        BigDecimal balance = BigDecimal.valueOf(5000);
        BigDecimal APR = BigDecimal.valueOf(0.12);
        BigDecimal monthlyPayment = BigDecimal.valueOf(100);
        BigDecimal dailyRate = APR.divide(BigDecimal.valueOf(365), 8, RoundingMode.HALF_UP);
        BigDecimal numberOfMonths = BigDecimal.valueOf( (double) -1 / 30)
                .multiply(BigDecimal.valueOf((Math.log10(1 + (balance.doubleValue() / (monthlyPayment.doubleValue()))
                        * (1 - Math.pow(1 + dailyRate.floatValue(), 30))))))
                .divide(BigDecimal.valueOf(Math.log10((BigDecimal.valueOf(1).add(dailyRate))
                        .floatValue())), 0, RoundingMode.CEILING);
        assertEquals(numberOfMonths.intValue(), 70);
    }
}
