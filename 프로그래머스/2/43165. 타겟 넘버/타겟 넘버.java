class Solution {
    static int answer = 0;
    static int[] numberArr;
    static int goal;
    public int solution(int[] numbers, int target) {
        numberArr = numbers;
        goal = target;
        int index = 0;
        int sum = 0;
        calculate(index, sum);
        return answer;
    }
    private void calculate(int index, int sum) {
        if(index==numberArr.length) {
            if(sum==goal) {
                answer++;
            }
            return;
        }
        calculate(index+1, sum-numberArr[index]);
        calculate(index+1, sum+numberArr[index]);
    }
}