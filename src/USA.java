import static java.lang.Math.pow;

/**
 * @author crkimberley on 03/10/2016.
 */
public class USA {
    private static String BASE11_NUMBERS = "0123456789:";
    private static int a,c,d,e,i,m,n,r,s,t,u;

    public static void main(String[] args) {
        permute("", BASE11_NUMBERS);
    }

    private static void permute(String prefix, String s) {
        int n = s.length();
        if (n == 1) {
            // new permutation to check
            checkUSASolution(prefix+s);
        }
        else {
            for (int i = 0; i < n; i++)
                permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
    }

    private static void checkUSASolution(String str) {
        long united, states, america;

        // convert chars to base11 numbers
        a = (int)str.charAt(0) - 48;
        c = (int)str.charAt(1) - 48;
        d = (int)str.charAt(2) - 48;
        e = (int)str.charAt(3) - 48;
        i = (int)str.charAt(4) - 48;
        m = (int)str.charAt(5) - 48;
        n = (int)str.charAt(6) - 48;
        r = (int)str.charAt(7) - 48;
        s = (int)str.charAt(8) - 48;
        t = (int)str.charAt(9) - 48;
        u = (int)str.charAt(10) - 48;

        united = (long) (u*pow(11,5) + n*pow(11,4) + i*pow(11,3) + t*pow(11,2) + e*11 + d);
        states = (long) (s*pow(11,5) + t*pow(11,4) + a*pow(11,3) + t*pow(11,2) + e*11 + s);
        america = (long) (a*pow(11,6) + m*pow(11,5) + e*pow(11,4) + r*pow(11,3) + i*pow(11,2) + c*11 + a);

        if (united+states==america && u!=0 && s!=0 && a!=0) {
            System.out.println("Solution found!\n");
            System.out.println("a = " + a);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
            System.out.println("e = " + e);
            System.out.println("i = " + i);
            System.out.println("m = " + m);
            System.out.println("n = " + n);
            System.out.println("r = " + r);
            System.out.println("s = " + s);
            System.out.println("t = " + t);
            System.out.println("u = " + u);
            System.out.println();
            System.out.println(" united\t" + "\t\t" + u + "\t" + n + "\t" + i + "\t" + t + "\t" + e + "\t" + d);
            System.out.println("+states\t" + "\t\t" + s + "\t" + t + "\t" + a + "\t" + t + "\t" + e + "\t" + s);
            System.out.println("-------------------------------------");
            System.out.println("america\t" + "\t" + a + "\t" + m + "\t" + e + "\t" + r + "\t" + i + "\t" + c + "\t" + a);
        }
    }
}