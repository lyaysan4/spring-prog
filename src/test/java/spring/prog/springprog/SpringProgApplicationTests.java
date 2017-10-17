package spring.prog.springprog;

import org.junit.Test;
import spring.prog.springprog.model.Author;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringProgApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void name() throws Exception {
        List<String> authorNames = new ArrayList<>();

        authorNames.add("");
        authorNames.add("");
        authorNames.add("e");
        authorNames.add("d");
        authorNames.add("a");

        List<String> list = authorNames.stream()
                .filter(name -> {
                    boolean empty = !name.isEmpty();
                    System.out.println(empty);
                    return empty;
                })
                .distinct()
                .map(Author::new)
                .sorted(Comparator.comparing(Author::getName))
                .map(Author::getName)
                .collect(toList());
        System.out.println(list);
    }
}
