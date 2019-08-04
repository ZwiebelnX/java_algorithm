package work.dji;

import java.util.Scanner;

/**
 * <p>Title: Two</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int snakeCount = in.nextInt();
            int money = in.nextInt();
            Snake[] snakes = new Snake[snakeCount];
            for(int i = 0; i < snakeCount; i++){
                snakes[i] = new Snake(in.nextInt(), in.nextInt(), in.nextInt());
            }

            int[] opts = new int[money + 1];
            for(int i = 0; i < opts.length; i++){
                 int q = 0;
                int chosenSnake = -1;
                for(int j = 0; j < snakes.length; j++){

                    if(i >= snakes[j].cast && snakes[j].count > 0){
                        // q = Math.max(q, snake.happy + opts[i - snake.cast]);
                        if(q < snakes[j].happy + opts[i - snakes[j].cast]){
                            chosenSnake = j;
                            q = snakes[j].happy + opts[i - snakes[j].cast];
                        }
                    }
                }
                if(chosenSnake > 0) snakes[chosenSnake].count--;
                opts[i] = q;
            }
            System.out.println(opts[money]);
        }
    }
}

class Snake{
    int cast;
    int happy;
    int count;
    public Snake(int cast, int happy, int count){
        this.cast = cast;
        this.happy = happy;
        this.count = count;
    }
}
