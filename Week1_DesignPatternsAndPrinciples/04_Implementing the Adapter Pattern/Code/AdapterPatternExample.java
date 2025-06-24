
interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPalGateway {
    public void makePayment(String userEmail, double amount) {
        System.out.println("PayPal Payment of $" + amount + " made by " + userEmail);
    }
}


class StripeGateway {
    public void sendPayment(String cardNumber, double totalAmount) {
        System.out.println("Stripe Payment of $" + totalAmount + " done using card " + cardNumber);
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String userEmail;

    public PayPalAdapter(String userEmail) {
        this.userEmail = userEmail;
        this.payPalGateway = new PayPalGateway();
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(userEmail, amount);
    }
}


class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    private String cardNumber;

    public StripeAdapter(String cardNumber) {
        this.cardNumber = cardNumber;
        this.stripeGateway = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.sendPayment(cardNumber, amount);
    }
}


public class AdapterPatternExample {
    public static void main(String[] args) {
       
        PaymentProcessor paypal = new PayPalAdapter("user@example.com");
        paypal.processPayment(250.75);

        
        PaymentProcessor stripe = new StripeAdapter("4111-1111-1111-1111");
        stripe.processPayment(450.00);
    }
}
