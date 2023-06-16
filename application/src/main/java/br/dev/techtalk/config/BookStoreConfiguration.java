package br.dev.techtalk.config;

import br.dev.techtalk.repository.BookGraphRepository;
import br.dev.techtalk.repository.BookRepository;
import br.dev.techtalk.repository.OrderRepository;
import br.dev.techtalk.service.BookService;
import br.dev.techtalk.service.OrderService;
import br.dev.techtalk.service.GraphService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookStoreConfiguration {

    @Bean
    public BookService createBookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

    @Bean
    public GraphService createGraphService(BookGraphRepository bookGraphRepository) {
        return new GraphService(bookGraphRepository);
    }

    @Bean
    public OrderService createBookStoreService(OrderRepository repository) {
        return  new OrderService(repository);
    }

}
