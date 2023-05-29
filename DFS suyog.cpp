#include<iostream>
#include<list>
#include<stack>    // standard templete lib
using namespace std;

class Graph {    
public:
    int V;
    bool* visited;
    list<int>* l;

    Graph(int V) {                //initalize data members
        this->V = V;
        l = new list<int>[V];
        visited = new bool[V];     // to initialize visited array to  false value
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
    }

    void addEdge(int v, int u) {
        l[v].push_back(u); //create graph and adding edge
        l[u].push_back(v);
    }

    void dfs(int v) {
        visited[v] = true;
        cout << v << " ";
        list<int>::iterator i;  //to traverse list
        for (i = l[v].begin(); i != l[v].end(); i++) {
            if (!visited[*i]) {
                dfs(*i);
            }
        }
    }
};

int main() {
    int v, e;
    cout << "Enter the number of vertices: ";
    cin >> v;
    Graph g(v);

    

    cout << "Enter the number of edges: ";
    cin >> e;

    cout << "Enter edges (vertex1 vertex2):" << endl;
    int a, b ;
    for (int i = 0; i < e; i++) {
        cin >> a >> b;
        g.addEdge(a, b);
    }

    cout << "DFS traversal starting from vertex 0: ";
    g.dfs(0);

    return 0;
}