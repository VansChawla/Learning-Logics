class MaximalRectangle {
    public int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            
            ans[i] = s.peek(); 
            s.push(i);         
        }
        
        return ans;
    }

    public int[] prevSmallerElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            
            ans[i] = s.peek();
            s.push(i); 
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights, int n) {
        int[] prev = prevSmallerElement(heights, n);
        int[] next = nextSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int l = heights[i];
            if(next[i] == -1)
                next[i] = n;
            
            int b = next[i] - prev[i] - 1;

            int maxArea = l*b;
            area = Math.max(area, maxArea);
        }

        return area;
    }

    public int maximalRectangle(char[][] matrix) { 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int n = matrix.length; 
        int m = matrix[0].length; 
        
        int[] heights = new int[m];
        for (int j = 0; j < m; j++) {
            heights[j] = matrix[0][j] - '0';
        }
        
        int area = largestRectangleArea(heights, m); 
        
        for (int i = 1; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (matrix[i][j] != '0') { 
                    heights[j] = heights[j] + 1; 
                } else { 
                    heights[j] = 0; 
                } 
            } 
            int newArea = largestRectangleArea(heights, m); 
            area = Math.max(area, newArea); 
        } 
        return area; 
    } 
}