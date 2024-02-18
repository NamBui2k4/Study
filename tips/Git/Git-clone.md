# Tính năng Clone của Git

Git Clone là một câu lệnh phổ biến trong hệ thống Git mà mọi lập trình viên phải biết. Vậy sử dụng Git Clone như thế nào? Những ví dụ về cách sử dụng Git Clone trong thực tế là gì? Hãy cùng tìm hiểu ngay bằng cách đọc bài của Got It Vietnam nhé!

## Git clone là gì

Khi mới làm quen với hệ thống Git, nhiều người hiểu đúng sức mạnh của nó nên cứ lên những trang như Stackoverflow.com và copy mã nguồn về để code. Họ cứ làm như vậy đến khi cần chuyển dự án lên các remote như Github hoặc chuyển sang các local khác thì lại không biết làm thế nào.

Lí do bởi họ chưa tìm hiểu kĩ về các lệnh cơ bản của Git, đặc biệt là Git Clone. Lệnh này cho phép các lập trình viên copy một Remote Repo về Local, ngoài ra có thể ứng dụng trong các trường hợp sau:

- Copy một Repo từ máy Remote về Local
- Copy một Repo từ thư mục này sang một thư mục khác
- Copy một Repo từ một Url (https) ví dụ GitHub

## Git Clone dùng để làm gì?

Ưu điểm tuyệt vời của Git đó là khi bạn thực hiện Git Clone, bạn sẽ nhận được toàn bộ Repo, thay vì chỉ là 1 file như các hệ thống khác. Đồng thời, bạn chỉ cần thực hiện Git Clone 1 lần duy nhất, đó là khi bắt đầu làm việc với dự án. Kể cả trong tương lai có phát triển thêm thì bạn cũng không cần clone lại một lần nữa.

Với ưu điểm này, các nhà phát triển có thể làm việc với các branch thoải mái hơn, ví dụ như họ có thể thực hiện lệnh Git Push để chia sẻ branch với Remote Repo, hoặc họ có thể hợp nhất branch với Master Branch trong các giai đoạn sau.

## Các ví dụ về cách sử dụng Git Clone

Tính năng chính của Git clone thể hiện mạnh mẽ nhất khi làm việc với github. Nếu chưa có tài khoản github thì hãy đăng ký toàn khoản qua hướng dẫn sau: [Git-remote](/Git-remote.md). Còn nếu đã có tài khoản rồi thì hãy khan khảo ví dụ sau:

Giả sử github của tôi có đường link là https://github.com/PhuongNam2k4/MyProject.git 

Tôi có thể dùng các lệnh git clone sau để đưa repo của github trong link trên về máy tính:

- `git clone <url của github>`: sao chép một Repo đã tồn tại trên GitHub, bao gồm tất cả các files, branches và commits.

Ví dụ: 
```
git clone https://github.com/PhuongNam2k4/MyProject.git
```
|
- `git clone --mirror` : Clone một Repo nhưng không thể chỉnh sửa. Đây sẽ là một nguồn tham khảo hữu ích cho các bạn trong việc phát triển dự án. Các bạn sẽ muốn dùng câu lệnh này khi mình muốn tạo ra một phiên bản thứ cấp của một Repo và muốn mọi branches match với nhau. Câu lệnh này có thể diễn ra trong quá trình sử dụng Git khi đang kiểm thử tự động.

Ví dụ
```
git clone --mirror https://github.com/PhuongNam2k4/MyProject.git
```
|
- `git clone --single-branch`: Chỉ clone một branch duy nhất

Ví dụ
```
git clone --single-branch https://github.com/PhuongNam2k4/MyProject.git
```
|
- `git clone --sparse`: Đây là câu lệnh sẽ giúp clone các dữ liệu trong thư mục gốc. Điều này có thể giúp cải thiện hiệu suất khi phải clone những Repos lớn tới nhiều thư mục và thư mục con.

- `git clone --recurse-submodules[=<pathspec]`: Đây sẽ là một sự lựa chọn tốt nếu bạn đang clone một Repo mà bạn biết sở hữu các module con, và bạn sẽ phải làm việc với các module con này với vai trò là các dependencies ở Local Repo của bạn.


Nguồn: 

[cafedev](https://cafedev.vn/tu-hoc-git-thuat-ngu-origin-va-master/#:~:text=Ngu%E1%BB%93n%20g%E1%BB%91c%20%28origin%29%20l%C3%A0%20m%E1%BB%99t%20t%C3%AAn%20vi%E1%BA%BFt%20t%E1%BA%AFt,g%E1%BB%91c%20%28origin%29%20ch%E1%BB%89%20l%C3%A0%20m%E1%BB%99t%20quy%20%C6%B0%E1%BB%9Bc%20chu%E1%BA%A9n.)

[vn.got-it](https://vn.got-it.ai/blog/nhung-dieu-ban-chua-biet-ve-git-clone)