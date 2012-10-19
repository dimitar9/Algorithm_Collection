/*
 test   ASSUMPTIONS:
        All characters are case insensitive
    ENHANCEMENTS:
        Auto correction of word
        Display all words in postorder
 
    SAMPLE DATA: - ALGO, ALL, ALSO, ASSOC, TREE, TRIE
 
                                +--> [G] ---+--> [O]
                                |
                    +--> [L] ---+--> [L]
                    |           |
        +--> [A] ---+           +--> [S] ---+--> [O]
        |           |
        |           +--> [S] ---+--> [S] ---+--> [O] ---+--> [C]
[\0] ---+
        |                       +--> [E] ---+--> [E]
        |                       |
        +--> [T] ---+--> [R] ---+
                                |
                                +--> [I] ---+--> [E]
 
*/
 
#include <iostream>
#include <cctype>
 
using namespace std;
 
class trie
{
    private:
        struct node
        {
            char  character;       // character of the node
            bool  eow;             // indicates a complete word
            int   prefixes;        // indicates how many words have the prefix
            node* edge[26];        // references to all possible sons
        }*root;                        // trie root node
 
        void preorder_display(node *); // preorder display
        void truncate_node(node *);    // Deletes node and sub-nodes
        void delete_node(node *);      // Deletes node if prefixes is 1
 
    public:
        trie();                        // constructor
        ~trie();                       // destructor
 
        void insert_word(char *);      // to insert a word
        void delete_word(char *);      // to delete a word
        bool search_word(char *);      // to search a word
 
        void display();                // display complete trie
};
 
trie::trie()
{
    root = new node();
    root->character = '\0';
    root->prefixes = 0;
    root->eow = false;
    for(int i=0;i<26;i++)
    {
        root->edge[i] = NULL;
    }
}
 
trie::~trie()
{
    truncate_node(root);
}
 
void trie::truncate_node(node* n)
{
    for(int i=0;i<26;i++)
    {
        if(n->edge[i] != NULL)
        {
            truncate_node(n->edge[i]);
        }
    }
    delete n;
}
 
void trie::insert_word(char* s)
{
    node *t = root;
    while(*s != '\0')
    {
        int c = toupper(*s) - 'A';
        if(t->edge[c] == NULL)
        {
            node* n = new node();
            n->character = *s;
            n->eow = false;
            n->prefixes = 1;
            for(int i=0;i<26;i++)
            {
                n->edge[i] = NULL;
            }
            t->edge[c] = n;
            t = n;
        }
        else
        {
            t = t->edge[c];
            t->prefixes++;
        }
        *s++;
    }
    t->eow = true;
}
 
bool trie::search_word(char* s)
{
    node *t = root;
    while(*s != '\0')
    {
        int c = toupper(*s) - 'A';
        if(t->edge[c] == NULL)
        {
            return false;
        }
        else
        {
            t = t->edge[c];
        }
        *s++;
    }
    if(t->eow == true)
        return true;
    else
        return false;
}
 
void trie::delete_word(char* s)
{
    node* t = root;
    while(*s != '\0')
    {
        int c = toupper(*s) - 'A';
        if(t->edge[c] == NULL)
        {
            return;
        }
        else if(t->edge[c]->prefixes == 1)
        {
            truncate_node(t->edge[c]);
            t->edge[c] = NULL;
            return;
        }
        else
        {
            t = t->edge[c];
        }
        *s++;
    }
}
 
void trie::display()
{
    preorder_display(root);
}
 
void trie::preorder_display(node* t)
{
    if(t == NULL)
        return;
 
    cout << "iterating :: " << t->character << " :: " << t->eow << " :: " << t->prefixes << endl;
 
    for(int i=0;i<26;i++)
    {
        if(t->edge[i] != NULL)
            preorder_display(t->edge[i]);
    }
} 





int main()
{
    trie mytrie;
    char *s[] = {"tree","trie","algo","assoc","all","also","ass"};
    for(int i=0;i<sizeof(s)/sizeof(*s);i++)
    {
        mytrie.insert_word(s[i]);
    }
 
    mytrie.display();
 
    if(mytrie.search_word("all") == true) cout << "all exist" << endl;
    else cout << "all do not exist" << endl;
 
    mytrie.delete_word("all");
 
    if(mytrie.search_word("all") == true) cout << "all exist" << endl;
    else cout << "all do not exist" << endl;
 
    mytrie.display();
}
