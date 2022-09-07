package Core.Util;

public class Util {

    public void incremental(){

        String environment = System.getProperty("browserstack");
        if(environment.equalsIgnoreCase("Desktop")){
            System.setProperty("browserstack","1");
        }
    }


    public void incremental1(){

        String environment = System.getProperty("browserstack");
        int a = Integer.parseInt(environment);
        a=a+1;
        System.setProperty("browserstack",String.valueOf(a));
        }
}
