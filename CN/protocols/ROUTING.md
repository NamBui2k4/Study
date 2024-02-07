# Định tuyến là gì

_Định tuyến (Routing) là quá trình chọn đường đi qua một hoặc nhiều mạng. Một mạng được tạo thành từ nhiều thiết bị (các nút) và các đường dẫn (liên kết) để kết nối những nút đó. Trong một mạng, quá trình giao tiếp giữa hai nút được có thể diễn ra qua nhiều đường dẫn khác nhau_

Định tuyến được coi là quá trình lựa chọn đường dẫn tốt nhất bằng một số giao thức

__Tại sao định tuyến quan trọng?__

Định tuyến giúp hoạt động giao tiếp trong mạng diễn ra hiệu quả. Lỗi giao tiếp mạng là nguyên nhân khiến người dùng phải chờ lâu để tải website. Nó cũng có thể khiến máy chủ website sập vì không thể xử lý số lượng người dùng lớn. Định tuyến sinh ra giúp giảm lỗi mạng bằng cách quản lý lưu lượng truy cập để mạng phát huy tối đa khả năng mà không gây ra tình trạng tắc nghẽn.

![](/pictures/routing-important.png)

Chức năng định tuyến sẽ do router đảm nhiệm. 

_Nhắc lại, Router có 3 chức năng chính:_

- Chuyển tiếp dữ liệu: đưa dữ liệu từ thiết bị nguồn đến thiết bị đích

- định tuyến: xác định đường đi của dữ liệu khi chúng di chuyển từ nguồn đến đích

- Cân bằng tải (Load balancing): Đôi khi, Router có thể gửi bản copy của dữ liệu qua nhiều đường dẫn khác nhau, để giảm lỗi do tổn thất dữ liệu gây ra, tạo dự phòng và quản lý lưu lượng truy cập. 

__Router định tuyến như thế nào__

Dữ liệu di chuyển qua các mạng dưới dạng gói dữ liệu (data packet). Mỗi gói sẽ có một tiêu đề chứa thông tin liên quan đến điểm đích dự kiến của gói đó.

Khi một Router nhận được một gói dữ liệu, nó sẽ đọc các tiêu đề gói để biết điểm đến dự định của gói.  Sau đó, nó xác định nơi định tuyến gói dữ liệu dựa trên thông tin trong bảng định tuyến của nó.

__Có những loại định tuyến nào?__

Có ba loại định tuyến là:

- Định tuyến tĩnh (Static routing) 
- Định tuyến mặc định
- Định tuyến động (Dynamic routing)

Định tuyến tĩnh có tên gọi khác là Định tuyến không thích ứng (Nonadaptive Routing). Định tuyến tĩnh là quá trình nối thủ công các tuyến đến bảng định tuyến.

Giả sử chúng ta muốn kết nối máy tính với một máy tính khác và giữa chúng có mười mạng khác nhau. Khi này, chúng ta phải cung cấp một cách thủ công thông tin về các mạng mà mình muốn kết nối với bộ định tuyến, sau đó mới có thể trao đổi dữ liệu. Quá trình này được gọi là Định tuyến tĩnh.

__Ưu điểm:__

- Quản trị viên thiết lập thủ công.
- Định tuyến tĩnh là phương thức an toàn và nhanh chóng.
- Không sử dụng băng thông giữa các bộ định tuyến.
- Định tuyến tĩnh ít tốn kém hơn.

__Nhược điểm:__

- Sử dụng trong mạng nhỏ
- Mọi thứ phải được thiết lập thủ công.
- Định tuyến động

Định tuyến động có tên gọi khác là Định tuyến thích ứng (Adaptive routing). Định tuyến động tự động điều chỉnh các tuyến dựa trên trạng thái thực tế trong bảng định tuyến. Các giao thức được sử dụng trong định tuyến động có vai trò khám phá các đích mạng và các tuyến đến đó. Nếu một trong các tuyến mạng bị lỗi, nó sẽ tự động điều chỉnh để đi được đến đích. RIP và OSPF là hai ví dụ tốt nhất về các giao thức định tuyến động.

Chẳng hạn như khi máy tính muốn kết nối với một máy tính khác và có mười mạng khác nhau giữa chúng. Đường dẫn kết nối hai máy tính được chọn một cách tự động.

__Ưu điểm:__

- Không cần phải hiểu các mạng.
- Định tuyến động dễ dàng để thiết lập.
- Được sử dụng cho các tổ chức lớn.
- Hiệu quả xác định đường đi tốt nhất.

__Nhược điểm:__

- Tiêu thụ nhiều băng thông hơn.
- Định tuyến động sử dụng nhiều tài nguyên hơn như CPU, RAM và băng thông, do đó, nó đắt hơn.
- Quá trình triển khai định tuyến động phức tạp hơn.

Định tuyến mặc định: là phương pháp không hay được sử dụng. Định tuyến mặc định thiết lập bộ định tuyến để gửi tất cả các gói dữ liệu đến một bộ định tuyến duy nhất. Gói thuộc về mạng nào cũng không có gì khác biệt; định tuyến là mặc định. Định tuyến mặc định thường được sử dụng kết hợp với các bộ định tuyến sơ khai. Một bộ định tuyến sơ khai là bộ định tuyến chỉ có một tuyến đến tất cả các mạng khác.

__Ưu điểm:__

- Nếu không có tuyến cố định nào trong bảng định tuyến, định tuyến mặc định có thể hữu ích. Định tuyến mặc định được sử dụng cho tất cả lưu lượng gói có đích không xác định trong bảng định tuyến.
- Phù hợp để lọc gói, tường lửa và máy chủ proxy vì được định cấu hình cho các đích không xác định.

__Nhược điểm:__ Nếu mạng quá phức tạp, việc thiết lập sẽ khó khăn.

# 7 giao thức định tuyến phổ biến
 
1. RIP

RIP (Routing information protocol) là giao thức cổng bên trong và là một trong những giao thức đầu tiên được tạo ra. Bạn có thể sử dụng nó với mạng LAN (liên kết trong phạm vi nhỏ) hoặc mạng WAN (mạng viễn thông phạm vi lớn hơn). Có hai phiên bản khác nhau của loại giao thức này: RIPv1 và RIPv2.

RIPv1, phiên bản gốc, là giao thức phân loại kiểm tra và đánh giá các đường dẫn mạng dựa trên số bước nhảy đến đích được xác định trước. Trong khi đó, phiên bản mới hơn - RIPv2 - là một giao thức không phân loại, cũng có các biện pháp bảo mật nâng cao, như xác thực, để bảo vệ dữ liệu. RIPv2 có lợi thế trong các mạng nhỏ vì nó chỉ hỗ trợ bộ định tuyến từ 15 bước nhảy trở xuống.

2. IGRP

IGRP (Interior gateway protocol) là sản phẩm do Cisco, một công ty công nghệ quốc tế, tạo ra. Nền tảng chức năng của IGRP là RIP, nhưng tăng số bước nhảy hỗ trợ tối đa lên 100. Do đó, nó hoạt động tốt hơn trong các mạng lớn. Để hoạt động, IGRP cần các số liệu như dung lượng mạng, độ tin cậy và tải (load) để so sánh. 

3. EIGRP

EIGRP (Enhanced interior gateway routing protocol) hỗ trợ đến 255 bước nhảy. Khi sử dụng EIGRP, bộ định tuyến có thể lấy thông tin từ các bảng của bộ định tuyến khác và ghi lại làm tài liệu tham khảo. Nếu có thay đổi xảy ra, mỗi bộ định tuyến sẽ thông báo cho láng giềng của nó để đảm bảo tất cả đều biết tuyến dữ liệu nào đang được sử dụng. Điều này giúp ngăn chặn giao tiếp sai tiềm ẩn giữa các bộ định tuyến.

4. OSPF

OSPF (Open shortest path first) là giao thức có khả năng thu thập thông tin từ tất cả các bộ định tuyến khác trong hệ thống tự trị để xác định tuyến đường ngắn nhất và nhanh nhất đến điểm đích của một gói dữ liệu. 

OSPF sử dụng một thuật toán gọi là Dijkstra để tính toán các đường dẫn khi xảy ra thay đổi cấu trúc liên kết. OSPF đảm bảo dữ liệu của nó được an toàn trong suốt các thay đổi hoặc vi phạm mạng (network breach). Các tổ chức mạng lớn và nhỏ đều có thể sử dụng OSPF vì nó có các tính năng có thể mở rộng.

5. EGP

EGP (Exterior gateway protocol) là một loại giao thức rất hữu ích trong trao đổi dữ liệu giữa các máy chủ khác cổng trong các hệ thống tự trị. Cụ thể, EGP cung cấp không gian cho các bộ định tuyến để chia sẻ thông tin giữa các miền, như Internet. 

EGP duy trì định vị chặt chẽ các cơ sở dữ liệu mạng để định tuyến dữ liệu đến đích. Cơ sở dữ liệu sau đó chia sẻ thông tin giữa các bộ định tuyến được kết nối để đảm bảo tất cả đều cập nhật bảng của chúng. Các bảng định tuyến mới có thể giúp xác định tuyến đường tốt nhất cho dữ liệu.

6. BGP

Ban đầu, BGP (Border gateway protocol) là một giao thức được phát triển để thay thế EGP. Nó sử dụng thuật toán chọn đường dẫn tốt nhất để thực hiện truyền gói dữ liệu. 

BGP cho phép quản trị viên thay đổi các tuyến tùy theo nhu cầu và cung cấp các tính năng bảo mật nâng cao, để chỉ các bộ định tuyến được ủy quyền mới có thể trao đổi dữ liệu với nhau.

7. IS-IS

IS-IS (Immediate system-to-immediate system) thường được sử dụng để gửi và chia sẻ thông tin định tuyến IP trên internet. Thông thường, giao thức nhóm các bộ định tuyến lại, tạo các miền lớn và kết nối hơn để truyền dữ liệu. IS-IS thường dùng hai loại mạng là:

Network service access point (NSAP): Tương tự như địa chỉ IP, NSAP là nhận dạng điểm truy cập dịch vụ trong các hệ thống sử dụng mô hình OSI (Open Systems Interconnection).
Network entity title (NET): giúp xác định các bộ định tuyến mạng riêng lẻ trong các mạng máy tính lớn hơn.

Bài viết này đã mang đến thông tin tổng quan về Định tuyến là gì. Hy vọng các bạn đã có thông tin hữu ích thông qua bài viết!.


Nguồn: [meeyland.com](https://meeyland.com/tin-tuc/dinh-tuyen-la-gi-cac-giao-thuc-dinh-tuyen-pho-bien-378180187)