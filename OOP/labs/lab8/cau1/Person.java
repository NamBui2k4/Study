
public class Person {
   protected String name;
   protected int birthYear;

   public Person(String name, int birthYear) {
    this.name = name;
    this.birthYear = birthYear;
}

public void setName(String name) {
    this.name = name;
}

public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
}

public String getName() {
    return name;
}

public int getBirthYear() {
    return birthYear;
}

@Override
public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", birthYear=" + birthYear +
            '}';
}

}