import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

import static jakarta.xml.bind.JAXBContext.newInstance;


public class SerializationService {

    static void serializationJaxb(Human human, File output) {
        try {
            JAXBContext context = newInstance(Human.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(human, output);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static Human deserializationJaxb(File file) {
        Human human = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Human.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            human = (Human) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return human;
    }
}
