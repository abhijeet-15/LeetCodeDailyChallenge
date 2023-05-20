class Pair {
    String first;
    double second;
    
    Pair(String _first, double _second) {
        this.first = _first;
        this.second = _second;
    }
}


class Solution {
    
    private double ans = -1.0;
    
    private void DFS(String src, String des, Set<String> visited, Map<String, List<Pair>> adj, double product) {
        
        if(visited.contains(src)) {
            return;
        }
        
        visited.add(src);
        
        if(src.equals(des)) {
            ans = product;
            return;
        }
        
        for(Pair pair : adj.get(src)) {
            String v = pair.first;
            double val = pair.second;
            
            DFS(v,des,visited,adj,product*val);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, List<Pair>> adj = new HashMap<>();
        
        //Make the graph
        for(int i=0; i<n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];
            
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(new Pair(v, value));
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(new Pair(u, 1.0/value));
        }
        
        int N = queries.size();
        double[] result = new double[N];
        
        int pos = 0;
        
        for(int i=0 ; i<N; i++) {
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);

            double product = 1.0;
            
            if(adj.containsKey(src)) {
                if(src.equals(des)) {
                    ans= 1.0;
                }
                else {       
                    Set<String> visited = new HashSet<>();
                    DFS(src,des,visited,adj,product);
                }
            }
            result[i] = ans;
            ans=-1.0;
        }        
        return result;
        
    }
}