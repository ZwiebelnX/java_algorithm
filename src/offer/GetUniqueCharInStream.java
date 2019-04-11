package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class GetUniqueCharInStream {
    public static void main(String[] args){

    }

    private int size = 0;
    private int[] hash = new int[256]; // 只可表示ASCII码中的字符
    private Deque<Character> deque = new ArrayDeque<>(); // 快捷查找第一个不重复字符的结构

    public GetUniqueCharInStream(){
        for(int i = 0; i < hash.length; i++){
            hash[i] = -1;
        }
    }

    //Insert one char from stringstream
    public void insert(char ch)
    {
        if(hash[ch] == -1){
            hash[ch] = size;
            // 如果当前字符是第一个，则插入队列。否则不插入
            deque.addLast(ch);
        }
        else hash[ch] = -2;
        size++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (!deque.isEmpty()){
            char ch = deque.peekFirst();
            if(hash[ch] != -2) return ch;
            else{
                deque.pollFirst();
            }
        }
        return '#';
    }
}
