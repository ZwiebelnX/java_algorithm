package offer;

public class LastRemaining {
    public static void main(String[] args){
        lastRemaining(6, 4);
    }

    private static int lastRemaining(int n, int m){
        if(n < 1 || m < 1) return -1;

        int last = 0;
        for(int i = 2; i <= n; i++){
            last = (last + m) % i;
            System.out.println(last);
        }
        System.out.println(last);
        return last;
    }
}
