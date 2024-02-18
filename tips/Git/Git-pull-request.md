# Hướng dẫn tạo pull request trên GitHub

Pull request là một tính năng của Git giúp các lập trình viên cộng tác với nhau trên một dự án. Pull request cho phép bạn đề xuất các thay đổi đối với một nhánh chính của dự án, chẳng hạn như nhánh master. Sau khi tạo pull request, các thành viên khác của dự án có thể xem xét các thay đổi của bạn và cung cấp phản hồi.

Để tạo pull request trên GitHub, bạn cần làm theo các bước sau:

## Fork dự án
Nếu bạn chưa có quyền truy cập vào dự án, bạn cần fork dự án đó vào tài khoản của mình. Để làm điều này, hãy truy cập trang dự án trên GitHub và nhấn vào nút "Fork" ở góc trên bên phải

Tìm hiểu chi tiết hơn về [fork](/Git-fork.md)

## Tạo nhánh

Tạo một nhánh mới để chứa các thay đổi của bạn. Bạn có thể làm điều này bằng cách sử dụng lệnh git `checkout -b <tên-nhánh>`.

## Thực hiện các thay đổi
Thực hiện các thay đổi cần thiết đối với dự án trong nhánh mới của bạn.

## Commit các thay đổi
Khi bạn đã thực hiện xong các thay đổi, hãy commit chúng bằng lệnh git commit -a -m "<thông báo-commit>".

## Tạo pull request

Tạo pull request để đề xuất các thay đổi của bạn cho nhánh chính của dự án. Để làm điều này, hãy truy cập trang dự án trên GitHub và nhấn vào nút "New pull request".

Chỉnh sửa pull request Trên trang pull request, bạn có thể chỉnh sửa thông tin pull request, chẳng hạn như tiêu đề, mô tả và các thành viên cần review.

## Xem xét pull request

Các thành viên khác của dự án sẽ xem xét pull request của bạn và cung cấp phản hồi. Bạn có thể trả lời phản hồi của họ và thực hiện các thay đổi cần thiết.

## Merge pull request

Khi pull request đã được chấp nhận, nó sẽ được merge vào nhánh chính của dự án.

Thông tin pull request
Thông tin pull request bao gồm các thông tin sau:

Tiêu đề: Một tiêu đề ngắn gọn mô tả các thay đổi được đề xuất. Mô tả: Một mô tả chi tiết hơn về các thay đổi được đề xuất. Branch: Nhánh chứa các thay đổi được đề xuất. Target branch: Nhánh mà các thay đổi được đề xuất sẽ được merge vào. Issues: Các issue liên quan đến pull request. Review pull request

Khi bạn nhận được một pull request, bạn có thể xem xét các thay đổi được đề xuất và cung cấp phản hồi. Bạn có thể thực hiện các hành động sau đối với pull request:

Approve: Chấp nhận pull request. Request changes: Yêu cầu người tạo pull request thực hiện các thay đổi. Comment: Để lại nhận xét về pull request. Close: Đóng pull request. Merge pull request

Khi pull request đã được chấp nhận, bạn có thể merge nó vào nhánh chính của dự án. Để làm điều này, bạn có thể thực hiện các lệnh sau:

Trên nhánh chính: git pull <tên-nhánh-pull-request> Trên nhánh pull request: git push origin master Lưu ý

Pull request chỉ được merge vào nhánh chính của dự án khi nó đã được chấp nhận bởi tất cả các thành viên cần review. Bạn có thể tạo pull request cho bất kỳ nhánh nào của dự án, không chỉ nhánh chính. Bạn có thể tạo pull request cho nhiều nhánh cùng một lúc. Hy vọng hướng dẫn này sẽ giúp bạn tạo pull request trên GitHub.

