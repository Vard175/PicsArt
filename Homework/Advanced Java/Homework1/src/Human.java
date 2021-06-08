import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Human {
    private String name;
    private int age;
    @XmlTransient
    private Car car;

    public String getName() {
        return name;
    }
    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Human() {
    }

    public Human(String name, int age, Car car) {
        setAge(age);
        setName(name);
        setCar(car);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", car=" + car +
                '}';
    }
}
