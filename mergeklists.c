/**维护一个k个大小的最小堆，初始化堆中元素为每个链表的头结点，
 * 每次从堆中选择最小的元素加入到结果链表，再选择该最小元素所在链表的下一个节点加入到堆中。
 * 这样当堆为空时，所有链表的节点都已经加入了结果链表。元素加入堆中的复杂度为O（longk），
 * 总共有kn个元素加入堆中，因此，复杂度也和算法2一样是O（nklogk）
 * /
/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
class Solution {
private:
struct cmp
{
    bool operator ()(const ListNode *a, const ListNode *b)
    {
            return a->val > b->val;
    }
};
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int n = lists.size();
        if(n == 0)return NULL;
        ListNode node(0), *res = &node;
        priority_queue<ListNode*, vector<ListNode*>, cmp> que;
        for(int i = 0; i < n; i++)
            if(lists[i])
                que.push(lists[i]);
        while(!que.empty())
        {
            ListNode * p = que.top();
            que.pop();
            res->next = p;
            res = p;
             
            if(p->next)
                que.push(p->next);
        }
        return node.next;
    }
};
