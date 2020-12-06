package Tom;

public class spyDemo {
    public static void main(String[] args) {
        Person p=new spy();
        p.setAge(30);
        p.setName("Tom");
        p.setGender("M");

        if(p instanceof spySkill){
            spySkill spyer=(spySkill) p;
            spyer.stealInfo();
            spyer.crackingPasswords();
        }
        if(p instanceof Driver){
            Driver driver=(Driver)p;
            driver.drive();
        }
        if(p instanceof Teacher){
            Teacher teacher=(Teacher)p;
            teacher.teach();
        }
    }
}
