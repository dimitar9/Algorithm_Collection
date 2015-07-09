1. BFS(Topological Sort)

bool canFinish(int numCourses, vector<vector<int>>& prerequisites)
{
    vector<unordered_set<int>> matrix(numCourses); // save this directed graph
    for(int i = 0; i < prerequisites.size(); ++ i)
        matrix[prerequisites[i][1]].insert(prerequisites[i][0]);

    vector<int> d(numCourses, 0); // in-degree
    for(int i = 0; i < numCourses; ++ i)
        for(auto it = matrix[i].begin(); it != matrix[i].end(); ++ it)
            ++ d[*it];

    for(int j = 0, i; j < numCourses; ++ j)
    {
        for(i = 0; i < numCourses && d[i] != 0; ++ i); // find a node whose in-degree is 0

        if(i == numCourses) // if not find
            return false;

        d[i] = -1;
        for(auto it = matrix[i].begin(); it != matrix[i].end(); ++ it)
            -- d[*it];
    }

    return true;
}
2. DFS(Finding cycle)

bool canFinish(int numCourses, vector<vector<int>>& prerequisites)
{
    vector<unordered_set<int>> matrix(numCourses); // save this directed graph
    for(int i = 0; i < prerequisites.size(); ++ i)
        matrix[prerequisites[i][1]].insert(prerequisites[i][0]);

    unordered_set<int> visited;
    vector<bool> flag(numCourses, false);
    for(int i = 0; i < numCourses; ++ i)
        if(!flag[i])
            if(DFS(matrix, visited, i, flag))
                return false;
    return true;
}
bool DFS(vector<unordered_set<int>> &matrix, unordered_set<int> &visited, int b, vector<bool> &flag)
{
    flag[b] = true;
    visited.insert(b);
    for(auto it = matrix[b].begin(); it != matrix[b].end(); ++ it)
        if(visited.find(*it) != visited.end() || DFS(matrix, visited, *it, flag))
            return true;
    visited.erase(b);
    return false;
}



//3// OO solution
public class Solution {
    static class Course {
        private boolean vis;
        private boolean done;
        private ArrayList<Course> pre = new ArrayList<Course>();

        void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        boolean isCyclic() {
            if( done ) {
                return false;
            }
            if( vis ) {
                return true;
            }
            vis = true;

            for(Course preCourse: pre ) {
                if( preCourse.isCyclic() ) {
                    return true;
                }
            }

            vis = false;
            done = true;
            return false;
        }
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course clist[] = new Course[numCourses];

        for(int i=0; i<numCourses; i++) {
            clist[i] = new Course();
        }

        for(int[] couple: prerequisites ) {
            Course c1 = clist[couple[0]];
            Course c2 = clist[couple[1]];
            c1.addPre(c2);
        }

        for(int i=0; i<numCourses; i++) {
            if( clist[i].isCyclic() ) {
                return false;
            }
        }

        return true;
    }
}
