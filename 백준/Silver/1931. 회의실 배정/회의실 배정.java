import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] timetable;
    static int count=0, preEndTime=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        timetable = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            timetable[i][0] = Integer.parseInt(st.nextToken());
            timetable[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(timetable, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        for(int i=0; i<N; i++) {
            if(preEndTime<=timetable[i][0]) {
                preEndTime = timetable[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
