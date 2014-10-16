// root node is '\0'
struct TrieNode {
    bool operator>(TrieNode* n) const { return frequency > n->frequency; }
    TrieNode (int _fre): frequency(_fre) {}
    TrieNode (char _v) : val(_v), frequency(0) {}
    TrieNode (char _v, int _fre) : val(_v), frequency(_fre) {}
     
    char val;
    string word; // word ended with the corresponding node
    int frequency; // word frequency
    map<char, TrieNode*> children;
};
 
void insertTrieNode(TrieNode* root, string s, priority_queue<TrieNode*, vector<TrieNode*> >& q, int k){
    string::iterator it = s.begin();
    TrieNode* node = root;
    bool new_added = false;
    while (it != s.end()) {
        if (node->children.find(*it) != node->children.end()) {
            node = node->children[*it];
        } else {
            new_added = true;
            node->children[*it] = new TrieNode(*it);
            node = node->children[*it];
        }
        it++;
    }
    node->word = s;
    node->frequency = node->frequency + 1;
    if (q.size() == k) {
        if (!new_added) {
            TrieNode* max = new TrieNode(INT_MAX);
            q.emplace(max);
            q.pop();
        } else {
            if (node > q.top()) {
                q.pop();
                q.emplace(node);
            }
        }
    } else
        q.emplace(node);
}
 
int findTrieNode(TrieNode* root, string s) {
    TrieNode* node = root;
    for (char c : s) {
        if (node->children.find(c) == node->children.end())
            return -1;
        else
            node = node->children1;
    }
    return node->frequency;
}
