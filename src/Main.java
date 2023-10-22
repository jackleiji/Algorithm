import leetcode.Solution136;
import leetcode.Solution169;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class Main {
    @Test
    public void testAddition() throws IOException {
        int a = 2;
        int b = 3;
        int result = a + b;
        assertEquals(5, result);
        Solution136 s136 = new Solution136();
        int[] numb ={1,2,1,3,3};
        System.out.println(s136.singleNumber(numb));
    }

    @Test
    public void test169(){
        int[] nums = {1,2,1,1,3};
        Solution169 s169 = new Solution169();

        s169.majorityElement(nums);
    }
}