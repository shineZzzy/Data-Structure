package Test.T0118;

import java.util.*;

class Student{
    String name;
    int sco;


    public Student(String name, int sco) {
        this.name = name;
        this.sco = sco;
    }

//    @Override
//    public int compareTo(Student o) {
//        if (flag==0) {
//            return this.sco - o.sco;
//        }else if(flag==1){
//            return o.sco-this.sco;
//        }else {
//            return -01;
//        }
//    }

}
public class findAndSort {
    public static void main(String[] args) {
//        Student s1=new Student("jack",70);
//        Student s2=new Student("peter",96);
//        Student s3=new Student("Tom",70);
//        Student s4=new Student("Smith",69);

        List<Student> l=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int flag=sc.nextInt();
            for (int i=0;i<n;i++) {
                l.add(new Student(sc.next(), sc.nextInt()));
            }
            int ret=0;
            if (flag==0){
                Collections.sort(l, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.sco-o1.sco;
                    }
                });
            }else if(flag==1){
                Collections.sort(l, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.sco-o2.sco;
                    }
                });
            }
            for(int i=0;i<l.size();i++)
            {
                System.out.println(l.get(i).name+" "+l.get(i).sco);
            }
        }
    }
    public  static int compareTo(int flag,Student o1,Student o2){
         if(flag==0){
             return o1.sco-o2.sco;
         }else if(flag==1){
             return o2.sco-o1.sco;
         }else {
             return -1;
         }
    }

}
