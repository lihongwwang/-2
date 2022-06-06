package util;
public class MyUtil {
    public static int getRandomNumber(int min,int max){
        return (int)(Math.random()*(max-min)+min);
    }
}
