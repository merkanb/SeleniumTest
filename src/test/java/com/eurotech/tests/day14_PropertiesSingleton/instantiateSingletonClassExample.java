package com.eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class instantiateSingletonClassExample {
    @Test
    public void test() {

//        SingletonClassExample singleton = new SingletonClassExample();

        SingletonClassExample singleton = SingletonClassExample.getInstanceOfSingletonClassExample();
        //output ==>        Creating a SingletonClassExample object
        SingletonClassExample singleton2 = SingletonClassExample.getInstanceOfSingletonClassExample();
        //output ==>        It has already been instantiated, returning existing instance of SingletonClassExample


        // if there is not SingletonClassExample object it will instantiate if there is already one -->  always will assign to it..
        // according to the  SingletonClassExample class  getInstanceOfSingletonClassExample() static method...

    }
}