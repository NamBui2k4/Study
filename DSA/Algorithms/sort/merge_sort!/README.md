# Merge Sort – Sắp xếp trộn

_By Nguyễn Văn Hiếu 18/07/2018_

Thuật toán sắp xếp merge sort là một trong những thuật toán có độ phức tạp ở mức trung bình và cùng sử dùng phương pháp __chia để trị__ giống thuật toán sắp xếp nhanh quick sort. Thuật toán này không chỉ áp dụng trong sắp xếp mà còn ở nhiều bài toán khác. Hãy cùng tìm tôi tìm hiểu nhé.

Chào mừng các bạn quay trở lại với blog của Nguyễn Văn Hiếu. Đây là một bài viết trong series các thuật toán sắp xếp có minh họa code sử dụng ngôn ngữ lập trình C++.

Ở bài viết này Nguyễn Văn Hiếu xin giới thiệu tới các bạn thuật toán sắp xếp merge sort. Đây là một thuật toán rất sắp xếp rất hay và có độ phức tạp thấp hơn.

_Lưu ý: Bài viết chỉ mô tả cho việc sắp xếp dãy số tăng dần. Việc sắp xếp dãy số giảm dần sẽ tương tự và bạn đọc tự tìm hiểu_

# Ý tưởng của thuật toán merge sort

Giống như Quick sort, Merge sort là một thuật toán chia để trị. Thuật toán này chia mảng cần sắp xếp thành 2 nửa. Tiếp tục lặp lại việc này ở các nửa mảng đã chia. Sau đó gộp các nửa đó thành mảng đã sắp xếp. Hàm merge() được sử dụng để gộp hai nửa mảng. Hàm merge(arr, l, m, r) là tiến trình quan trọng nhất sẽ gộp hai nửa mảng thành 1 mảng sắp xếp, các nửa mảng là arr[l…m] và arr[m+1…r] sau khi gộp sẽ thành một mảng duy nhất đã sắp xếp.

Hãy xem ý tưởng triển khai code dưới đây để hiểu hơn
```
mergeSort(arr[], l,  r)
If r > l
    1. Tìm chỉ số nằm giữa mảng để chia mảng làm đôi:
             middle m = (l+r)/2
    2. Gọi đệ quy hàm mergeSort cho nửa đầu tiên:   
             mergeSort(arr, l, m)
    3. Gọi đệ quy hàm mergeSort cho nửa thứ hai:
             mergeSort(arr, m+1, r)
    4. Gộp 2 nửa mảng đã sắp xếp ở (2) và (3):
             merge(arr, l, m, r)
```

Hình ảnh dưới đây từ wikipedia sẽ hiển thị cho bạn toàn bộ sơ đồ tiến trình của thuật toán merge sort cho mảng {38, 27, 43, 3, 9, 82, 10}. Nếu nhìn kỹ hơn vào sơ đồ này, chúng ta có thể thấy mảng ban đầu được lặp lại hành động chia cho tới khi kích thước các mảng sau chia là 1. Khi kích thước các mảng con là 1, tiến trình gộp sẽ bắt đầu thực hiện gộp lại các mảng này cho tới khi hoàn thành và chỉ còn một mảng đã sắp xếp.

![](/pictures/merge_sort.png)

# Cách hàm merge hoạt động khi gộp hai mảng con

Với trường hợp khi 2 mảng con chỉ có 1 phần tử, ta chỉ việc xem phần tử nào nhỏ hơn và đẩy lên đầu, phần tử còn lại đặt phía sau. Do vậy, các mảng con cần gộp lại có tính chất luôn được sắp tăng dần.

Giả sử ta có 2 mảng con là 

- $ arr_1 $ = [1, 9, 10, 10] 

- $ arr_2 $ = [3, 5, 7, 9]

Khởi tạo i = j = 0 tương ứng là chỉ số bắt đầu của $ arr_1 $ và $ arr_2 $

Một mảng lưu lại tiến trình gộp:

- sort_arr = [_____________] 

ta có:

- Lần thứ nhất (i = j = 0):  
    + $arr_1[i] < arr_2[j]$ , tức là $ 1 < 3 $

    + chèn $arr_1[i]$ vào đầu mảng sort_arr

    + tăng i thêm 1 đơn vị

_Kết quả: Mảng sort_arr = [1]_

- Lần thứ hai (i = 1, j = 0)

    + $arr_1[i] > arr_2[j]$, tức là $ 9 > 3 $

    + chèn $ arr_2[j] $ vào đầu mảng sort_arr

    + tăng j lên 1 đơn vị
    
_Kết quả:  sort_arr = [1, 3]_

- Lần thứ 3 (i = 1, j = 1)

    + $arr_1[i] > arr_2[j]$ , tức là $9 > 5$

    + chèn $arr_2[j]$ vào đầu mảng sort_arr

    + tăng j lên 1 đơn vị 

_Kết quả: sort_arr = [1, 3, 5]_

- Lần thứ tư ( i = 1, j = 2 )

    + $arr_1[i] > arr_2[j]$ , tức là $9 > 7$

    + chèn $arr_2[j]$ vào đầu mảng sort_arr

    + tăng j lên 1 đơn vị 

_Kết quả: sort_arr = [1, 3, 5, 7]_

- Lần thứ năm (i = 1, j = 3)
    + $arr_1[i] = arr_2[j]$ , tức là $9 = 9$

    + chèn arr_1[i] hoặc arr_2[j] vào đầu mảng 
    sort_arr

    Giả sử tôi chọn arr1, tăng i lên 1 đơn vị 

_Kết quả sort_arr = [1, 3, 5, 7, 9]_ 

- Lần thứ 6 (i = 2, j = 3) 

    + $arr_1[i] > arr_2[j]$ , tức là 10 > 9

    + chèn arr_2[j] vào đầu mảng sort_arr 

    + tăng j lên 1 đơn vị 

_Kết quả sort_arr = [1, 3, 5, 7, 9, 9]_

- Lần thứ bảy (j = 4), do j  ≧  độ dài mảng $arr_2$ , tiếp tục tăng i chừng nào i < độ dài mảng $arr_1$ thì thêm phần tử ở $arr_1[i]$ vào sort_arr.

Sau cùng ta được mảng đã sắp xếp là sort_arr = [1, 3, 5, 7, 9, 9, 10, 10]

__Nhận xét:__

- Khi so sánh $arr_1[i]$ và $ arr_2[j]$  , phần tử nào nhỏ hơn sẽ được chèn vào đầu mảng sort_arr

- Sau khi chèn một trong 2 phần tử trên, ta đi tiếp trên mảng chứa nó để thực hiện thao tác trên . Nếu điều kiện không thỏa thì dùng thao tác đó cho phần tử còn lại

Ta có thể minh họa như sau

![](/pictures/demo.png)


Nguồn: [blog.luyencode.net](https://blog.luyencode.net/thuat-toan-sap-xep-merge-sort/)

_Lưu ý, bài viết đã có nhiều chỉnh sửa so với bài viết gốc để phù hợp với ý tưởng xây dụng_