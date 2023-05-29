#include <bits/stdc++.h>
using namespace std;

class Graph {
public:
    int v;
    list<int>* l;
    bool* visited;

    Graph(int v) {
        this->v = v;
        l = new list<int>[v];
        visited = new bool[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
    }

    void bfs(int v);
    void addEdge(int x, int y) {
        l[x].push_back(y);
        l[y].push_back(x);
    }
};

void Graph::bfs(int v) {
    queue<int> q;
    q.push(v);
    visited[v] = true;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        cout << curr << " ";

        for (auto i = l[curr].begin(); i != l[curr].end(); i++) {
            if (!visited[*i]) {
                visited[*i] = true;
                q.push(*i);
            }
        }
    }
}

int main() {
    int v;
    cout << "Enter the number of vertices: ";
    cin >> v;

    int e;
    cout << "Enter the number of edges: ";
    cin >> e;

    Graph g(v);
    int a, b;
    cout << "Enter the edges: ";
    for (int i = 0; i < e; i++) {
        cin >> a >> b;
        g.addEdge(a, b);
    }

    cout << "The BFS traversal is: ";
    g.bfs(0);

    return 0;
}