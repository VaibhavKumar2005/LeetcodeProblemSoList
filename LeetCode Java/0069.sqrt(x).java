class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            long square = (long) mid * mid;

            if(square == x){
                return mid;
            }
            else if(square > x){
                right = mid - 1;
            }
            else{
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}
