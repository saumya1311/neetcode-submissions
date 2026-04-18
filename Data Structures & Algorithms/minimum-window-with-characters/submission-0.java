class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapSubstring = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int formed = 0;
        int[] ans = {-1, 0, 0}; // length, start, end

        while (r < s.length()) {
            char c = s.charAt(r);
            mapSubstring.put(c, mapSubstring.getOrDefault(c, 0) + 1);

            if (mapT.containsKey(c) &&
                mapSubstring.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == mapT.size()) {
                c = s.charAt(l);

                // Update the result if this window is smaller
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                mapSubstring.put(c, mapSubstring.get(c) - 1);
                if (mapT.containsKey(c) &&
                    mapSubstring.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
