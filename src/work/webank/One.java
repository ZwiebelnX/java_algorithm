package work.webank;

import java.util.*;

public class One {
//    public static void main(String[] args){
//        StringBuilder result = new StringBuilder();
//        Scanner in = new Scanner(System.in);
//        int total = in.nextInt();
//        int count = in.nextInt();
//
//        int left = total;
//        boolean[] people = new boolean[total + 1];
//        int temp = 1;
//        int i = 0;
//        while (left > 1){
//            do{
//                i++;
//                if(i > total) i = 1;
//            }while (people[i]);
//
//            if(temp == count){
//                temp = 1;
//                people[i] = true;
//                result.append(i);
//                result.append(" ");
//                left--;
//            }
//            else {
//                temp++;
//            }
//        }
//
//        result.delete(result.length() - 1, result.length());
//        System.out.println(result.toString());
//
//        for(int j = 1; j < people.length; j++){
//            if(!people[j]){
//                System.out.print(j);
//                break;
//            }
//        }
//    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int count = in.nextInt();
        if(total <= 0 || count <=0) return;

        Deque<Integer> people = new ArrayDeque<>();
        for(int i = 1; i <= total; i++){
            people.addLast(i);
        }

        int temp = 1;
        while (people.size() > 1){
            if(temp != count){
                people.addLast(people.pollFirst());
                temp++;
            }
            else{
                temp = 1;
                System.out.print(people.pollFirst() + " ");
            }
        }

        System.out.println();
        System.out.println(people.pollFirst());
    }
}
