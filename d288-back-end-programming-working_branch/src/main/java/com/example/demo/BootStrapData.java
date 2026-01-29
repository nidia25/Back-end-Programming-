package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //five sample customers
        if(customerRepository.count() == 1) {
            Customer kylo = new Customer();
            kylo.setFirstName("Kylo");
            kylo.setLastName("Lara");
            kylo.setAddress("123 Little Street");
            kylo.setPhone("2222222");
            kylo.setPostal_code("79938");
            kylo.setDivision(divisionRepository.getReferenceById(22L));

            customerRepository.save(kylo);

            Customer gio = new Customer();
            gio.setFirstName("Gio");
            gio.setLastName("Lara");
            gio.setAddress("432 Big Street");
            gio.setPhone("7654321");
            gio.setPostal_code("79912");
            gio.setDivision(divisionRepository.getReferenceById(17L));

            customerRepository.save(gio);

            Customer nova = new Customer();
            nova.setFirstName("Nova");
            nova.setLastName("Sterling");
            nova.setAddress("567 Unicorn Street");
            nova.setPhone("1234567");
            nova.setPostal_code("55555");
            nova.setDivision(divisionRepository.getReferenceById(101L));

            customerRepository.save(nova);

            Customer patrick = new Customer();
            patrick.setFirstName("Patrick");
            patrick.setLastName("Star");
            patrick.setAddress("234 Rock Street");
            patrick.setPhone("9999999");
            patrick.setPostal_code("79936");
            patrick.setDivision(divisionRepository.getReferenceById(5L));

            customerRepository.save(patrick);

            Customer nidia = new Customer();
            nidia.setFirstName("Nidia");
            nidia.setLastName("Aguirre");
            nidia.setAddress("222 Beacham Street");
            nidia.setPhone("1687102");
            nidia.setPostal_code("44444");
            nidia.setDivision(divisionRepository.getReferenceById(25L));

            customerRepository.save(nidia);
        }
    }
}



