package work.tencent;

import java.util.*;

//12 5
//2 5 3 1 3 2 4 1 0 5 4 3

//6
public class Four {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int totalShoots = in.nextInt();

        int totalBalloons = in.nextInt();
        Map<Integer, Boolean> balloonsStatus = new HashMap<>();
        for(int i = 1; i <= totalBalloons; i ++){
            balloonsStatus.put(i, false);
        }

        List<Integer> shoots = new ArrayList<>(totalShoots);
        List<Integer> successfulShoots = new ArrayList<>();
        int overkillStart = 0;
        int overkillEnd = 0;
        for(int i = 0; i < totalShoots; i++){
            shoots.add(in.nextInt());


        }

        for(int shootIndex = 0; shootIndex <= shoots.size(); shootIndex++){

        }
//        for(int shoot = 1; shoot <= shoots.size(); shoot ++){
//            if(overkillStart == 0){
//                overkillStart = shoot;
//            }
//            if(!balloonsStatus.get(shoots.get(shoot))){
//                overkillEnd = shoot;
//                if(shoots.get(overkillStart).equals(shoots.get(overkillEnd))){
//                    overkillStart++;
//                }
//            }
//            if(shoots.get(shoot) == 0){
//                if(!finish(balloonsStatus)){
//                    overkillStart = 0;
//                    overkillEnd = 0;
//                    balloonsStatus.forEach((key, value) -> value = false);
//                }
//                else{
//                    break;
//                }
//            }
//            else{
//                balloonsStatus.put(shoot, true);
//            }
//        }
//        if(finish(balloonsStatus)){
//            System.out.println(overkillEnd - overkillStart);
//        }
//        else{
//            System.out.println(-1);
//        }
    }

    private static boolean isFinished(Map<Integer, Boolean> balloonsStatus){
        Set<Map.Entry<Integer, Boolean>> b = balloonsStatus.entrySet();
        for(Map.Entry<Integer, Boolean> e : b){
            if(!e.getValue()){
                return false;
            }
        }
        balloonsStatus.forEach((key, value) -> value = false);
        return true;
    }
}
