package Chap3;

/* A class representing an animal adopted at a center. The order of an Animal is the number representing
*  when they entered the center. */
public abstract class Animal {
    private int order;
    String name;

    public Animal(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}