package pl.sda.rekiny.auctionservice.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.rekiny.auctionservice.api.model.Customer;
import pl.sda.rekiny.auctionservice.api.repository.CustomerEntity;
import pl.sda.rekiny.auctionservice.api.repository.CustomerRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<Customer> findByLogin(String login) {
        return customerRepository.findByLogin(login).map(this::toCustomer);
    }

    public void create(Customer customer) {
        customerRepository.save(CustomerEntity.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .login(customer.getLogin())
                .password(customer.getPassword())
                .role(customer.getRole())
                .build());
    }

    //todo add update Customer and delete Customer

    public Customer getById(Long id){
        return  toCustomer(customerRepository.getById(id));
    }

    private Customer toCustomer(CustomerEntity entity) {
        return Customer.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }
}
