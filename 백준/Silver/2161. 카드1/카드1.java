import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
        while(queue.size()>1) {
            int s = queue.poll();
            System.out.print(s+" ");
            int q = queue.poll();
            queue.add(q);
        }
        System.out.println(queue.poll());
    }
}
