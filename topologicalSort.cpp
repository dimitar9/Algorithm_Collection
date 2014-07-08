#include <iostream>
#include <stdio.h>
#include <list>
#include <stack>

using namespace std;

class Graph {
    int V;
    list<int>* adj;
    void _topological_sort(int v, bool visited[], stack<int>& stack);
public:
    Graph(int v);
    ~Graph();
    void addEdge(int v, int w);
    void Topological_sort();
};

Graph::Graph(int v):V(v) {
    adj = new list<int>[V];
}

Graph::~Graph() {
    delete [] adj;
}

void Graph::addEdge(int v, int w) {
    adj[v].push_back(w);
}

void Graph::_topological_sort(int v, bool visited[], stack<int>& stack) {
    visited[v] = true;
    for(list<int>::iterator it = adj[v].begin(); it != adj[v].end(); ++it) {
        int u = *it;
        if(visited[u] == false)
            _topological_sort(u, visited, stack);
    }
    stack.push(v);
}

void Graph::Topological_sort() {
    bool visited[V];
    stack<int> stack;
    for(int i=0; i<V; i++)
        visited[i] = false;
    for(int i=V-1; i>=0; i--) {
        if(visited[i] == false) {
            _topological_sort(i, visited, stack);
        }
    }
    while(!stack.empty()) {
        int v = stack.top();
        stack.pop();
        std::cout << " " << v << " ";
    }
    std::cout << std::endl;
}

int main() {
    Graph g(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    cout << "Following is topological sort result: \n";
    g.Topological_sort();
    return 0;
}
