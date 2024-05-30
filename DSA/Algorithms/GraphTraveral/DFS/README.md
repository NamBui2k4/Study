# Giải thuật tìm kiếm theo chiều sâu (Depth First Search)

Giải thuật tìm kiếm theo chiều sâu là gì?

Giải thuật tìm kiếm theo chiều sâu (Depth First Search – viết tắt là DFS), còn được gọi là giải thuật tìm kiếm ưu tiên chiều sâu, là giải thuật duyệt hoặc tìm kiếm trên một cây hoặc một đồ thị và sử dụng stack (ngăn xếp) để ghi nhớ đỉnh liền kề để bắt đầu việc tìm kiếm khi không gặp được đỉnh liền kề trong bất kỳ vòng lặp nào. 

Giải thuật tiếp tục cho tới khi gặp được đỉnh cần tìm hoặc tới một nút không có con. Khi đó giải - thuật quay lui về đỉnh vừa mới tìm kiếm ở bước trước.

<img src="https://github.com/NamBui2k4/Study/assets/126387062/6a6c27e8-146d-4cb8-9346-7552ea93a803" style="position:absolute; left:3000px">


Khác với BFS (tìm kiếm theo chiều rộng), DFS không liệt kê tất cả các láng giềng của một đỉnh cùng lúc mà lần lượt chọn ra một láng giềng chưa được ghé thăm (có thể có trọng số nhỏ nhất) để đi đến điểm kế tiếp trong đồ thị. 

Trong hình minh họa trên, giải thuật tìm kiếm theo chiều sâu đầu tiên duyệt từ các đỉnh A tới B tới C tới D sau đó tới E, sau đó tới F và cuối cùng tới G. Giải thuật này tuân theo qui tắc sau:

- Qui tắc 1: Duyệt tiếp tới đỉnh liền kề mà chưa được duyệt. Đánh dấu đỉnh mà đã được duyệt. Hiển thị đỉnh đó và đẩy vào trong một ngăn xếp (stack).

- Qui tắc 2: Nếu không tìm thấy đỉnh liền kề, thì lấy một đỉnh từ trong ngăn xếp (thao tác pop up). (Giải thuật sẽ lấy tất cả các đỉnh từ trong ngăn xếp mà không có các đỉnh liền kề nào)

- Qui tắc 3: Lặp lại các qui tắc 1 và qui tắc 2 cho tới khi ngăn xếp là trống.

## Mô tả thuật toán

- Bước 1: Khởi tạo ngăn xếp (stack)

![step1](https://github.com/NamBui2k4/Study/assets/126387062/7896a26b-12c4-40c3-8c57-d1ad61da5b15)

- Bước 2: Đánh dấu đỉnh S là đã duyệt và đặt đỉnh này vào trong ngăn xếp. Tìm kiếm bất kỳ đỉnh liền kề nào mà chưa được duyệt từ đỉnh S. Chúng ta có 3 đỉnh và chúng ta có thể lấy bất kỳ đỉnh nào trong số chúng. Ví dụ, chúng ta lấy đỉnh A theo thứ tự chữ cái.
![step2](https://github.com/NamBui2k4/Study/assets/126387062/595d72d0-37d1-4304-9478-2925d56cc1a0)

- Bước 3: Đánh dấu đỉnh A là đã duyệt và đặt vào trong ngăn xếp. Tìm kiếm bất kỳ đỉnh liền kề nào với đỉnh A. Cả S và D đều là hai đỉnh liền kề A nhưng chúng ta chỉ quan tâm về đỉnh chưa được duyệt.

![step3](https://github.com/NamBui2k4/Study/assets/126387062/68b7f6a5-3cc9-4d7f-99ed-e7199c92b565)


- Bước 4: Duyệt đỉnh D, đánh dấu đỉnh này là đã duyệt và đặt vào trong ngăn xếp. Ở đây, chúng ta có B và C là hai đỉnh kề với D và cả hai đều là chưa được duyệt. Chúng ta sẽ chọn theo thứ tự chữ cái một lần nữa.

![step4](https://github.com/NamBui2k4/Study/assets/126387062/e434cf03-3e06-450c-ae43-58f35f8c0f02)

- Bước 5: Chọn B, đánh dấu là đã duyệt và đặt vào trong ngăn xếp. Ở đây B không có bất kỳ đỉnh liền kề nào mà chưa được duyệt. Vì thế chúng ta lấy B ra khỏi ngăn xếp.

![step5](https://github.com/NamBui2k4/Study/assets/126387062/4aa16142-85d7-4936-a47c-41250381dc88)

- Bước 6: Kiểm tra phần tử trên cùng của ngăn xếp để trở về nút đã duyệt trước đó và kiểm tra xem đỉnh này có đỉnh nào liền kề mà chưa được duyệt hay không. Ở đây, chúng ta tìm thấy đỉnh D nằm ở trên cùng của ngăn xếp.


![step6](https://github.com/NamBui2k4/Study/assets/126387062/9f103844-e65b-4054-a1e9-068a47e11f3c)


- Bước 7: Chỉ có một đỉnh liền kề với D mà chưa được duyệt, đó là đỉnh C. Chúng ta duyệt C, đánh dấu là đã duyệt và đặt vào trong ngăn xếp.

![step7](https://github.com/NamBui2k4/Study/assets/126387062/55e01d9b-5399-4c5d-a040-95964f33c283)

Vì C không có bất kỳ đỉnh nào liền kề mà chưa được duyệt, chúng ta tiếp tục lấy các đỉnh từ trong ngăn xếp để tìm xem có còn bất kỳ đỉnh nào liền kề mà chưa được duyệt hay không. Trong ví dụ này là không có, và chúng ta vẫn tiếp tục cho tới khi ngăn xếp là trống.

Nguồn: [viettuts.vn](https://viettuts.vn/cau-truc-du-lieu-va-giai-thuat/giai-thuat-tim-kiem-theo-chieu-sau-depth-first-search)
