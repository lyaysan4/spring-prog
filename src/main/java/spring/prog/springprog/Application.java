package spring.prog.springprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(BookRepository repository){
//		return (args) -> {
//			repository.save(new Book("book1","auth1"));
//			repository.save(new Book("book2","auth2"));
//			repository.save(new Book("book3","auth3"));
//			repository.save(new Book("book4","auth4"));
//			repository.save(new Book("book5","auth5"));
//
//			log.info("Books found with findAll():");
//			log.info("---------------------------");
//			for (Book book : repository.findAll()) {
//				log.info(book.toString());
//			}
//			log.info("");
//
//			Book book = repository.findOne(1L);
//			log.info("Book found with findOne(1L):");
//			log.info("----------------------------");
//			log.info(book.toString());
//			log.info("");
//
//			log.info("Books found by findByAuthor('auth1'):");
//			log.info("-------------------------------------");
//			for (Book bb : repository.findByAuthor("auth1")) {
//				log.info(bb.toString());
//			}
//			log.info("");
//		};
//	}
}
