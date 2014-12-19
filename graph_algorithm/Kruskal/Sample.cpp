#include <iostream>
#include "DisjointSets.h"
#include "DisjointSets.cpp"


using namespace std;
void printElementSets(const DisjointSets & s)
{
	for (int i = 0; i < s.NumElements(); ++i)
		cout << s.FindSet(i) << "  ";
	cout << endl;
}

int main()
{
	DisjointSets s(10);
	printElementSets(s);
	s.Union(s.FindSet(5),s.FindSet(3));
	printElementSets(s);
	s.Union(s.FindSet(1),s.FindSet(3));
	printElementSets(s);
	s.Union(s.FindSet(6),s.FindSet(7));
	printElementSets(s);
	s.Union(s.FindSet(8),s.FindSet(9));
	printElementSets(s);
	s.Union(s.FindSet(6),s.FindSet(9));
	printElementSets(s);
	s.AddElements(3);
	printElementSets(s);
	s.Union(s.FindSet(11),s.FindSet(12));
	printElementSets(s);
	s.Union(s.FindSet(9),s.FindSet(10));
	printElementSets(s);
	s.Union(s.FindSet(7),s.FindSet(11));
	printElementSets(s);

	return 0;
}
