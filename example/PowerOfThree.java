package org.example;

public class PowerOfThree {
    public static void main(String[] args) {
        int num = 27;
        isPowerOfThree(num);
    }
    public static boolean isPowerOfThree(int num) {
        boolean isPower = false;
        if(num<=0)
            return false;
        if(num==1)
            return true;
        while(num>1){
            if(num%3==0){ //change to 10, if want to check for power of 10
                num = num/3;
            }else{
                return false;
            }
        }
        return num == 1;

    }
}
