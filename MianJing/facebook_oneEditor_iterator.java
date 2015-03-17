发信人: yuxrose (鱼香肉丝), 信区: JobHunting
标  题: FB这道店面题怎么做？听说挂了很多人...
发信站: BBS 未名空间站 (Wed Mar 11 04:18:58 2015, 美东)

在一亩三分地上看到的，听说挂了很多人。咱板上牛人多，发上来和大家讨论一下呀
class IntFileIterator {
  boolean hasNext();
  int next();
}

class{
  public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；

}
// return if the distance between a and b is at most 1..
// Distance: minimum number of modifications to make a=b
// Modification:
//   1. change an int in a
//   2. insert an int to a
//   3. remove an int from a

这题就是one edit distance的变形题，难点在于给的Iterator，事先不知道两个file
的长度，也不允许用extra space（所以不能转成两个string再比），那么一个个往前
跑的时候就得三种情况都考虑。。。。



只用constant内存的DP解法，自测能过所有test case

    public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)
{
        int up = 1;
        int left = 1;
        int diagnal = 0;
        int dist = 0;
        int currA = 0;
        int currB = 0;
        int prevA = 0;
        int prevB = 0;
       
        if (a.hasNext() && b.hasNext()) {
            prevA = a.next();
            prevB = b.next();
            if (prevA == prevB) {
                dist = 0;
            } else {
                dist = 1;
            }
        }

        while (a.hasNext() || b.hasNext()) {
            diagnal = dist;
            if (a.hasNext()) { // a has more numbers
                currA = a.next();
                up = Math.min(dist + 1, up + matchCost(currA, prevB)); //
insert into a, or match a, b
                if (b.hasNext()) { //b has more numbers
                    currB = b.next();
                    left = Math.min(dist + 1, left + matchCost(currB, prevA)
); //delete head of a, or match a, b
                    dist = Math.min(up + 1, left + 1); //delete or insert
                    dist = Math.min(diagnal + matchCost(currA, currB), dist)
; //match
                } else { //b is out of numbers
                    ++left;
                    ++dist; //delete head of a
                    break;
                }
            } else { // a is out of numbers, b has to have more numbers
                currB = b.next();
                left = Math.min(dist + 1, left + matchCost(currB, prevA)); /
/delete head of a, or match a, b
                ++up;
                ++dist;
                break;
            }
           
            if (dist > 1 && up > 1 && left > 1) {
                return false;
            }
           
            prevA = currA;
            prevB = currB;
        }
       
        dist = Math.min(dist, up);
        dist = Math.min(dist, left);
       
        while (a.hasNext()) {
            a.next();
            ++dist;
        }

        while (b.hasNext()) {
            b.next();
            ++dist;
        }

        return dist <= 1;
    }



//////////////////////////////////

JUnit test 代码

public class SolutionTest {

    @Test
    public void test() {
        int[] a;
        int[] b;
        boolean expect;
        Solution s = new Solution();

        //both empty
        a = new int[] {};
        b = new int[] {};
        expect = true;
        testSolution(s, a, b, expect);

        //empty and 1 element
        a = new int[] {};
        b = new int[] {1};
        expect = true;
        testSolution(s, a, b, expect);

        //empty and 2 element all 0s
        a = new int[] {};
        b = new int[] {0, 0};
        expect = false;
        testSolution(s, a, b, expect);

        //empty and 2 element
        a = new int[] {};
        b = new int[] {1, 2};
        expect = false;
        testSolution(s, a, b, expect);

        //one element and 2 elements, miss last element
        a = new int[] {1};
        b = new int[] {1, 2};
        expect = true;
        testSolution(s, a, b, expect);

        //one element and 2 elements, miss first element
        a = new int[] {2};
        b = new int[] {1, 2};
        expect = true;
        testSolution(s, a, b, expect);

        //one element and 2 elements, no equal elements
        a = new int[] {3};
        b = new int[] {1, 2};
        expect = false;
        testSolution(s, a, b, expect);

        //different element in the middle
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {1, 2, 3, 4, 5, 4, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //different element in the middle, but equals next element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {1, 2, 3, 4, 5, 8, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //different element at the end
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 32};
        expect = true;
        testSolution(s, a, b, expect);

        //different element at the end, but equals previous element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 7};
        expect = true;
        testSolution(s, a, b, expect);

        //different element at the beginning, but equals next element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {2, 2, 3, 4, 5, 9, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //different element at the beginning, but equals next element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {22, 2, 3, 4, 5, 9, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //miss first element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b = new int[] {2, 3, 4, 5, 9, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //miss last element
        a = new int[] {1, 2, 3, 4, 5, 9, 8, 7};
        b = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //one difference and miss one
        a = new int[] {1, 2, 3, 4, 5, 4, 7, 6};
        b = new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        expect = false;
        testSolution(s, a, b, expect);

        //two differences and miss one
        a =  new int[] {1, 2, 3, 4, 5, 4, 8, 7, 1, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        expect = false;
        testSolution(s, a, b, expect);

        //one difference and miss two
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 4, 8, 7, 6, 3, 2};
        expect = false;
        testSolution(s, a, b, expect);

        //miss one
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //miss one
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 1, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //miss one, and equals next
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 7, 6};
        expect = true;
        testSolution(s, a, b, expect);

        //miss one, and equals next
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 7};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 1, 7};
        expect = true;
        testSolution(s, a, b, expect);

        //miss two
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6, 3, 2};
        expect = false;
        testSolution(s, a, b, expect);

        //miss two
        a =  new int[] {1, 2, 3, 4, 5, 9, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 1, 6};
        expect = false;
        testSolution(s, a, b, expect);

        //miss three
        a =  new int[] {1, 2, 3, 4, 5, 9, 7, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6, 3, 2};
        expect = false;
        testSolution(s, a, b, expect);

        //one extra, miss two
        a =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 1, 6};
        b =  new int[] {1, 2, 3, 4, 5, 9, 8, 7, 6, 3, 2};
        expect = false;
        testSolution(s, a, b, expect);
    }
   
    private void testSolution(Solution s, int[] a1, int[] b1, boolean expect
) {
        IntFileIterator a = new IntFileIterator(a1);
        IntFileIterator b = new IntFileIterator(b1);
        a.print();
        b.print();
        boolean result = s.isDistanceZeroOrOne(a, b);
        System.out.println("expected: " + expect + ": got: " + result);
        System.out.println("");
        assertEquals(expect, result);
       
       
        b = new IntFileIterator(a1);
        a = new IntFileIterator(b1);
        a.print();
        b.print();
        result = s.isDistanceZeroOrOne(a, b);
        System.out.println("expected: " + expect + ": got: " + result);
        System.out.println("");
        assertEquals(expect, result);

    }

}


///////////////////////
我来给你试着解释一下。这个题说到底是一个有限自动机的问题。我们可以定义一下四
种状态：

0： 到目前为止A和B的字母都相同。
1： 到目前为止A和B的字母除了一个以外都相同。
2： 到目前为止A比B少一个字母，其他的都相同。
3： 到目前为止B比A少一个字母，其他的都相同。

初始状态设为S0 = {0}，因为A和B都是空，所以是相等的。下面是从S_n到S_{n+1}的转
换：

* Let S_{n+1} = {}
* If 0 is in S_n, then
  - put 2 and 3 in S_{n+1}. 
  - If A[n] == B[n], then put 0 in S_{n+1}, otherwise put 1 in S_{n+1}
* If 1 is in S_n, then
  - if A[n] == B[n], then put 1 in S_{n+1}
* If 2 is in S_n, then
  - if A[n-1] == B[n], then put 2 in S_{n+1}
* If 3 is in S_n, then
  - if A[n] == B[n-1], then put 3 in S_{n+1}

Any time if S_n is {} for some n, return false.  Otherwise, return true
while both A and B deplete.

//////////////
//cpp

    #include <iostream>
    #include <vector>
    #include <functional>
    using namespace std;
     
    void TEST(bool val, bool answer) {
    string s_val = val ? "true" : "false";
    string a_val = answer ? "true" : "false";
    if(val == answer) {
    cout << "PASS!" << endl;
    } else {
    cout << "FAIL: should be [ " << a_val << " ] but given [ " << s_val << " ]" << endl;
    }
    }
     
    class Iterator {
    public:
    Iterator(const vector<int>& data) : _data(data) {}
    int get_next() { return _data[_pointer++]; }
    bool has_next() { return _pointer < _data.size(); }
    private:
    vector<int> _data;
    size_t _pointer{ 0 };
    };
     
    /////////////////////////////////////////////////////////////////////////////////
     
    bool one_dist(Iterator&& a, Iterator&& b) {
    bool ins_a = false, ins_b = false, replace = false, diff = false;
    char pre_a, pre_b;
    while (a.has_next() && b.has_next()) {
    int cur_a = a.get_next(), cur_b = b.get_next();
    if (!ins_a && !ins_b && !replace) {
    if (cur_a != cur_b) {
    ins_a = ins_b = replace = diff = true;
    }
    } else {
    if (ins_a && pre_b != cur_a) ins_a = false;
    if (ins_b && pre_a != cur_b) ins_b = false;
    if (replace && cur_a != cur_b) replace = false;
    if (!ins_a && !ins_b && !replace) return false;
    }
    pre_a = cur_a;
    pre_b = cur_b;
    }
     
    if (!a.has_next() && !b.has_next()) {
    return !diff || replace;
    } else if (a.has_next()) {
    int cur_a = a.get_next();
    return (!diff || (ins_a && pre_b == cur_a)) && !a.has_next();
    } else if (b.has_next()) {
    int cur_b = b.get_next();
    return (!diff || (ins_b && pre_a == cur_b)) && !b.has_next();
    }
    }
     
    /////////////////////////////////////////////////////////////////////////////////
     
    int main() {
    TEST(one_dist(Iterator({1,2}), Iterator({3,1})), false); // 0
    TEST(one_dist(Iterator({1,2}), Iterator({2,3})), false); // 0
    TEST(one_dist(Iterator({1,2,1}), Iterator({2,1})), true);
    TEST(one_dist(Iterator({1,2}), Iterator({2,1,2})), true);
    TEST(one_dist(Iterator({1,2,1,2,4}), Iterator({2,1,2,4})), true);
    TEST(one_dist(Iterator({1,2,3}), Iterator({1,2,4})), true); // 1
    TEST(one_dist(Iterator({1}), Iterator({2,3})), false); // 0
    TEST(one_dist(Iterator({1}), Iterator({2,1})), true); // 1
    TEST(one_dist(Iterator({2,3}), Iterator({1})), false); // 0
    TEST(one_dist(Iterator({1}), Iterator({1,2,3,4,5})), false); // 0
    TEST(one_dist(Iterator({1}), Iterator({})), true); // 1
    TEST(one_dist(Iterator({}), Iterator({1})), true); // 1
    TEST(one_dist(Iterator({1,2,3}), Iterator({2,3})), true); // 1
    TEST(one_dist(Iterator({1,3,4}), Iterator({2,3,4})), true); // 1
    TEST(one_dist(Iterator({1,2,3}), Iterator({2,4})), false); // 0
    TEST(one_dist(Iterator({1,2,3}), Iterator({2})), false); // 0
    TEST(one_dist(Iterator({3,4}), Iterator({5})), false); // 0
    TEST(one_dist(Iterator({3,4}), Iterator({5,6})), false); // 0
    TEST(one_dist(Iterator({1,2,3}), Iterator({1,2,3})), true); // 1
    TEST(one_dist(Iterator({}), Iterator({})), true); // 1
    TEST(one_dist(Iterator({1}), Iterator({2})), true); // 1
    TEST(one_dist(Iterator({1,3,4,5,6,7}), Iterator({1,2})), false); // 0
    TEST(one_dist(Iterator({1,3,4,5,6,7}), Iterator({1,4,5,6,7})), true); // 1
    TEST(one_dist(Iterator({2,3,4,5,6,7}), Iterator({3,4,5,6,7})), true); // 1
     
    return 0;
    }
























///
///another solution
My solution:

class FileCompare {
  public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
    while (a.hasNext() && b.hasNext()) {
      int curA = a.next();
      int curB = b.next();
      if (curA != curB) {
        int prevA = curA;
        int prevB = curB;
        if (a.hasNext() && b.hasNext()) {
          curA = a.next();
          curB = b.next();
          if (curA != prevB && curB != prevA) {
            // This means neither prevA nor prevB is the extra item added
            // In other words, one of them could be changed.
            if (curA != curB) 
              return false; // No more difference is allowed
            return isSame(a, b); // check if the remaining parts of A and B
are same
          }
         
          if (curA == prevB && curB == prevA) // two different pairs
            return false;
           
          if (curA == prevB) {
            // Now there are two possible cases:
            //  1: prevA is the extra item added
            //  2: prevA or prevB is the changed item
           
            if (curA != curB)
              return isAdd(a, b, curB);
           
            return isAddOrChange(a, b, curB);
          }
         
          // last case: curA == preB
          if (curA != curB)
            return isAdd(b, a, curA);
         
          return isAddOrChange(b, a, curA);
        }
        else if (a.hasNext()) { // && !b.hasNext()
          curA = a.next();
          return (!a.hasNext() && curA == prevB); // the second last item in
A is added
        }
        else if (b.hasNext()) { // && !a.hasNext()
          curB = b.next();
          return (!b.hasNext() && curB == prevA); // the second last item in
B is added
        }
        else { // the last one is different b/w A and B-> one item change
          return true;
        }
      }
    }
   
    if (a.hasNext()) {
      a.next();
      return (!a.hasNext()); // the last item in A is added
    }  
    if (b.hasNext()) {
      b.next();
      return (!b.hasNext()); // the last time in B is added
    }      
    return true;
  }
 
  private boolean isSame(IntFileIterator a, IntFileIterator b) {
    while (a.hasNext() && b.hasNext()) {
      if (a.next() != b.next())
        return false;
    }
    return !a.hasNext() && !b.hasNext();
  }

  private boolean isAdd(IntFileIterator a, IntFileIterator b, int prevB) {
    if (!a.hasNext())
      return false;
    if (a.next() != prevB)
      return false;
    return isSame(a, b);
  }
 
  private boolean isAddOrChange(IntFileIterator a, IntFileIterator b, int
prevB) {
    boolean isValidAddCase = true, isValidChangeCase = true
    while (a.hasNext() && b.hasNext()) {
      int curA = a.next();
      int curB = b.next();           
      isValidAddCase &&= (curA == prevB);
      isValidChangeCase &&= (curA == curB);          
      if (!isValidAddCase && !isValidChangeCase)
        return false;          
      prevB = curB;
    }
   
    if (isValidChangeCase && !a.hasNext() && !b.hasNext())
      return true; // this is the change case
   
    if (isValidAddCase && a.hasNext()) {
      int curA = a.next();
      return (curA == prevB) && !a.hasNext();
    }
   
    return false;
  }
}
