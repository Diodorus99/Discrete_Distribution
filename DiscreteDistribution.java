import java.util.Random;

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }

        int n = a.length;
        int[] S = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + a[i - 1];
        }

        Random rand = new Random();
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int r = rand.nextInt(S[n]);
            for (int j = 1; j <= n; j++) {
                if (r < S[j]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}
