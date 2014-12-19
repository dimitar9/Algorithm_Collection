#include "DisjointSets.h"

DisjointSets::DisjointSets()
{
	m_numElements = 0;
	m_numSets = 0;
}

DisjointSets::DisjointSets(int count)
{
	m_numElements = 0;
	m_numSets = 0;
	AddElements(count);
}

DisjointSets::DisjointSets(const DisjointSets & s)
{
	this->m_numElements = s.m_numElements;
	this->m_numSets = s.m_numSets;

	m_nodes.resize(m_numElements);
	for(int i = 0; i < m_numElements; ++i)
		m_nodes[i] = new TreeNode(*s.m_nodes[i]);

	for(int i = 0; i < m_numElements; ++i)
		if(m_nodes[i]->parent != NULL)
			m_nodes[i]->parent = m_nodes[s.m_nodes[i]->parent->index];
}

DisjointSets::~DisjointSets()
{
	for(int i = 0; i < m_numElements; ++i)
		delete m_nodes[i];
	m_nodes.clear();
	m_numElements = 0;
	m_numSets = 0;
}

int DisjointSets::FindSet(int elementId) const
{

	TreeNode* curNode;

	curNode = m_nodes[elementId];
	while(curNode->parent != NULL)
		curNode = curNode->parent;
	TreeNode* root = curNode;

	curNode = m_nodes[elementId];
	while(curNode != root)
	{
		TreeNode* next = curNode->parent;
		curNode->parent = root;
		curNode = next;
	}

	return root->index;
}

void DisjointSets::Union(int setId1, int setId2)
{
	if(setId1 == setId2)
		return; 

	TreeNode* set1 = m_nodes[setId1];
	TreeNode* set2 = m_nodes[setId2];

	if(set1->rank > set2->rank)
		set2->parent = set1;
	else if(set1->rank < set2->rank)
		set1->parent = set2;
	else 
	{
		set2->parent = set1;
		++set1->rank; 
	}

	--m_numSets;
}

void DisjointSets::AddElements(int numToAdd)
{

	m_nodes.insert(m_nodes.end(), numToAdd, (TreeNode*)NULL);
	for(int i = m_numElements; i < m_numElements + numToAdd; ++i)
	{
		m_nodes[i] = new TreeNode();
		m_nodes[i]->parent = NULL;
		m_nodes[i]->index = i;
		m_nodes[i]->rank = 0;
	}

	m_numElements += numToAdd;
	m_numSets += numToAdd;
}

int DisjointSets::NumElements() const
{
	return m_numElements;
}

int DisjointSets::NumSets() const
{
	return m_numSets;
}
