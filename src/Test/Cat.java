package Test;

import java.util.Objects;

public class Cat implements Comparable {
private int x;
private  String name;

    public Cat(int x, String name) {
        this.x = x;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void change(int y){
        y += 10;
    }

    public static void main(String[] args) {
        Cat cat = new Cat(1);
        int y = 5;
        cat.change(y);
        System.out.println(y);
        System.out.println(cat.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return x == cat.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "x=" + x +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
