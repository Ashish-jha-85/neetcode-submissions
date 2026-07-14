class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int [26];
        int maxFreq = 0;
        int maxCount = 0;

        for (char task : tasks){
            freq[task - 'A']++;
            if(freq[task - 'A'] > maxFreq){
                maxFreq = freq[task - 'A'];
            }
        }
        for (int x : freq) {
            if (x == maxFreq) {
                maxCount++;
            }
        }
        int interval = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(interval, tasks.length);
    }
}
