package com.bootcoding.user.utils;

public class Application {
    // You make your own class as Singleton Class

    static {
        System.out.println("Sabse pehle call hote hai");
    }

    private static Application application = null;
    public Application(){

    }

    public static Application getInstance(){
        if(null == application) {
            application = new Application();
        }
        return application;
    }

    public void test(){
        System.out.println("I am test");
    }


}
