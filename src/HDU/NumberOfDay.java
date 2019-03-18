package HDU;

import java.util.Scanner;

//NJUST OJ HDU 2005
public class NumberOfDay {

    public static void main(String[] args) {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) { //使用while + scanner.hasNext()来实现以EOF为结尾的循环输入
            int result = 0;
            String inputString = scanner.nextLine();
            String[] date = inputString.split("/");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                result += 1;
            }
            for(int i = 0; i < month - 1; i++){
                result += numberOfDays[i];
            }
            result += day;
            System.out.println(result);
        }
    }
}
