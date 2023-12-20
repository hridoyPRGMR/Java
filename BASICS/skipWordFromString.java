import java.util.*;

public class skipWordFromString {

    public static String res(String str, StringBuilder ans) {
        if (str.isEmpty()) return ans.toString();

        if (str.startsWith("apple")) {
            return res(str.substring(5), ans); // Skip "apple" and continue recursively
        } else {
            ans.append(str.charAt(0)); // Append characters if the string doesn't start with "apple"
            return res(str.substring(1), ans); // Move to the next character recursively
        }
    }



    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        int n = nums.length;
        // Solution sln = new Solution(); // This line isn't used and might cause an error

        String str = "bacapplecad";
        StringBuilder result = new StringBuilder(); // Create a StringBuilder for the result

        //System.out.println(str.substring(1));

        System.out.println(res(str, result)); // Pass the StringBuilder to the res method
    }
}

