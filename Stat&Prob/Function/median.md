# Số trung vị

Trong lý thuyết xác suất và thống kê, số trung vị (tiếng Anh: median) là một số tách giữa nửa lớn hơn và nửa bé hơn của một mẫu, một quần thể, hay một phân bố xác suất. Nó là giá trị giữa trong một phân bố, mà số các số nằm trên hay dưới con số đó là bằng nhau. Điều đó có nghĩa rằng 1/2 quần thể sẽ có các giá trị nhỏ hơn hay bằng số trung vị, và một nửa quần thể sẽ có giá trị bằng hoặc lớn hơn số trung vị.

Để tìm số trung vị của một danh sách hữu hạn các số, ta xếp tăng dần tất cả các quan sát, rồi lấy giá trị nằm giữa danh sách. Nếu số quan sát là số chẵn, người ta thường lấy trung bình của hai giá trị nằm giữa.

# Cách giải thích dễ hiểu
Giả sử có 19 người nghèo và 1 tỉ phú trong một căn phòng. Mọi người đều bỏ tất cả tiền trong túi mình ra và đặt lên một cái bàn. Mỗi người nghèo đặt 5 đồng lên bàn; người tỉ phú đặt 1 tỷ đồng ($ 10^9 đồng $) lên đó. Khi đó, tổng số là 1.000.000.095 đồng. Nếu đem chia đều số tiền đó cho 20 người, mỗi người được 50.000.004 đồng và 75 xu. Số tiền đó là __trung bình__ của số tiền mà mỗi người đã đem vào phòng. Nhưng số __trung vị__ lại là 5 đồng, vì ta có thể chia thành 2 nhóm mỗi nhóm 10 người, và nói rằng mọi người trong nhóm thứ nhất mang không nhiều hơn 5 đồng và mọi người trong nhóm thứ hai mang không dưới 5 đồng. Theo nghĩa đó, số trung vị là số tiền mà một người điển hình mang tới. Ngược lại, giá trị trung bình không điển hình chút nào, do không có ai - người nghèo hoặc tỉ phú - mang đến một số tiền xấp xỉ 50.000.004,75 đồng.

# Không duy nhất
có thể có nhiều hơn một số trung vị. Ví dụ nếu số các trường hợp là một số chẵn thì không có một số trung vị duy nhất. Lưu ý rằng một nửa số các số trong danh sách có giá trị nhỏ hơn hoặc bằng một trong hai giá trị giữa, và một nửa lớn hơn hay bằng một trong hai giá trị đó, đối với bất cứ số nào nằm giữa hai giá trị đó cũng vậy. Do vậy, trong trường hợp đó, cả hai số nằm giữa và mọi giá trị nằm giữa chúng đều là số trung vị.

# Đo đạc sự phân tán thống kê
Khi trung vị được dùng với vai trò tham số vị trí trong thống kê mô tả, có một vài lựa chọn một độ đo độ biến đổi: khoảng biến thiên giao độ (range), khoảng tứ phân vị (interquartile range), và độ lệch tuyệt đối (absolute deviation). Do trung vị chính là tứ phân vị thứ hai, việc tính toán nó được minh họa trong bài về các tứ phân vị.

Nguồn: [wikiwan](https://www.wikiwand.com/vi/S%25E1%25BB%2591_trung_v%25E1%25BB%258B)