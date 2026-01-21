import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates = new HashMap<>();

    
    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("INR", 83.20);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.79);
        exchangeRates.put("JPY", 155.30);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Available Currencies: USD, INR, EUR, GBP, JPY");

        System.out.print("Enter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        if (!exchangeRates.containsKey(base) || !exchangeRates.containsKey(target)) {
            System.out.println("Invalid currency selection.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double convertedAmount = convert(base, target, amount);

        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, target);

        sc.close();
    }

    private static double convert(String base, String target, double amount) {
        double baseRate = exchangeRates.get(base);
        double targetRate = exchangeRates.get(target);
        return (amount / baseRate) * targetRate;
    }
}