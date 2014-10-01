class LRUCache{
   
//define the double linked list, each node stores both the key and value.
struct Node{
  Node* next;
  Node* prev;
  int value;
  int key;
  Node(Node* p, Node* n, int k, int val):prev(p),next(n),key(k),value(val){};
  Node(int k, int val):prev(NULL),next(NULL),key(k),value(val){};
};
 
 
map<int,Node*>mp; //map the key to the node in the linked list
int cp;  //capacity
Node* tail; // double linked list tail pointer
Node* head; // double linked list head pointer
 
 
 
public:
    //constructor
    LRUCache(int capacity) {
        cp = capacity;
        mp.clear();
        head=NULL;
        tail=NULL;
    }
     
    //insert node to the tail of the linked list
    void insertNode(Node* node){
        if (!head){
            head = node;
            tail = node;
        }else{
            tail->next = node;
            node->prev = tail;
            tail = tail->next;
        }
    }
 
    //remove current node
    void rmNode(Node* node){
        if (node==head){
            head = head->next;
            if (head){head->prev = NULL;}
        }else{
            if (node==tail){
                tail =tail->prev;
                tail->next = NULL;
            }else{
                node->next->prev = node->prev;
                node->prev->next = node->next;
            }
        }
    }
 
    // move current node to the tail of the linked list
    void moveNode(Node* node){
        if (tail==node){
            return;
        }else{
            if (node==head){
                node->next->prev = NULL;
                head = node->next;
                tail->next = node;
                node->prev = tail;
                tail=tail->next;
            }else{
                node->prev->next = node->next;
                node->next->prev = node->prev;
                tail->next = node;
                node->prev = tail;
                tail=tail->next;
            }
        }
    }
 
 
    ///////////////////////////////////////////////////////////////////////
    // get method
    ///////////////////////////////////////////////////////////////////////
    int get(int key) {
        if (mp.find(key)==mp.end()){
            return -1;
        }else{
            Node *tmp = mp[key];
            moveNode(tmp);
            return mp[key]->value;
        }
    }
 
    ///////////////////////////////////////////////////////////////////////
    // set method
    ///////////////////////////////////////////////////////////////////////
    void set(int key, int value) {
        if (mp.find(key)!=mp.end()){
            moveNode(mp[key]);
            mp[key]->value = value;
        }else{
            if (mp.size()==cp){
                mp.erase(head->key);
                rmNode(head);
            }
            Node * node = new Node(key,value);
            mp[key] = node;
            insertNode(node);
        }
    }
};
