package Test;

public class TestSome {

    public static void main(String[] args) {

        int x = 7;
        incrementNumber(x);
        System.out.println(x);

        Cat cat = new Cat(7);
        catLevelUp(cat);
        System.out.println(cat.getX());

    }

    public static void catLevelUp(Cat cat) {

        cat.setX(cat.getX()+1);
    }

    public static void incrementNumber(int x) {
        x++;
    }
}
