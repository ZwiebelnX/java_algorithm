package leetcode;

/**
 * questionIndex: 942
 */
public class DIStringMatch {
    public static void main(String[] args){

    }

    private int[] diStringMatch(String S) {
        int n = S.length();
        int low = 0;
        int high = n;
        int[] ans = new int[n + 1];
        for(int i = 0; i < S.length(); i++){
            ans[i] = S.charAt(i) == 'I' ? low++ : high--;
        }
        ans[ans.length - 1] = low; // 最后low和high其实是一样的
        return ans;
    }
}
