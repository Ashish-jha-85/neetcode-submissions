

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count the frequencies of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // 2. Build a Max-Heap using the frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }
        
        // 3. Wait Queue to store tasks on cooldown: stores arrays of {remaining_frequency, available_time}
        Queue<int[]> waitQueue = new LinkedList<>();
        int time = 0;
        
        // 4. Simulate the CPU cycles
        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {
            time++; // 1 cycle ticks
            
            // If we have an available task, process the most frequent one
            if (!maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                currentFreq--; // Task executed, decrement its count
                
                // If there are still more of this task, it goes on cooldown
                if (currentFreq > 0) {
                    waitQueue.offer(new int[]{currentFreq, time + n});
                }
            }
            
            // Check if the task at the front of the wait queue is done with its cooldown
            if (!waitQueue.isEmpty() && waitQueue.peek()[1] == time) {
                // Put it back into the Max-Heap so it can be scheduled again
                maxHeap.offer(waitQueue.poll()[0]);
            }
        }
        
        return time;
    }
}