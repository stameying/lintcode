package EPI.sorting;

import java.util.*;

/**
 * Created by stameying on 2/2/16.
 */
public class sortStudentsAge {

    private static class Person implements Comparable<Person>{
        public Integer age;
        public String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }


        // hash function for Person
        @Override
        public int hashCode() {return Objects.hash(age,name);}

        @Override
        public int compareTo(Person p){
            return Integer.compare(this.age,p.age);
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof Person)) return false;
            return this==obj?true:((Person)obj).age.equals(this.age);
        }
    }


    public static void groupByAge(List<Person> people){
        Map<Integer,Integer> ageToCount = new HashMap<>();
        for (Person p: people){
            if (ageToCount.containsKey(p.age)){
                ageToCount.put(p.age,ageToCount.get(p.age)+1);
            }else{
                ageToCount.put(p.age,1);
            }
        }

        Map<Integer,Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer,Integer> kc: ageToCount.entrySet()){
            ageToCount.put(kc.getKey(),offset);
            offset+=kc.getKey();
        }

        while (!ageToOffset.isEmpty()){
            Map.Entry<Integer,Integer> from = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people,from.getValue(),toValue);
            Integer count = ageToCount.get(toAge)-1;
            ageToCount.put(toAge,count);
            if (count > 0){
                ageToOffset.put(toAge,toValue+1);
            }else{
                ageToOffset.remove(toAge);
            }
        }
    }

    public static void main(String[] args) {


    }
}
