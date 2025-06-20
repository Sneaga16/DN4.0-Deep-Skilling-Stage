import java.util.HashMap;
import java.util.Map;
public class ForecastTool {
    public static double calculateRecursive(double baseAmount, double growthRate, int period) {
        if (period == 0) {
            return baseAmount;
        }
        return calculateRecursive(baseAmount, growthRate, period - 1) * (1 + growthRate);
    }
    public static double calculateWithMemo(double baseAmount, double growthRate, int period, Map<Integer, Double> cache) {
        if (period == 0) return baseAmount;

        if (cache.containsKey(period)) {
            return cache.get(period);
        }
        double computedValue = calculateWithMemo(baseAmount, growthRate, period - 1, cache) * (1 + growthRate);
        cache.put(period, computedValue);
        return computedValue;
    }
    public static double calculateIterative(double baseAmount, double growthRate, int period) {
        double result = baseAmount;
        for (int i = 1; i <= period; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
    public static void main(String[] args) {
        double initialInvestment = 1200.0;
        double annualGrowth = 0.07; 
        int yearsAhead = 8;
        double futureValueRecursive = calculateRecursive(initialInvestment, annualGrowth, yearsAhead);
        System.out.printf("Future value (recursive): %.2f%n", futureValueRecursive);
        Map<Integer, Double> memo = new HashMap<>();
        double futureValueMemo = calculateWithMemo(initialInvestment, annualGrowth, yearsAhead, memo);
        System.out.printf("Future value (memoized): %.2f%n", futureValueMemo);
        double futureValueIterative = calculateIterative(initialInvestment, annualGrowth, yearsAhead);
        System.out.printf("Future value (iterative): %.2f%n", futureValueIterative);
    }
}
