	/*Kruskal algorithm -- a MST method*/

	#include <string>
	#include <iostream>
	#include <algorithm>
	#include <cstdio>
	#include "DisjointSets.h"
	#include "DisjointSets.cpp"

	using namespace std;

	class Edge
	{
	public:
		int src, dst, weight;
	};

	class Graph
	{
		public:
		bool initGraph(int V, int E);
		void KruskalMST();
	public:
		int V, E;
		vector<Edge> edges;
	};


	bool Graph::initGraph(int V, int E)
	{
		this->V = V;
		this->E = E;
		edges.resize(E);

		return true;
	}

	struct less_than_key
	{
		inline bool operator() (const Edge& struct1, const Edge& struct2)
		{
			return (struct1.weight < struct2.weight);
		}
	};
	void Graph::KruskalMST()
	{
		int V = this->V;
		//create V seperate nodes in DisjointSet
		DisjointSets* dSet = new DisjointSets(V);
		vector<Edge> result(V);
		int e = 0;
		int i = 0;

		//sort
	//    sort(edges.begin(), edges.end(),
	//        [](const Edge & a, const Edge & b) -> bool
	//    {
	//        return a.weight > b.weight;
	//    });

		sort(edges.begin(), edges.end(), less_than_key());
		while( e < V-1) {
			Edge cur_edge = this->edges[i++];
			int set_a = dSet->FindSet(cur_edge.src);
			int set_b = dSet->FindSet(cur_edge.dst);

			cout << set_a << " " << set_b << endl;
			if(set_a != set_b)
			{
				result[e++] = cur_edge;
				dSet->Union(cur_edge.src, cur_edge.dst);
				cout << "after union[0 1 2 3] " << dSet->FindSet(0) << dSet->FindSet(1) << dSet->FindSet(2) << dSet->FindSet(3)<< endl;

			}
		}

		cout << "Following are the edges in the constructed MSG \n" << endl;
		for(int i = 0; i < e; i++)
		{
			printf("%d -- %d  == %d \n", result[i].src, result[i].dst,
										result[i].weight);
		}
		return;
	}

	int main()
	{
			/* Let us create following weighted graph
				  10
			 0--------1
			 |  \     |
			6|   5\   |15
			 |      \ |
			 2--------3
				 4       */

		int V = 4;
		int E = 5;
		Graph graph;
		graph.initGraph(V,E);

		// add edge 0-1

		graph.edges[0].src = 0;
		graph.edges[0].dst = 1;
		graph.edges[0].weight = 10;

		// add edge 0-2
		graph.edges[1].src = 0;
		graph.edges[1].dst = 2;
		graph.edges[1].weight = 6;

		// add edge 0-3
		graph.edges[2].src = 0;
		graph.edges[2].dst = 3;
		graph.edges[2].weight = 5;

		// add edge 1-3
		graph.edges[3].src = 1;
		graph.edges[3].dst = 3;
		graph.edges[3].weight = 15;

		// add edge 2-3
		graph.edges[4].src = 2;
		graph.edges[4].dst = 3;
		graph.edges[4].weight = 4;

		graph.KruskalMST();

		return 0;






	}

