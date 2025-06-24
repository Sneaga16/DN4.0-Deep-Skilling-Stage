import java.util.*;

// Step 1 & 2: Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double newPrice) {
        System.out.println("\nStock price updated for " + stockName + ": " + price + " → " + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    public String getStockName() {
        return stockName;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

// Step 4: Observer Interface
interface Observer {
    void update(String stockName, double newPrice);
}

// Step 5: Concrete Observer - Mobile App
class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("MobileApp [" + user + "] → " + stockName + " is now $" + newPrice);
    }
}

// Step 5: Concrete Observer - Web App
class WebApp implements Observer {
    private String dashboardId;

    public WebApp(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("WebApp [Dashboard: " + dashboardId + "] → " + stockName + " updated to $" + newPrice);
    }
}

// Step 6: Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket tesla = new StockMarket("TESLA", 720.00);

        Observer mobileUser = new MobileApp("John");
        Observer webDashboard = new WebApp("DASH_001");

        tesla.registerObserver(mobileUser);
        tesla.registerObserver(webDashboard);

        tesla.setPrice(735.50);  // both observers notified
        tesla.setPrice(745.25);  // both again

        tesla.removeObserver(webDashboard);  
        tesla.setPrice(750.00);  
    }
}
