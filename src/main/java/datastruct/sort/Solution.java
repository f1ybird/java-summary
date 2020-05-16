package datastruct.sort;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Set<School> schools = new TreeSet<School>();
        School s1=new School("A");
        School s2=new School("B");
        schools.add(s1);
        schools.add(s2);

        for (School s : schools) {
            System.out.println(s.getName());
        }
    }

    static class School implements Comparable{
        private String name;
        public School(String name){
            this.name=name;
        }

        public String getName(){
            return this.name;
        }


        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}