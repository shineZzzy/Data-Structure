package Tom;

public class spy extends Person implements spySkill,Teacher,Driver {
    @Override
    public void drive() {
        System.out.println("Tom is Driving");
    }

    @Override
    public void teach() {
        System.out.println("Tom is Teaching");
    }

    @Override
    public void stealInfo() {
        System.out.println("Tom is stealInfo");
    }

    @Override
    public void crackingPasswords() {
        System.out.println("Tom is cracking");

    }
    public void userComputer(){
        System.out.println("Tom is Playing Computer");
    }
}
