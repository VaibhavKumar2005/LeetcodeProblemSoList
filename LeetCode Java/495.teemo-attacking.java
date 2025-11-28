class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
       if(timeSeries.length == 0 || duration == 0){
        return 0;
       }
       int total = duration;

       for(int i = 1; i < timeSeries.length; i++){
            int diff = timeSeries[i] - timeSeries[i - 1];
            total+= Math.min(duration, diff);
       }
       return total;
    }
}
