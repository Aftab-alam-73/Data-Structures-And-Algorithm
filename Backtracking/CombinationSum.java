import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        sum(target, candidates,0, ans, new ArrayList<>());
        return ans;
    }
    static void sum(int target,int[] candidates,int index,List<List<Integer>> ans,ArrayList<Integer> list)
    {
        if(index==candidates.length)
        {
            return;
        }
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(candidates[index]<=target)
        {

            list.add(candidates[index]);
            sum(target-candidates[index],candidates,index,ans,list);
            list.remove(list.size()-1);
        }
        sum(target,candidates,index+1,ans,list);
    }

    public static void main(String[] args) {
        int[]candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates, target));
    }
}