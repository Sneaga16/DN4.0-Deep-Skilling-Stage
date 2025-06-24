
interface Notifier {
    void send(String message);
}


class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}


class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}


class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}


public class DecoratorPatternExample {
    public static void main(String[] args) {
        
        Notifier basicEmail = new EmailNotifier();
        basicEmail.send("Welcome to the system!");

        System.out.println("\n--- With SMS ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("Your order has been shipped!");

        System.out.println("\n--- With SMS and Slack ---");
        Notifier fullNotification = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        fullNotification.send("System maintenance scheduled at 10 PM.");
    }
}
