package com.ruyin.code.json.annotation.deserialize;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Zoo {
    private Animal animal;

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public Zoo() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class,name = "dog"),
            @JsonSubTypes.Type(value = Cat.class,name = "cat")
    })
    public class Animal{
        private String name;

        public Animal(){
        }

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Dog extends Animal{
        public double barkVolume;

        public Dog(String lacy) {
            super(lacy);
        }


        public double getBarkVolume() {
            return barkVolume;
        }

        public void setBarkVolume(double barkVolume) {
            this.barkVolume = barkVolume;
        }
    }

    public class Cat extends Animal{
        private boolean likesCream;
        private int lives;

        public boolean isLikesCream() {
            return likesCream;
        }

        public void setLikesCream(boolean likesCream) {
            this.likesCream = likesCream;
        }

        public int getLives() {
            return lives;
        }

        public void setLives(int lives) {
            this.lives = lives;
        }
    }
}
