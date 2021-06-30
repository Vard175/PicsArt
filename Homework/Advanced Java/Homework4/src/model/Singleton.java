package model;

import java.io.Serializable;

public class Singleton implements Serializable
{
    private Singleton()
    {
        // private constructor
    }

    private static class SingletonHelper{
            public static final Singleton INSTANCE = new Singleton();
    }

    // implement readResolve method
    protected Object readResolve()
    {
        return SingletonHelper.INSTANCE;
    }

    public static Singleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}