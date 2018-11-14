package sample;

public class Controller {
    public static void main(String[] args) {
        String s =  "ab";
        System.out.println(solution(s));
    }
    private static int solution(String S) {
        final int size = S.length();
        int c, i, balanced = 0, check = 0;
        for (c = 0; c < size; c++)
        {
            for(i = 1; i <= size - c; i++)
            {
                check = isGood(S.substring(c, c+i));
                    if(check > balanced) balanced = check;
            }
        }
        return balanced;
    }

    private static int isGood(String substring) {
        if(substring.length() % 2 == 1) {
            return 0;
        }
        char c1, c2 = ' ';
        int count1 = 1, count2 = 0;
        c1 = substring.charAt(0);
        for(int i = 1; i < (substring.length()  ); i++) //2
        {
            if(c1 != substring.charAt(i)) {
                c2 = substring.charAt(i);
                break;
            }
        }

        for(int i = 1; i < substring.length(); i++) {
            char tmp = substring.charAt(i);
            if(c1 == tmp) {
                count1++;
            }else if( c2 == tmp) {
                count2++;
            }else {
                return 0;
            }
        }

        if(count1 == count2) {
            return substring.length();
        }

        return 0;
    }
}
