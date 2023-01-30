import java.util.*;
public class PalindromePartition1 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s, res, ans);
        return res;
    }
    boolean isPalindrome(String str) {
        int i=0;
        int j=str.length()-1;
        while(i > j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    void solve(String s, List<List<String>> res, List<String> ans) {
        if(s.length() == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s.substring(0,i+1))) {
                String rest = s.substring(0, i+1);
                ans.add(rest);
                solve(rest, res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}
