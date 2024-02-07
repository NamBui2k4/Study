# Quartile - Tứ phân vị

Tứ phân vị là đại lượng mô tả sự phân bố và sự phân tán của tập dữ liệu. Về cơ bản, khi một tập dữ liệu được chia thành 4 phần bởi 3 điểm nằm giữa thì tứ phân vị chính là 3 điểm nằm giữa đó.

Tứ phân vị là một điểm nằm trong một tổng thể. Và vì tổng thể được chia làm 4 phần nên ta luôn có tứ phân vị thứ nhất, thứ nhì, và thứ ba.

Trong một tổng thể đã được sắp xếp dữ liệu theo thứ tự tăng dần thì:

-  Giá trị tứ phân vị thứ hai Q2 chính bằng giá trị trung vị của tổng thể (Median)
 
- Giá trị tứ phân vị thứ nhất Q1 bằng trung vị của nửa tổng thể bên trái (Lower Quartile)

- Giá trị tứ phân vị thứ ba Q3 bằng trung vị nửa tổng thể bên phải (Upper Quartile)

_Lưu ý: ta chỉ xác định giá trị tứ phân vị nếu đã sắp xếp dữ liệu của tổng thể theo thứ tự tăng dần_

![](/pictures/Quartiles.webp)

Ví dụ: Tập dữ liệu bao gồm {5, 7, 9, 14, 25, 34, 48}

Tập dữ liệu trên đã được sắp xếp theo thứ tự tăng dần, dễ dàng nhận thấy giá trị trung vị nằm giữa chính là 14

Trung vị của nửa tổng thể bên trái {5, 7, 9} là 7

Và trung vị của nửa tổng thể bên phải {25, 34, 48} là 34

Vậy Q1 = 7, Q2 = 14 , Q3 = 34

Tứ phân vị rất có ý nghĩa thực tiễn trong việc giải quyết các bài toán xác định outlier (dữ liệu ngoại lai) thuộc lĩnh vực Data Science

Nguồn: [_wiki_](https://www.wikiwand.com/vi/T%25E1%25BB%25A9_ph%25C3%25A2n_v%25E1%25BB%258B)