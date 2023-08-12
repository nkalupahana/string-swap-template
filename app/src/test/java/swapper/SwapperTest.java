/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package swapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.apache.commons.text.RandomStringGenerator;

class SwapperTest {
    private Swapper swapper;

    @BeforeEach
    public void doBefore() {
        swapper = new Swapper();
    }

    @Test
    public void passesExamples() {
        assertTrue(swapper.canSwap("ab", "ba"));
        assertFalse(swapper.canSwap("ab", "ab"));
        assertTrue(swapper.canSwap("aa", "aa"));
    }

    // Test names are intentionally obfuscated
    @Test
    public void t1_a() {
        assertFalse(swapper.canSwap("a", "a"));
        assertFalse(swapper.canSwap("", "qwertyuiop"));
        assertFalse(swapper.canSwap("", ""));
        assertFalse(swapper.canSwap("qwertyuiop", ""));
    }

    @Test
    public void t1_b() {
        assertFalse(swapper.canSwap("ab", "abc"));
        assertFalse(swapper.canSwap("qwertyuiop", "qwertyuio"));
    }

    @Test
    public void t2() {
        assertFalse(swapper.canSwap("abcdefghijklmnop", "abcdefghijklmnop"));
        assertTrue(swapper.canSwap("abcdefghijklmnopa", "abcdefghijklmnopa"));
    }
    
    @Test
    public void t3_a() {
        assertFalse(swapper.canSwap("qwertyuiop", "asdfghjklp"));
        assertFalse(swapper.canSwap("qwertyuiop", "poiuytrewq"));
    }

    @Test
    public void t3_b() {
        assertFalse(swapper.canSwap("qwertyuiop", "qwertyxxop"));
    }

    @Test
    public void t4() {
        assertFalse(swapper.canSwap("abcdd", "ddcba"));
    }

    private String generateString(int length) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('a', 'z').build();
        return generator.generate(length);
    }

    @Test
    public void longFail() {
        for (int i = 0; i < 10; i++) {
            assertFalse(swapper.canSwap(generateString(1000), generateString(1000)));
        }
    }

    @Test
    public void longSucceed() {
        for (int i = 0; i < 10; i++) {
            String generated = generateString(1000);
            char[] sArr = generated.toCharArray();
            char temp = sArr[30];
            sArr[30] = sArr[955];
            sArr[955] = temp;
            String swapped = new String(sArr);
            assertTrue(swapper.canSwap(generated, swapped));
        }
    }

    @Test
    public void xlongFail() {
        for (int i = 0; i < 10; i++) {
            assertFalse(swapper.canSwap(generateString(10000), generateString(10000)));
        }
    }

    @Test
    public void xlongSucceed() {
        for (int i = 0; i < 10; i++) {
            String generated = generateString(10000);
            char[] sArr = generated.toCharArray();
            char temp = sArr[30];
            sArr[30] = sArr[7955];
            sArr[7955] = temp;
            String swapped = new String(sArr);
            assertTrue(swapper.canSwap(generated, swapped));
        }
    }
}