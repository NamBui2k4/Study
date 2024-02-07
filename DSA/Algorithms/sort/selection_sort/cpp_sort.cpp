#include <iostream>
using namespace std;

void selection_sort(int arr[], int n ){ 
      for(int i = 0; i < n - 1; i++){
         int min_idx = i;
         for(int j = i+1; j < n; j++) {
            if(arr[j] < arr[min_idx])
               min_idx = j;
         }
         int temp = arr[min_idx];
         arr[min_idx] = arr[i];
         arr[i] = temp;
      }
}

int main(){
   int arr[] = {27, 38, 12, 39, 27 ,16};
   int n = sizeof(arr) / sizeof(arr[0]);
   selection_sort(arr,n);
   
   for(int i = 0; i < n ; i++){
      cout << arr[i] << " ";
   }
}

   
