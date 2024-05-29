class Graph:
    def __init__(self, num_vertice):
        self.V = num_vertice
        self.edge_list = []
        
    def add_edge(self, u,v,w):
        self.edge_list.append([u, v, w])
    
    def __str__(self):
        return ''.join(f"{edge}\n" for edge in self.edge_list)
    
    # union find
    def find_set(self, p, x ):
        if x != p[x]:
            p[x] = self.find_set(p, p[x])
        return p[x]
        
    def union(self, p, rank, x, y):
        
        A = self.find_set(p, x)
        B = self.find_set(p, y)
        
        if rank[A] > rank[B]:
            p[B] = A
            
        elif rank[A] < rank[B]:
            p[A] = B
            
        else:
            p[B] = A
            rank[A] += 1
        
    # kruskal
    
    def kruskal(self):
        sorted_edge = sorted(self.edge_list, key= lambda e: e[2])
        p = []
        rank = []
        
        for i in range(self.V):
            p.append(i)
            rank.append(0)
        mst = []
        
        for egde in sorted_edge:
            u,v,w = egde
            print('find_set(', u ,'): ',self.find_set(p, u))
            print('find_set(', v ,'): ',self.find_set(p, v))
            if self.find_set(p, u) != self.find_set(p, v):
                self.union(p, rank, u, v)
                print(p)
                
                mst.append([u,v,w])
        return mst
        
    
        
g = Graph(5)      
g.add_edge(2, 3, 3)
g.add_edge(1, 3, 5)
g.add_edge(1, 4, 7)
g.add_edge(0, 2, 8)
g.add_edge(0, 1, 10)

map = {
    0: 'A',
    1: 'B',
    2: 'C',
    3: 'D',
    4: 'E'
}

mst = g.kruskal()
cost = 0
for edge in mst:
    u, v, w = edge
    # edge[0] = map[u]
    # edge[1] = map[v]
    cost+= w

print(mst)
print(cost)