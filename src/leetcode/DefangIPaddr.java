package leetcode;

/**
 * <p>Title: DefangIPaddr</p>
 * <p>Description: 1108</p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class DefangIPaddr {
    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
