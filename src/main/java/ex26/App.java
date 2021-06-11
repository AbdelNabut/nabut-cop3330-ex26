/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */

package ex26;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {
    public static BigDecimal calculateMonthsUntilPaidOff(BigDecimal balance, BigDecimal APR, BigDecimal monthlyPayment)
    {
        BigDecimal dailyRate = APR.divide(BigDecimal.valueOf(365), 8, RoundingMode.HALF_UP);
        BigDecimal numberOfMonths = BigDecimal.valueOf( (double) -1 / 30)
                .multiply(BigDecimal.valueOf((Math.log10(1 + (balance.doubleValue() / (monthlyPayment.doubleValue()))
                        * (1 - Math.pow(1 + dailyRate.floatValue(), 30))))))
                .divide(BigDecimal.valueOf(Math.log10((BigDecimal.valueOf(1).add(dailyRate))
                        .floatValue())), 0, RoundingMode.CEILING);
        return numberOfMonths;
    }

    public static void main(String[] args) {
        BigDecimal balance, APR, monthlyPayment;
        Scanner input = new Scanner(System.in);
        System.out.print("What is your balance? ");
        balance = input.nextBigDecimal();
        System.out.print("What the APR on the card (as a percent)? ");
        APR = input.nextBigDecimal();
        APR = APR.divide(BigDecimal.valueOf(100));
        System.out.print("What is the monthly payment you can make? ");
        monthlyPayment = input.nextBigDecimal();
        System.out.println("It will take you " + calculateMonthsUntilPaidOff(balance, APR, monthlyPayment) + " months to pay off this card.");

    }
}

// Double implementation
    /*public static double calculateMonthsUntilPaidOff(double balance, double APR, double monthlyPayment) {
        double dailyRate = APR / 365;
        double numberOfMonths = (double)-1/30
                * (Math.log((1 + (balance/monthlyPayment) * (1 - Math.pow((1 + dailyRate), 30))))
                / Math.log(1 + dailyRate));
        System.out.println(numberOfMonths);
        return (int) numberOfMonths;
    }

    public static void main( String[] args )
    {
        double balance, APR, monthlyPayment;

        Scanner input = new Scanner(System.in);
        System.out.print("What is your balance? ");
        balance = input.nextDouble();
        System.out.println(balance);
        System.out.print("What the APR on the card (as a percent)? ");
        APR = input.nextDouble();
        APR = APR / 100;
        System.out.println(APR);
        System.out.print("What is the monthly payment you can make? ");
        monthlyPayment = input.nextDouble();
        System.out.println(monthlyPayment);
        System.out.println("It will take you " + calculateMonthsUntilPaidOff(balance, APR, monthlyPayment) + " months to pay off this card.");

    }*/