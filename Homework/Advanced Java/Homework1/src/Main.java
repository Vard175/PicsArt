import models.Car;
import models.Human;
import services.SerializationService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src//human.xml");
        Human human1 = new Human("Ann", 42, new Car("bmw", 2001));
        SerializationService.serializationJaxb(human1, file);
        Human human2 = SerializationService.deserializationJaxb(file);
        System.out.println(human2);
    }

    /*
    * some useful links
    * https://www.geeksforgeeks.org/java-program-to-extract-content-from-a-xml-document/
    * https://www.geeksforgeeks.org/java-architecture-for-xml-binding-jaxb-set-1/
    * https://www.geeksforgeeks.org/difference-between-sax-parser-and-dom-parser-in-java/
    * */
}
