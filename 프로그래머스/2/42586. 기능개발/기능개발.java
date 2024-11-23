import java.util.*;

class Solution {
    static ArrayList<Integer> days = new ArrayList<>();
    static ArrayList<Integer> answers= new ArrayList<>();
    
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        
        calculateDays(progresses, speeds);
        
        getAnswer(days);
        
        return answers;
    }
    
    private void calculateDays(int[] progresses, int[] speeds) {
        
        int day=0;
        
        for(int i=0; i<progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] > 0) {
                day = ((100 - progresses[i]) / speeds[i]) + 1;
            } else {
                day = (100 - progresses[i]) / speeds[i];
            }
            days.add(day);
        }
    }
    
    private void getAnswer(ArrayList<Integer> days) {
        int preDeployDay = days.get(0);
        int count = 1;
        for(int i=1; i<days.size(); i++) {
            if(preDeployDay < days.get(i)) {
                answers.add(count);
                preDeployDay = days.get(i);
                count=1;
            } else {
                count++;
            }
        }
        answers.add(count);
    }
}