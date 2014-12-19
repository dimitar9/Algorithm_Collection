/*  Disjoint Set 
**  @Author: X
**  Date: Dec,19th,2014 
*/
#ifndef _DISJOINT_SETS_
#define _DISJOINT_SETS_
#include <vector>
class DisjointSets
{
public:

	DisjointSets();
	DisjointSets(int count);
    DisjointSets(const DisjointSets & s);
	~DisjointSets();

	int FindSet(int element) const;
	void Union(int setId1, int setId2);
	void AddElements(int numToAdd);
	int NumElements() const;
	int NumSets() const;

private:

	struct TreeNode
	{
		int rank;
		int index; 
		TreeNode* parent; 
	};

	int m_numElements;
	int m_numSets; 
	std::vector<TreeNode*> m_nodes; 
};
#endif
