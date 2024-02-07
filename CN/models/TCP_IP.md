# Mô hình TCP/IP

__1. Lịch sử__

Năm 1974, Vin Cert và Robert Kahn công bố bài báo “A Protocol for Packet Network Interconnection” hay còn gọi là giao thức kết nối mạng gói, nó miêu tả về giao thức TCP (Transmission Control Protocol).

Đến năm 1978, giao thức trên sau khi được phát triển đã đổi tên thành Transnission Control Protocol/Internet Protocol và chính thức thay thế cho giao thức NCP (Network Control Protocol) của mạng lưới ARPAnet thời đó.

ARPAnet không còn tồn tại kể từ năm 1990 nhưng từ đó TCP/IP vẫn được phát triển để đáp ứng các yêu cầu thay đổi của Internet.

__2. Tổng quan về mô hình TCP/IP__

Giống với OSI, mô hình TCP/IP cũng có kiến trúc phân tầng cho phép dữ liệu được truyền tải thông qua các giao thức được tích hợp sẵn. 

TCP/IP chỉ có 4 tầng bao gồm: Tầng ứng dụng, tầng giao vận, tầng mạng, tầng liên kết. Thực chất 4 tầng đó là sự kết hợp của các tầng trong mô hình OSI nhưng chức năng cũng như tính chất của các tầng trong TCP/IP có sự thay đổi so với OSI.

_Lưu ý: Có nhiều quan điểm nói về việc TCP/IP có 5 tầng (thêm tầng vật lý) nhưng bài viết này chỉ nói đến 4 tầng thôi_

![](/pictures/TCP_IP.jpg)

Trong mô hình TCP/IP mỗi tầng được phân một chức năng riêng và có thể giao tiếp với các tầng kề bên nó, việc thay đổi vị trí các tầng cũng không được chấp nhận trong mô hình này.

__Tầng ứng dụng__ có nhiệm vụ tương tác trực tiếp với tiến trình ứng dụng, cung cấp giao diện giữa người dùng và ứng dụng. Vì không có tầng nào giữa tầng ứng dụng và tầng giao vận như mô hình OSI nên đôi khi tầng ứng dụng của TCP/IP bao gồm các chức năng của tầng phiên, tầng trình diễn bên mô hình OSI.

__Tầng giao vận__ đáp ứng nhu cầu của tầng ứng dụng, cung cấp các giao thức giúp dữ liệu được vận chuyển từ tiến trình ứng dụng ở hệ thống nguồn đến tiến trình ứng dụng ở hệ thống đích. Ngoài ra, còn cung cấp các dịch vụ kiểm soát luồng, kiểm tra lỗi gói tin, gửi xác nhận khi vận chuyển thành công. Một vài giao thức thông dụng nhất hiện nay trong tầng giao vận là TCP và UDP.

__Tầng mạng__ đáp ứng nhu cầu của tầng giao vận, có nhiệm vụ dẫn đường cho dữ liệu có thể được vận chuyển từ điểm đầu đến điểm đích an toàn, nó tìm kiếm đường truyền dữ liệu tốt nhất thông qua các giao thức cũng như các thuật toán dò đường được tích hợp trên các bộ định tuyến (Routing). Một vài giao thức có trong tầng mạng: IP, ICMP, IGMP,…

__Tầng Liên kết__ đáp ứng nhu cầu của tầng mạng, nó đóng vai trò như tầng liên kết dữ liệu và tầng vật lý của mô hình OSI. Tầng liên kết nhận dữ liệu dưới dạng bit sau đó đưa dữ liệu vào trong 1 gói dữ liệu rồi gửi lên mạng lưới máy tính để truyền đến điểm đích.

__3. Ưu điểm và nhược điểm__

Ưu điểm:

- Hỗ trợ nhiều giao thức định tuyến.
- Hoạt động độc lập với hệ điều hành.
- Thiết lập kết nối giữa các loại máy tính khác nhau.
- Có kiến trúc phân tầng.
- Hỗ trợ kết nối có liên kết và kết nối phi liên kết.

Nhược điểm:

- Khó khăn trong việc thay thế các giao thức mới.
- Một tầng có nhiều chức năng nên phức tạp hơn so với mô hình OSI.
- Không có sự phân biệt dõ dàng giữa dịch vụ, giao diện và giao thức.