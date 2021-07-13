package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadVendors() {
        Vendor vendorOne = new Vendor();
        vendorOne.setName("Fun Fresh Fruits Ltd.");

        Vendor vendorTwo = new Vendor();
        vendorTwo.setName("Nuts for Nuts Company");

        vendorRepository.save(vendorOne);
        vendorRepository.save(vendorTwo);

        System.out.println("Vendor Data loaded = " + vendorRepository.count());
    }

    private void loadCustomers() {
        Customer customerOne = new Customer();
        customerOne.setFirstname("sean");
        customerOne.setLastname("hamilton");

        Customer customerTwo = new Customer();
        customerTwo.setFirstname("john");
        customerTwo.setLastname("smith");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customerOne);
        customerList.add(customerTwo);
        customerRepository.saveAll(customerList);

        System.out.println("Customer Data loaded = " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("nuts");

        List<Category> categoryList = new ArrayList<>();

        categoryList.add(fruits);
        categoryList.add(dried);
        categoryList.add(fresh);
        categoryList.add(exotic);
        categoryList.add(nuts);

        categoryRepository.saveAll(categoryList);

        System.out.println("Category Data loaded = " + categoryRepository.count());
    }
}
