struct RandomListNode{
	int label;
	RandomListNode *next, *random;
	RandomListNode(int x): label(x), next(NULL),random(NULL){}
};

RandomListNode* copyRandomList(RandomListNode* head) {

	if (!head) { return NULL;}
	map<RandomListNode*, RandomListNode*> mp;
	mp.clear();
	RandomListNode* res = new RandomListNode(0);
	RandomListNode* p=head;
	RandomListNode* q=res;

	while(p) {
		RandomListNode* tmp = new RandomListNode(p->label);
		q->next = tmp;
		mp[p] = tmp;
		p = p->next;
		q = q->next;
	}
	p = head;
	q = res->next;
	while(p){
		if(p->random==NULL){
			q->random = NULL;
		} else {
			q->random = mp[p->random];
		}	
		p = p->next;
		q = q->next;
	}
	return res->next;
}
