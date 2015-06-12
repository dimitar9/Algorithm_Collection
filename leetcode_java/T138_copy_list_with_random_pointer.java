// An intuitive solution is to keep a hash table for each node in the list, via which we just need to iterate the list in 2 rounds respectively 
//to create nodes and assign the values for their random pointers. As a result, the space complexity of this solution is O(N), although with a linear time complexity.

// As an optimised solution, we could reduce the space complexity into constant. The idea is to associate the original node with its copy node in a 
//single linked list. In this way, we don't need extra space to keep track of the new nodes.

// The algorithm is composed of the follow three steps which are also 3 iteration rounds.

// Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
// Iterate the new list and assign the random pointer for each duplicated node.
// Restore the original list and extract the duplicated nodes.
// The algorithm is implemented as follows:

public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode iter = head, next;

    // First round: make copy of each node,
    // and link them together side-by-side in a single list.
    while (iter != null) {
        next = iter.next;

        RandomListNode copy = new RandomListNode(iter.label);
        iter.next = copy;
        copy.next = next;

        iter = next;
    }

    // Second round: assign random pointers for the copy nodes.
    iter = head;
    while (iter != null) {
        if (iter.random != null) {
            iter.next.random = iter.random.next;
        }
        iter = iter.next.next;
    }

    // Third round: restore the original list, and extract the copy list.
    iter = head;
    RandomListNode pseudoHead = new RandomListNode(0);
    RandomListNode copy, copyIter = pseudoHead;

    while (iter != null) {
        next = iter.next.next;

        // extract the copy
        copy = iter.next;
        copyIter.next = copy;
        copyIter = copy;

        // restore the original list
        iter.next = next;

        iter = next;
    }

    return pseudoHead.next;
}


