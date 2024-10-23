class Solution {
    static int answer = 0;
    static boolean[] visit;
    static int count = 0;
    public int solution(int n, int[][] computers) {
        
        count = n;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                answer++;
                findAnswer(computers, i);
            }
        }
        
        return answer;
    }
    private void findAnswer(int[][] computers, int x) {
        
        visit[x] = true;
        
        for(int y=0; y<count; y++) {
            if(y!=x && computers[x][y]==1 && visit[y]==false) {
                findAnswer(computers, y);
            }
        }
    }
    
}