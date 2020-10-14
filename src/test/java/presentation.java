import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class presentation {

    /*
     * Input: [1,2,3,4,5,6,7] and k = 3
     *Output: [5,6,7,1,2,3,4]
     */

    public static boolean[] arrayPrime(int[] num){

        boolean[] arrPrm = new boolean[num.length];

        OUTHERLOOP:
        for(int i=0; i<num.length; i++){
            INNERLOOP:
            for(int a=2;a<num[i];a++){
                if(num[i]%a==0){
                    arrPrm[i] = false;
                    continue OUTHERLOOP;
                }else {
                    arrPrm[i]=true;
                }
            }
        }
        return arrPrm;
    }

    public static int way2(int num){

        int reverse = 0;
        while (num != 0){
            reverse *=10;
            reverse +=num%10;
            num /=10;
        }
        return reverse;
    }
    // 0 1 1 2 3 5 8 13 ......
    public static void fibonnaci(){

        int firstNum = 0;
        int secondNum = 1;
        int count = 0;

        System.out.println(firstNum);
        System.out.println(secondNum);

        for(int i=0; i<100;){

            i = firstNum+secondNum;
            firstNum = secondNum;
            secondNum = i;

            if(i<100){
                System.out.println(i);
                count++;
            }
        }
        System.out.println("There are "+ count+" Fibonacci number before 100.");
    }

    public static boolean perfectNumber(int number){

        boolean result = false;
        int sum = 0;

        for(int i=1; i<number/2;i++){
            if(number%i==0){
                sum+=i;
                System.out.println(i);
            }
        }

        if(number == sum){
            result = true;
            System.out.println(number + " is perfect number");
            return result;
        }

        System.out.println(number + " is not perfect number");
        return  result;
    }

    public static int[] sumOfArray(){

        int[] arr = {3456, 2678, 8866, 6779};

        int[] arr2 =new int[arr.length];

        for(int i=0; i<arr.length;i++){
            int sum = 0;
            for(;arr[i]!=0;){
                sum+=arr[i]%10;
                arr[i]/=10;
            }
            arr2[i]=sum;
        }
        return arr2;
    }

    public static Boolean polindrome(String string){

        Boolean result = false;
        String str = "";

        StringBuilder stb = new StringBuilder(string);
        stb.reverse();

  //      str = stb.toString();
        str = ""+stb;

        if(string.equalsIgnoreCase(str)){
            result = true;
        }
        return result;
    }

    public static void reverseArray(){

        String [] strArr = {"David","Anthony","Naveen","Kumar"};

        String[] rewArr = new String[strArr.length];

        for(int i=0; i<strArr.length;i++){
            String reverseStr = "";
            int length = strArr[i].length()-1;
            for(;0<=length; length--){
                reverseStr += strArr[i].charAt(length);
            }
            rewArr[i] = reverseStr;
        }
        System.out.println(Arrays.toString(rewArr));
    }

    public static int[] sortWithoutSortMethod(int [] numbers){

        for(int i=0; i<numbers.length;i++){
            for(int k=i+1; k<numbers.length;k++){
                if(numbers[i]<numbers[k]){
                    int temp = numbers[i];
                    numbers[i]= numbers[k];
                    numbers[k] = temp;
                }
            }
        }
        return numbers;
    }

    public static void countLetter(String str){

        Map<Character , Integer> map = new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int number = map.get(str.charAt(i));
                map.replace(str.charAt(i),++number);
            }else {
                map.put(str.charAt(i),1);
            }
        }
        System.out.println(map);
    }

    /*

   Input:   [1, 2, 3, 4 ,5, 6, 7]  k=3
    Output: [5 ,6, 7, 1, 2, 3, 4]
     */

    public static int[] rotateArr(int [] arr, int k){

        int[] arrResult = new int[arr.length];

        if(arr.length >k){

            int length = arr.length-k;
            for(int i=0; i<k; i++, length++){
                arrResult[i]= arr[length];
            }
            int y = k;
            for(int i=0; i<arr.length-k; i++, y++){
                arrResult[y] = arr[i];
            }
            return arrResult;
        }

       return null;
    }


    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5,6,7};
//        System.out.println(Arrays.toString(rotArr(arr, 3)));
//
//        System.out.println(way2(123789));
//        System.out.println(way2(-123));
//
//        int num[]= {14,23,56,19,21,120};
//        System.out.println(Arrays.toString(arrayPrime(num)));
//
        //       fibonnaci();
//
        // 2, 4 , 7, 14
//        System.out.println(perfectNumber(28));
//
//        System.out.println(primeNumber(11));
//
//        System.out.println(productNumber(12456));
//
//        System.out.println(polindrome("techtorial"));
//
//        reverseArray();
//
//        System.out.println(Arrays.toString(sumOfArray()));
//
        int nums[] = {1, 2, 3, 4, 5, 6};
//        System.out.println(Arrays.toString( sortWithoutSortMethod(nums)));
//
//        countLetter("techtorial");

        //      System.out.println(Arrays.toString(sumOfArray()));
        //      countLetter("toehchltiiorial");

        int k = 3;
        System.out.println(Arrays.toString(rotateArr(nums, k)));
    }
}
