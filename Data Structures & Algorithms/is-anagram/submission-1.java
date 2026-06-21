class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s1  = new int[26];
        int[] t1  = new int[26];
        for (int i = 0; i < s.length(); i++){
            s1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            t1[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(s1, t1);

    }
}
