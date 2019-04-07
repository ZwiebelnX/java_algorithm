package work.wangyi;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class One {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int result = 0;
        Set<String> phones = new TreeSet<>();

        for(int i = 0; i < total; i++){
            if(phones.add(in.next())) result++;
        }

        System.out.println(result);
    }
}
