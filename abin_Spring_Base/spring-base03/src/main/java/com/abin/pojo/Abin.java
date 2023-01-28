package com.abin.pojo;

public class Abin {

    private Dog dog;
    private Cat cat;

    @Override
    public String toString() {
        return "Abin{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Abin(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public Abin() {
    }
}
