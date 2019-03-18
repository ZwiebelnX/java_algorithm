package leetcode.greedy;


/**
 * questionIndex: 944
 */
public class DeleteColumnsToMakeSorted {
    private static int minDeletionSize(String[] A) {
        int length = 0;
        int index = 0;
        while(index < A[0].length()){
            int lastChar = 0;
            for (String s : A) {
                if (lastChar > s.charAt(index)) {
                    length++;
                    break;
                }
                lastChar = s.charAt(index);
            }
            index++;
        }
        return length;
    }

    public static void main(String[] args){
        String[] A = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(A));
    }
}
