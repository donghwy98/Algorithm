import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr, dp, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        tmp = new int[N][M];

        //화성 지도 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 첫줄 입력
        dp[0][0] = arr[0][0];
        for(int i=1; i<M; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        for(int i=1; i<N; i++) {

            //위에서 넘어오는 값, 왼쪽에서 넘어오는 값 중에 큰 값을 tmp[0][]에 저장
            tmp[0][0] = dp[i-1][0] + arr[i][0];
            for(int j=1; j<M; j++) {
                tmp[0][j] = Math.max(tmp[0][j-1], dp[i-1][j])+arr[i][j];
            }

            //위에서 넘어오는 값, 오른쪽에서 넘어오는 값 중에 큰 값을 tmp[1][]에 저장
            tmp[1][M-1] = dp[i-1][M-1] + arr[i][M-1];
            for(int j=M-2; j>=0; j--) {
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + arr[i][j];
            }

            for(int j=0; j<M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}

