class Main {
    public int minimumEffortPath(int[][] heights) {
        int[][] moves = {
                {-1,0},
        {0,-1},         {0,1},
                {1,0}
        };
        int x = 0,y = 0;

        while(x < heights.length && y < heights[0].length ){
            int goRight = heights[x][y+1] - heights[x][y];
            int goDown = heights[x+1][y] - heights[x][y];
            if(goRight < goDown){
                
                y = y + 1;
            }
            

        }
    }
}