public void bfs()
{
    //BFS uses Queue data structure
    Queue q=new LinkedList();
    q.add(this.rootNode);
    printNode(this.rootNode);
    rootNode.visited=true;
    while(!q.isEmpty())
    {
        Node n=(Node)q.remove();
        Node child=null;
        while((child=getUnvisitedChildNode(n))!=null)
        {
            child.visited=true;
            printNode(child);
            q.add(child);
        }
    }
    //Clear visited property of nodes
    clearNodes();
}
public void dfs()
{
    //DFS uses Stack data structure
    Stack s=new Stack();
    s.push(this.rootNode);
    rootNode.visited=true;
    printNode(rootNode);
    while(!s.isEmpty())
    {
        Node n=(Node)s.peek();
        Node child=getUnvisitedChildNode(n);
        if(child!=null)
        {
            child.visited=true;
            printNode(child);
            s.push(child);
        }
        else
        {
            s.pop();
        }
    }
    //Clear visited property of nodes
    clearNodes();
}
