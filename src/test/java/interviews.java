import java.util.HashMap;
import java.util.Map;

public class interviews {

    public static void main(String[] args) {
     //   interviews.test("interview");

//        fiboncci(0,1);
//        System.out.println(primeNum(20));
        reverseInt(456);

    }

    public static void test(String str){

        Map<String ,Integer> map = new HashMap<>();

        for(int i=0; i<str.length();i++){

            if(map.containsKey(str.charAt(i)+"")){
                Integer temp = map.get(str.charAt(i)+"");
                map.put(str.charAt(i)+"",++temp);
            }else {
                map.put(str.charAt(i)+"",1);
            }
        }
        System.out.println(map);

    }

    public static void fiboncci(int firstNum, int seconNum){

        System.out.println(firstNum);
        System.out.println(seconNum);
        // 0 1 1 2  3 5 8 ....
//        for(int i=0; i<100; ){
//            i=firstNum+seconNum;
//            firstNum=seconNum;
//            seconNum=i;
//            if(seconNum<100)
//            System.out.println(seconNum);
//        }
        int i=0;
        while(i<100){
            i=firstNum+seconNum;
            firstNum=seconNum;
            seconNum=i;
            if(seconNum<100)
                System.out.println(seconNum);
        }

    }



    public static boolean primeNum(int number){

        boolean result=true;
        for(int i=2; i<=number/2; i++){
            if(number%i==0){
                result = false;
            }
        }
        return result;

    }
    public static void reverseInt(int num){
        StringBuilder stringBuilder = new StringBuilder(num+"");
        stringBuilder.reverse();
        int number = Integer.parseInt(stringBuilder.toString());
        System.out.println(number);

    }



}
