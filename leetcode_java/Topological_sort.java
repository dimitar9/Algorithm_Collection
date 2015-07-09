import java.util.*;

//An algorithm for Topological Sort
//Programmed by Sung

public class TopologicalSort {

	Stack stk;
	Vertex [] stkArray;
	int c;

	public TopologicalSort() {
		stk =new Stack();
		c=1;
	}


	void dfs(Vertex v) {
		System.out.println("Visiting "+v.getName());
		//mark v visited
		v.setVisited();
		//get the number of OUT(V)
		int numouts=v.getOutsNum();

		//copies v.getOuts(i), the out vertices of v, to a temporary array outs[i]
		Vertex [] outs= new Vertex[numouts+1];
		for (int i=1;i<=numouts;i++) outs[i]=v.getOuts(i);

		//for each w in OUT(v) do
		for (int i=1;i<=numouts;i++) {
			Vertex w=outs[i];
			System.out.println(v.getName()+" now looks at "+w.getName());

			//if w is unvisited then dfs(w)
			if(!w.isVisited()) {
				dfs(w);
			}
		}
		//push(v) into STACK
		stk.push(v); System.out.println("STACK: "+v.getName()+" pushed");

	}




	public static void main(String[] args){
		TopologicalSort ts=new TopologicalSort();

		////////////////////////////////////////
		// GRAPH LOADING START
		////////////////////////////////////////

		int numVertex=6;

		Vertex[] V= new Vertex[numVertex+1];

		V[1]=new Vertex('1');
		V[2]=new Vertex('2');
		V[3]=new Vertex('3');
		V[4]=new Vertex('4');
		V[5]=new Vertex('5');
		V[6]=new Vertex('6');



		//1-> 2,3
		V[1].setOuts(V[3]);
		V[1].setOuts(V[2]);


		//2->3,4
		V[2].setOuts(V[4]);
		V[2].setOuts(V[3]);

		//3->5
		V[3].setOuts(V[5]);


		//4->6
		V[4].setOuts(V[6]);

		//5->4,6
		V[5].setOuts(V[6]);
		V[5].setOuts(V[4]);

		//////////////////////////////////////////
		// GRAPH LOADING END
		//////////////////////////////////////////


		//Check if the graph is correctly loaded
		for (int i=1;i<=numVertex;i++) {
			System.out.print(V[i].getName()+"=>");
			for (int j=1;j<=V[i].getOutsNum();j++) {
				System.out.print(V[i].getOuts(j).getName()+",");
			}
			System.out.println();
		}
		//while there is an "unvisited" v do dfs(v)
		int i=0;
		while(i<numVertex) {
			for (i=1;i<=numVertex;i++) {
				if(!V[i].isVisited()) ts.dfs(V[i]);
			}
		}
		//pop() until STACK=empty and write
		i=0;
		while(i<numVertex) {
			Vertex v=(Vertex) ts.stk.pop(); i++;
			System.out.println("Pops out "+v.getName()+" ");
		}

		System.out.flush();

	}
}

class Vertex {
	char name;
	Vertex [] Outs;
	int numOuts;
	int N;
	int L;
	boolean visited=false;


	public Vertex(char v) {
		name=v;
		numOuts=0;
		Outs = new Vertex[100];
	}

	public char getName() {
		return name;
	}

	public void setOuts(Vertex v) {
		numOuts++;
		Outs[numOuts]=v;
	}
	public int getOutsNum() {
		return numOuts;
	}

	public Vertex getOuts(int i) {
		return Outs[i];
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited() {
		visited=true;
	}
	public void setL(int v) {
		L=v;
	}
	public void setN(int v) {
		N=v;
	}
	public int getL() {
		return L;
	}
	public int getN() {
		return N;
	}

	public void display() {
		System.out.print(name);
		System.out.println("  N:"+N+" L:"+L);
	}


}
