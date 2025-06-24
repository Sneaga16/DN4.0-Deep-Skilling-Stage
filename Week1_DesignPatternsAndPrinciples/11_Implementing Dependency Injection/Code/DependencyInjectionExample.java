
interface CustomerRepository {
    Customer findCustomerById(int id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        
        return new Customer(id, "Sneha", "sneha@example.com");
    }
}


class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("📇 Customer Details:");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
        System.out.println("---------------------------");
    }
}


class CustomerService {
    private CustomerRepository repository;

    
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomer(int id) {
        Customer customer = repository.findCustomerById(id);
        customer.displayInfo();
    }
}


public class DependencyInjectionExample {
    public static void main(String[] args) {
       
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        
        service.showCustomer(101);
    }
}
