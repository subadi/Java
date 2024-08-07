package org.example;

import java.util.HashSet;
import java.util.Set;

public class PrimeProduct {
        public static int distinctPrimeFactors(int[] nums) {
            int product = 1;
            for(int num:nums){
                product = product * num;
            }
            System.out.println("Final product: "+product);
            Set<Integer> primeSet = new HashSet<>();
            while(product %2 ==0){
                primeSet.add(2);
                product /= 2;
            }

            for(int i=3;i<Math.sqrt(product);i=i+2){
                while(product%i ==0){
                    primeSet.add(i);
                    product /= i;
                }
            }
            if(product>2){
                primeSet.add(product);
            }
//            for(Integer num:primeSet){
//                System.out.println(num);
//            }
            return primeSet.size();
        }

    public static int distinctPrimeFactors1(int[] nums) {
        Set<Integer> primeSet = new HashSet<>();
        for(int num:nums){
            int i=2;
            while(num>1){
                if(num % i==0){
                    primeSet.add(i);
                    num /= i;
                }else{
                    i++;
                }
            }
        }
        return primeSet.size();
    }



        public static void main(String[] args) {
            int [] nums = {2,14,19,19,5,13,18,10,15,20};
            int distictPrime = distinctPrimeFactors(nums);// this is wrong(3)
            System.out.println(distictPrime);
            int distictPrime1 = distinctPrimeFactors1(nums); // this is correct(6)
            System.out.println(distictPrime1);
        }

}
