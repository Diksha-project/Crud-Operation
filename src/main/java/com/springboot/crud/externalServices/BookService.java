package com.springboot.crud.externalServices;

import com.springboot.crud.entity.Book;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@FeignClient(name = "BOOK-SERVICE", url = "http://localhost:8081")
public interface BookService {
    //http://localhost:8081/book/getAllBook

    @GetMapping("/book/getAllBook")
    List<Book> getAllBook();
}

