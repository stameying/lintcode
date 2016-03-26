package src.CodeRound3;

/**
 * Created by stameying on 3/25/16.
 */
public class test3 {

//    class Person{
//        String firstName;
//        String lastName;
//    }
    public static class Person implements Comparable<Person>{
        public String first;
        public String second;

    public Person(String first, String secnod) {
        this.first = first;
        this.second = secnod;
    }

    @Override
        public int compareTo(Person o) {
//            return first.compareTo(secnod) + secnod.compareTo(first);
        return second.compareTo(o.second) + first.compareTo(o.first);
        }
    }


    public static void main(String[] args) {
        Person p1 = new Person("xiaoran","hu");
        Person p2 = new Person("tianming","li");
        System.out.println(p1.compareTo(p2));
    }
}
