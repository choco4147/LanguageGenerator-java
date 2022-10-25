import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        char lastChar = 'n'; // n=null, v=vowel, c=consonant
        int q = 0;
        int remainingChars = 0;
        int remainingWords = 0;
        int remainingSentences = 6;
        char[] vowel = {'a', 'e', 'i', 'a', 'e', 'i', 'o', 'u', 'a', 'e', 'i', 'o', 'u', 'a', 'e', 'i', 'o', 'u'}; // 18 options
        String[] vowelCluster = {"ae", "ai", "au", "ee", "ia", "io", "oa", "oi", "oo", "ou", "ua", "ui"}; // 12 options
        String[] consonantCluster = {"th", "tt", "ll", "pp", "ss", "tt", "ll", "tt", "ns", "st", "tts", "ts"}; // 12 options 
        char[] consonant = {'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'f', 'f', 'f', 'f', 'g', 'g', 'g', 'g', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'j', 'k', 'l', 'l', 'l', 'l', 'l', 'l', 'l', 'l', 'm', 'm', 'm', 'm', 'm', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'p', 'p', 'p', 't', 'r', 'r', 'r', 'r', 'r', 'r', 's', 's', 's', 's', 's', 's', 's', 's', 's', 's', 's', 's', 'r', 'r', 'r', 'r', 'r', 'r', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 'v', 'v', 'w', 'w', 'w', 'w', 'w', 'y', 'y', 'y', 'y', 'z'}; // 123 options
        char[] accent = {'à', 'á', 'é', 'è', 'ô', 'ù', 'ú'}; // 7 options
        char[] fullStop = {'.', '.', '.', '.', '.', '.', '.', '.', '!', '?'}; // 10 options 
        String[] punctuation = {"... ", "a, "}; // oops
        
        while (remainingSentences > 0) {
            remainingWords = 0;
            for (int i = -1; i < random.nextInt(2); i++) {
                remainingWords = remainingWords + random.nextInt(7) + 4;
            }
            while (remainingWords > 0) {
                System.out.print(" ");
                lastChar = 'n';
                remainingChars = 0;
                remainingChars = random.nextInt(7) + 1;
                while (remainingChars > 0) {
                    if (remainingChars == 1 && lastChar == 'n') {
                        remainingChars = remainingChars + 1;
                    }
                    if (lastChar == 'n') {
                        q = random.nextInt(50);
                        if (q > 25) {
                            System.out.print(vowel[random.nextInt(18)]);
                            lastChar = 'v';
                        }
                        else {
                            System.out.print(consonant[random.nextInt(123)]);
                            lastChar = 'c';
                        }
                    }
                    else if (lastChar == 'v') {
                        q = random.nextInt(50);
                        if (q > 40) {
                            System.out.print(consonant[random.nextInt(123)]);
                        }
                        else {
                            System.out.print(consonantCluster[random.nextInt(12)]);
                            remainingChars = remainingChars - 1;
                        }
                        lastChar = 'c';
                    }
                    else {
                        q = random.nextInt(50);
                        if (q > 45) {
                            System.out.print(accent[random.nextInt(7)]);
                        }
                        else if (q > 40) {
                            System.out.print(vowelCluster[random.nextInt(12)]);
                        }
                        else {
                            System.out.print(vowel[random.nextInt(18)]);
                        }
                        lastChar = 'v';
                    }
                    q = random.nextInt(160);
                    if (q < 2) {
                        System.out.print(punctuation[random.nextInt(2)]);
                    }
                    remainingChars = remainingChars - 1;
                }
                remainingWords = remainingWords - 1;
            }
            System.out.print(fullStop[random.nextInt(10)]);
            lastChar = 'n';
            
            remainingSentences = remainingSentences - 1;
        }
    }
}
