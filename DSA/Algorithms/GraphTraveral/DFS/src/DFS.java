public void DFS_recur(int v, boolean[] visited){
    visited[v] = true;

    System.out.print(v + " ");

    for(int i = 0; i < NUMBER_OF_VERTICES; i++){
    if(adj[v][i] != 0 && visited[i] == false){
    DFS_recur(i, visited);
    }
     }
     }
    
     public void DFS(int s){
     boolean[] visited = new boolean[NUMBER_OF_VERTICES];
     DFS_recur(s, visited);
     }