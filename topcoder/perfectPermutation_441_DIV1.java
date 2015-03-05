package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//B[0] = 0
//B[i] = A[B[i-1]], for every i between 1 and N-1, inclusive.
/*
 * Permutation		Child array
	{0, 1, 2}		{0, 0, 0}
	{0, 2, 1}		{0, 0, 0}
	{1, 0, 2}		{0, 1, 0}
	{1, 2, 0}		{0, 1, 2}
	{2, 0, 1}		{0, 2, 1}
	{2, 1, 0}		{0, 2, 0}
 * */
public class PerfectPermutation {
	private List<List<Integer>> permRes = new LinkedList<List<Integer>>();

	public int reorder(int[] P){
		getPermuation(P);
		permRes.remove(0);
		int ret = getMin();
		return ret;
	}
	
	public int getMin(){
		int minDiff = 51;
		for(List<Integer> perm : permRes){
			List<Integer> bArray = getBArray(perm);
			int diffNums = getDiff(perm, bArray);
//			System.out.println("diffNums is: "+diffNums);
			if(diffNums < minDiff){
				minDiff = diffNums;
			}
			
		}
		return minDiff;
	}
	
	public int getDiff(List<Integer> l1, List<Integer> l2){
		Collections.sort(l2);
		Collections.sort(l1);
		int ret = 0;
		for(int i = 0; i < l1.size(); i++){
			if(l1.get(i)!=l2.get(i)){
				ret++;
			}
		}
		return ret;
	}
	public List<Integer> getBArray(List<Integer> list){
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		for(int i = 1; i < list.size();i++){
			ret.add(list.get(ret.get(i-1)));
		}
		return ret;
	}
	public void getPermuation(int[] p){
		perm(p,0 );
	}
	
	private void perm(int[] num, int idx){
		for(int i = idx; i < num.length; i++){
			int temp = num[i]; 
			num[i] = num[idx];
			num[idx] = temp;
			perm(num, idx + 1);
			temp = num[i];
			num[i] = num[idx];
			num[idx] = temp;
		}
		if(idx == num.length-1){
			
			permRes.add(convert(num));
		}
	}
	private List<Integer> convert(int[] num){
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < num.length; i++){
			res.add(num[i]);
		}
		return res;
	}
	
	
	public static void main(String[] args){
		PerfectPermutation pp = new PerfectPermutation();
//		int[] p = {2,0,1};
//		int ret = pp.reorder(p);
//		System.out.println(ret); //0
//		
//		
//		int[] p2 = {2,0,1,4,3};
//		int ret2 = pp.reorder(p2);
//		System.out.println(ret2); //2
		
		int[] p3 = {0, 5, 3, 2, 1, 4};
		int ret3 = pp.reorder(p3);
		System.out.println(ret3); //3
		
	}
}

/*
 * 
 * 
 * import java.math.*;
import java.util.*;

public class PerfectPermutation {
    public int reorder(int[] permutation) {
        int result = 0;
        int n = permutation.length;
        boolean visit[] = new boolean[n];
        for (int i = 0; i < n; ++ i) {
            if (!visit[i]) {
                int j = i;
                do {
                    j = permutation[j];
                    visit[j] = true;
                } while (j != i);
                result ++;
            }
        }
        return result == 1? 0: result;
    }


}
 */
