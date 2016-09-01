import java.util.*;
//by Shawn Zhou
class Person{
	int height;
	int numHigher;	
	public Person(int height, int numHigher){
		this.height = height;
		this.numHigher = numHigher;
	}
}

public class Solution{
	// O(n2) solution, 
	public List<Person> reconstruct(Person[] people){
		Arrays.sort(people, new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p2.height - p1.height;
			}
		});
		
		List<Person> res = new ArrayList<>();
		for(Person person: people){
			res.add(person.numHigher, person);
		}
		
		return res;
	}
	
	// O(NlogN) segment tree solution, 
	public List<Person> reconstructSegmentTree(Person[] people){
		Arrays.sort(people, new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.height - p2.height;
			}
		});
		
		SegTree seg = new SegTree(people.length);
		
		List<Person> res = new ArrayList<>();
		for(int i = 0; i < people.length; i++){
			res.add(null);

		}
		for(Person person: people){
			int idx = seg.getAndRemoveKth(person.numHigher+1)-1;
			res.set(idx, person);
		}
		
		return res;
	}
	
	class SegTree{
		int[] st;
		int[] arr;
		
		public SegTree(int N){
			arr = new int[N+1];	// 1: available  0: occupied
			Arrays.fill(arr, 1);
			arr[0] = 0;

			int b = 1;
			while(b < N+1){
				b = b << 1;				
			}
			st = new int[2*b-1];
			constructUtil(0, N, 0);
		}
		
		private int constructUtil(int arrLo, int arrHi, int stIdx){
			if(arrLo == arrHi){
				st[stIdx] = arr[arrLo];
			}else{
				int mid = arrLo + (arrHi - arrLo) / 2;
				st[stIdx] = constructUtil(arrLo, mid, 2 * stIdx + 1) + constructUtil(mid + 1, arrHi, 2 * stIdx + 2);
			}
			return st[stIdx];
		}
		
		public int getAndRemoveKth(int k){
			int res = getKthUtil(0, arr.length - 1, k, 0);
			arr[res] = 0;
			removeKthUtil(0, arr.length - 1, res, 0);
			return res;
		}		

		private int getKthUtil(int arrLo, int arrHi, int k, int stIdx){
			if(st[stIdx] == k && arr[arrHi] == 1){
				return arrHi;
			}
			int mid = arrLo + (arrHi - arrLo) / 2;
			if(st[2 * stIdx + 1] >= k){
				return getKthUtil(arrLo, mid, k, 2 * stIdx + 1);
			}else{
				return getKthUtil(mid + 1, arrHi, k - st[2 * stIdx + 1], 2 * stIdx + 2);
			}
		}
		
		private void removeKthUtil(int arrLo, int arrHi, int K, int stIdx) {
			if(K < arrLo || arrHi < K){
				return;
			}
			st[stIdx]--;
			if(arrLo < arrHi){
				int mid = arrLo + (arrHi - arrLo) / 2;
				removeKthUtil(arrLo, mid, K, 2 * stIdx + 1);
				removeKthUtil(mid + 1, arrHi, K, 2 * stIdx + 2);
			}			
		}		
	}
}
