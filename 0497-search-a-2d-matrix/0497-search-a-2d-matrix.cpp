class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int height = matrix.size();
        int width = 0;
        int start = 0;
        int stop = height - 1;
        int middle = 0;
        
        if (height == 0) {
            return false;
        }
        
        width = matrix[0].size();
        if (0 == width) {
            return false;
        }
        
        if (height == 1) {
            return searchLine(matrix[0], target);
        }
        
        if ((matrix[0][0] > target) || (matrix[height - 1][width - 1] < target)) {
            return false;
        }
        
        while (start <= stop) {
            middle = (start + stop) / 2;
            if (matrix[middle][0] == target) {
                return true;
            }
            
            if (matrix[middle][0] > target) {
                stop = middle - 1;
                continue;
            }
            
            start = middle + 1;
        }
        
        return searchLine(matrix[stop], target);
    }
    
    bool searchLine(vector<int>& line, int target) {
        int start = 0;
        int stop = line.size() - 1;
        int middle = 0;
        
        if ((line[0] > target) || (line[line.size() - 1] < target)) return false;
        
        while (start <= stop) {
            middle = (start + stop) / 2;
            if (line[middle] == target) {
                return true;
            } else if (line[middle] > target) {
                stop = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        return false;
    }
};