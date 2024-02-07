# Thuật toán Quick Sort là gì?
Thuật toán Quick Sort là một thuật toán sắp xếp, còn được gọi là sắp xếp kiểu phân chia (Part Sort). Là một thuật toán hiệu quả dựa trên việc phân chia mảng dữ liệu thành các nhóm phần tử nhỏ hơn.

- Phân loại: Giải thuật sắp xếp
- Phức tạp thời gian: Trung bình O(n log n)
- Xấu nhất: O(n2)
- Phức tạp dữ liệu: Khác nhau tùy vào cách hiện thực
- Tối ưu: Thỉnh thoảng

# Ý tưởng 
Giải thuật sắp xếp nhanh chia mảng thành hai phần bằng cách so sánh từng phần tử của mảng với một phần tử được gọi là phần tử chốt. Một mảng bao gồm các phần tử nhỏ hơn hoặc bằng phần tử chốt và một mảng gồm các phần tử lớn hơn phần tử chốt.

Quá trình phân chia này diễn ra cho đến khi độ dài của các mảng con đều bằng 1. Với phương pháp đệ quy ta có thể sắp xếp nhanh các mảng con sau khi kết thúc chương trình ta được một mảng đã sắp xếp hoàn chỉnh.

![](/thuat-toan-sap-xep-quick-sort.png)

# Kỹ thuật chọn phần tử chốt
Kỹ thuật chọn phần tử chốt ảnh hưởng khá nhiều đến khả năng rơi vào các vòng lặp vô hạn đối với các trường hợp đặc biệt. Tốt nhất chọn phần tử chốt nằm ở trung vị của danh sách. Khi đó, sau log2(n) lần chia ta đạt được kích thưởng mảng con bằng 1.

Dưới đây là một số cách chọn phần tử chốt:

- Chọn phần tử đứng đầu hoặc đứng cuối làm phần tử chốt.
- Chọn phần tử đứng giữa danh sách làm phần tử chốt.
- Chọn phần tử trung vị trong ba phần tử đứng đầu, đứng giữa và đứng cuối làm phần tử chốt.
- Chọn phần tử ngẫu nhiên làm phần tử chốt. Tuy nhiên cách này rất dễ dẫn đến khả năng rơi vào các trường hợp đặc biệt.

# Triển khai
Trên thực tế, thuật toán QuickSort có rất nhiều cách triển khai nhưng chung quy lại, nó vẫn tuân thủ các quy tắc của ý tưởng trên (đều có phần tử chốt, đều áp dụng đệ quy, đều chia mảng thành từng phần nhỏ ). Chỉ là cách duyệt và thao tác lên dữ liệu có thể khác nhau. Một cách triển khai cụ thể là:
1. Chọn phần tử chốt.
2. Khai báo 2 biến con trỏ để duyệt 2 phía của phần tử chốt.
3. Biến bên trái trỏ đến từng phần tử mảng con __bên trái__ của phần tử chốt.
4. Biến bên phải trỏ đến từng phần tử mảng con __bên phải__ của phần tử chốt.
5. Khi biến bên trái _lớn hơn_ phần tử chốt thì di chuyển __sang phải__.
6. Khi biến bên phải _nhỏ hơn_ phần tử chốt thì di chuyển __sang trái__.
6. Nếu không xảy ra trưởng hợp 5 và 6 thì tráo đổi giá trị 2 biến trái và phải.
7. Nếu trái lớn hơn phải thì đây là giá trị chốt mới

Source code 
``````
public class QuickSort {
  public static void main(String[] args) {
    int[] x = {6, 2, 3, 4, 5, 9, 1};
    printArray(x);

    int left = 0;
    int right = x.length - 1;

    quickSort(x, left, right);
    printArray(x);
  }

  public static void quickSort(int[] arr, int left, int right) {
    if (arr == null || arr.length == 0)
      return;

    if (left >= right)
      return;

    int middle = left + (right - left) / 2;
    int pivot = arr[middle];
    int i = left, j = right;

    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (left < j)
      quickSort(arr, left, j);

    if (right > i)
      quickSort(arr, i, right);
  }

  public static void printArray(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }
}
```````

Một cách thứ hải