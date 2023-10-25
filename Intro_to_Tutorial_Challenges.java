package Tuan7;

import java.util.List;

public class Intro_to_Tutorial_Challenges {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int l=0, r=arr.size()-1;
        while (l<=r)
        {
            int mid=(l+r)/2;
            if(arr.get(mid)==V) return mid;
            else if(arr.get(mid)>V) r=mid-1;
            else if(arr.get(mid)<V) l=mid + 1;
        }
        return -1;
    }

}
