class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : stones){
            maxHeap.offer(num);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            y = x - y;
            if (  y != 0) maxHeap.add(y);
        }
        if (maxHeap.isEmpty()) return 0;
        return maxHeap.peek();
    }
}
