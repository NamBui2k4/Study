# Thuật ngữ Origin

Trong hệ thống Git, khi bạn có một repository nằm ở github, bạn có thể đặt tên nó là `origin`. Nó được cho là một bí danh của hệ thống Git.

![](/pictures/git-origin.png)

_Nhắc lại: Git có hai loại repo (viết tắt của repository) là remote và local. remote là dạng repo có sẵn trên server, chúng ta có thể đăng ký tk và tạo một repo trên đó, ví dụ Github. Còn local là repo trên máy cá nhân. Ở cả remote và local đều tồn tại các branch (những phiên bản chỉnh sửa của dự án)_

Chúng ta sử dụng `git pull` và `git push` để tải lên và tải xuống dự án nhằm đồng bộ hóa giữa local và remote. Tuy nhiên, bạn phải thông báo cho local biết rằng nó sẽ đông bộ với local vì có rất nhiều local trên server.

Vì vậy, thuật ngữ gốc(origin) được sử dụng để xử lý một kho lưu trữ từ xa và nhánh chính. Thuật ngữ push origin master được sử dụng để đẩy các thay đổi vào kho lưu trữ từ xa. Thuật ngữ pull origin master được sử dụng để truy cập kho lưu trữ từ xa đến cục bộ.

Lưu ý: Trong git thì chúng ta vẫn dùng nhánh chính là master, nhưng trên github, nhanh master sẽ được đồi tên thành nhánh main.

Cái tên `origin` là một quy ước chuẩn được nhiều dev công nhận và việc giữ nguyên quy ước này khá quan trọng. Trường hợp lý tưởng nhất là bạn có thể đổi tên nó mà không làm mất bất kỳ chức năng nào.

Thuật ngữ origin được sử dụng rộng rãi đi kèm với các lệnh sau:

- Git push origin <tên nhánh>
- Git pull origin <tên nhánh>

