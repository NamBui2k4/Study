Nguồn bài viết: [bizflycloud.vn](https://bizflycloud.vn/tin-tuc/user-datagram-protocol-udp-la-gi-20181029112323536.htm#:~:text=UDP%20%28User%20Datagram%20Protocol%29%20%E2%80%93%20Giao%20th%E1%BB%A9c%20d%E1%BB%AF,ch%E1%BB%8Bu%20l%E1%BB%97i%20gi%E1%BB%AFa%20c%C3%A1c%20%E1%BB%A9ng%20d%E1%BB%A5ng%20tr%C3%AAn%20internet.)

# UDP là gì? Các ứng dụng và tính năng phổ biến của UDP

![](/pictures/network.webp)

__UDP là gì?__

UDP (User Datagram Protocol) – Giao thức dữ liệu người dùng là một giao thức giao tiếp thay thế cho TCP (Transmission Control Protocol) – giao thức kiểm soát đường truyền, được sử dụng chủ yếu để thiết lập các kết nối có độ trễ thấp và không chịu lỗi giữa các ứng dụng trên internet.

Cả UDP và TCP đều chạy ở phía trên lớp giao thức mạng (IP) và đôi khi được biết đến như là UDP/IP hoặc TCP/IP. Tuy nhiên, hai khái niệm này hoàn toàn khác biệt với nhau.

Nếu UDP cho phép các giao tiếp process-to-process (quy trình với quy trình), TCP lại hỗ trợ giao tiếp host-to-host (máy chủ với máy chủ). Trong khi TCP gửi đi các gói tin đã được chia nhỏ, riêng biệt, độc lập và được xem như một phương tiện truyền tải đáng tin cậy, UDP gửi đi các thông điệp gọi là các datagram (gói dữ liệu) và được xem là phương thức giao tiếp trực tiếp tốt nhất.

![](/pictures/TCPvsUDP.webp)

Ngoài ra, TCP còn cung cấp khả năng kiểm soát lỗi và lưu lượng, UDP thì không. UDP được coi là một giao thức không kết nối bởi UDP không cần đến một mạch điện ảo để thiết lập trước khi truyền dữ liệu.

UDP cung cấp 2 service không được lớp IP hỗ trợ. Một dịch vụ là số port giúp phân biệt các yêu cầu khác nhau từ user và một dịch vụ là checksum (tùy chọn) để xác minh dữ liệu đến còn nguyên vẹn.

TCP nổi lên như một giao thức chủ đạo được sử dụng cho hầu hết các kết nối internet nhờ khả năng chia các tập dữ liệu lớn thành các gói dữ liệu nhỏ và độc lập, kiểm tra và gửi lại các gói tin bị mất, tập hợp lại các gói theo đúng trình tự. Nhưng các service đi kèm này thường có thể mất thêm chi phí sử dụng khi lượng data bổ sung và độ trễ tăng lên.

Ngược lại, UDP chỉ gửi đi các gói tin, điều này đồng nghĩa với tổng chi phí băng thông và độ trễ thấp hơn. Với UDP, cá gói tin có thể sẽ đi theo các path khác nhau giữa người gửi và người nhận, dẫn đến một số gói tin có thể bị mất hoặc không theo thứ tự nhận.

![](/pictures/photo-1-1540786379934401840946.webp)

UDP là một giao thức lý tưởng cho các ứng dụng mạng mà trong đó độ trễ là một yếu tố tối quan trọng như trong các giao tiếp game, âm thanh và video. 

Nhờ vậy mà các loại giao tiếp này có thể chịu được việc mất dữ liệu miễn là không ảnh hưởng đến chất lượng dữ liệu khi nhận. Trong một số trường hợp, các kỹ thuật chuyển tiếp lỗi được sử dụng để cải thiện chất lượng âm thanh và video bất chấp các mất mát dữ liệu xảy ra.

UDP cũng có thể được sử dụng trong các ứng dụng đòi hỏi khả năng bảo toàn dữ liệu trong lúc truyền tin. Khi đó, UDP sẽ được sử dụng trong cấu hình ứng dụng nhằm quản lý quá trình truyền lại các gói bị mất và sắp xếp chính xác các gói đã nhận. Cách thức này có thể giúp cải thiện tốc độ truyền dữ liệu của các file dung lượng lớn so với TCP.

Trong các giao tiếp của mô hình OSI (Open Systems Interconnection – hệ thống kết nối mở), UDP cũng giống như TCP thuộc layer 4 – lớp truyền tải. UDP thường sẽ phối hợp với các giao thức cấp cao hơn để quản lý các dịch vụ truyền dữ liệu bao gồm Giao thức truyền tải tệp nhỏ (TFTP), Giao thức truyền tải theo thời gian thực (RTSP), giao thức mạng đơn giản (SNP) và hệ thống tên miền (DNS).

__Các tính năng của giao thức gói dữ liệu người dùng__

Giao thức user datagram có các thuộc tính thích hợp để sử dụng cho các ứng dụng có khả năng chịu được việc mất dữ liệu.

Giao thức cho phép các gói tin có thể được loại bỏ và nhận theo một thứ tự khác biệt so với khi chúng được truyền đi, nhờ vậy giao thức phù hợp với các ứng dụng theo thời gian thực có độ trễ là mối quan tâm hàng đầu.

User datagram cũng có thể được sử dụng cho các giao thức giao dịch, ví dụ như DNS hoặc Network Time Protocol.

Sử dụng giao thức khi một số lượng lớn máy khách được kết nối và việc sửa lỗi thời gian thực là không cần thiết, ví dụ như với gaming, hội thoại, video và truyền phát trực tuyến.

__Thành phần header của UDP__

Header của Giao thức user datagram gồm có bốn trường, mỗi trường bằng 2 byte. Các trường này là:

- số port nguồn, là số của người gửi;

- số port đích, port mà datagram được gửi đến;

- độ dài tính bằng byte của UDP header và bất kỳ dữ liệu được đóng gói nào;

- checksum, được sử dụng trong kiểm tra lỗi. Việc sử dụng checksum sẽ được yêu cầu trong IPv6 và là một tùy chọn trong IPv4.

![](/pictures/UDP-header-format.webp)