package com.eurotech.tests.day14_PropertiesSingleton;

public class SingletonClassExample {// Utilities package Driver class is a sample of Singleton Pattern ....

    private static SingletonClassExample instanceOfSingletonClassExample;       // just instantiation, private, instance

    private SingletonClassExample() {          // encapsulate Constructor, avoid to instantiating an instance from outside of this class
        System.out.println("Creating a SingletonClassExample object");
        // if instance is new creating, will use constructor and we will face this output,
        // because below at getInstance... method it is calling this Constructor as usual
    }

    public static SingletonClassExample getInstanceOfSingletonClassExample() {
        if (instanceOfSingletonClassExample == null) {
            instanceOfSingletonClassExample = new SingletonClassExample();      // if not assigned before here it is assigning
        } else {
            System.out.println("It has already been instantiated, returning existing instance of SingletonClassExample");
        }
        return instanceOfSingletonClassExample;
    }

}