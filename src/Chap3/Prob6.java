package Chap3;

import java.util.LinkedList;


public class Prob6 {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enque(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dog;
        } else {
            return cat;
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}
