class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }
    private class User{
        public int id; 
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id){
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            this.tweetHead = null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if( id != this.id){
                followed.remove(id);
            }
        }
        public void post (int id){
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new LinkedList<>();
        if(!userMap.containsKey(userId)) return feed;
        
        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> (b.time -a.time));

        for (int user : followedUsers){
            Tweet t = userMap.get(user).tweetHead;
            if(t != null){
                maxHeap.add(t);
            }
        }
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10){
            Tweet t = maxHeap.poll();
            feed.add(t.id);
            count++;

            if (t.next != null){
                maxHeap.add(t.next);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId , new User(followerId));
        userMap.putIfAbsent(followeeId , new User(followeeId));
        userMap.get(followerId).follow(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
