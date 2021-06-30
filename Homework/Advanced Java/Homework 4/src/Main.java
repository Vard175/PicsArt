/**
 * when singleton is designed using enums there  sno serialization problem
 * I used Bill Pugh singleton
 * here is the solution
 **/

import model.Singleton;
import service.SingletonService;


public class Main {
    public static void main(String[] args) {
            Singleton instance1 = Singleton.getInstance();
            SingletonService.serialize(instance1);
            Singleton instance2 = SingletonService.deserialize();

            System.out.println("instance1 hashCode:     " + instance1.hashCode());
            System.out.println("instance2 hashCode:     " + instance2.hashCode());
    }
}
