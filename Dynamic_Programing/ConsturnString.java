import java.util.HashMap;
import java.util.ArrayList;
// In this problem we are given a string target and an array of String and we have to return true if we can construct the target from the array of strings otherwise return false.

// Second problem is to return the number of ways we can construct the target.
public class ConsturnString {
  static boolean isPresent(String target, String[] arr) {
    if (target.isEmpty()) {
      return true;
    }
    for (String s : arr) {
      if (target.startsWith(s)) {
        if (isPresent(target.substring(s.length()), arr)) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean isPresent2(String target, String[] arr, HashMap<String, Boolean> map) {
    if (map.containsKey(target)) {
      return map.get(target);
    }
    if (target.isEmpty()) {
      return true;
    }
    for (String s : arr) {
      if (target.startsWith(s)) {
        if (isPresent2(target.substring(s.length()), arr, map)) {
          map.put(target, true);
          return true;
        }
      }
    }
    map.put(target, false);
    return false;
  }

  static int countWays(String target, String[] arr, HashMap<String, Integer> map) {
    if (map.containsKey(target)) {
      return map.get(target);
    }
    if (target.isEmpty()) {
      return 1;
    }
    int count = 0;
    for (String s : arr) {
      if (target.startsWith(s)) {
        count += countWays(target.substring(s.length()), arr, map);
        // map.put(target, count);

      }
    }
    map.put(target,count);
    return count;
    }

  static ArrayList<ArrayList<String>> constructTarget(String target,String []arr,ArrayList<ArrayList<String>> ans,ArrayList<String>list)
  {
     if(target=="")
     {
      ans.add(new ArrayList<>(list));
      return ans;
     }
     for(String s:arr)
     {
        if(target.startsWith(s))
        {
          list.add(s);
           constructTarget(target.substring(s.length()), arr, ans, list);
           list.remove(list.size()-1);
        }
     }
     return ans;
  }

  public static void main(String[] args) {
    String target1 = "abcdef";
    String target2 = "purple";
    String target3 = "skateboard";
    String target4 = "enterapotentpot";
    String target5 = "eeeeeeeeeeeeeeeeeeeeeeeef";

    String[] wordBank1 = { "ab", "abc", "cd", "def", "abcd","ef","c" };// 1
    String[] wordBank2 = { "purp", "p", "ur", "le", "purpl" }; // 2
    String[] wordBank3 = { "bo", "rd", "ate", "t", "ska" ,"sk","boar"}; // 0
    String[] wordBank4 = { "a", "p", "ent", "enter", "ot","o","t" }; // 4
    String[] wordBank5 = { "e", "ee", "eee", "eeee", "eeeee","eeeeee" };
    // System.out.println(isPresent(target1, wordBank));
    // System.out.println(isPresent2(target1, wordBank, new HashMap<>()));
    // System.out.println(countWays(target1, wordBank1, new HashMap<>()));
    // System.out.println(countWays(target2, wordBank2, new HashMap<>()));
    // System.out.println(countWays(target3, wordBank3, new HashMap<>()));
    // System.out.println(countWays(target4, wordBank4, new HashMap<>()));
    // System.out.println(countWays(target5, wordBank5, new HashMap<>()));
    ArrayList<ArrayList<String>> ans=new ArrayList<>();
    System.out.println(constructTarget(target1, wordBank1, ans, new ArrayList<>()));
    // System.out.println(constructTarget(target2, wordBank2, ans, new ArrayList<>()));
    // System.out.println(constructTarget(target3, wordBank3, ans, new ArrayList<>()));
    // System.out.println(constructTarget(target4, wordBank4, ans, new ArrayList<>()));
    // System.out.println(constructTarget(target5, wordBank5, ans, new ArrayList<>()));
  }
}
