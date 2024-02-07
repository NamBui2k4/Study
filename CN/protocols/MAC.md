Nguồn bài viết: [_TotolinkVN_](https://www.totolink.vn/article/42-dia-chi-mac-la-gi-kien-truc-mac-802-11.html#:~:text=MAC%20l%C3%A0%20vi%E1%BA%BFt%20t%E1%BA%AFt%20c%E1%BB%A7a%20t%E1%BB%AB%20Media%20Access,%C4%91%E1%BB%8Ba%20ch%E1%BB%89%20v%C3%A0%20%C4%91i%E1%BB%81u%20khi%E1%BB%83n%20truy%20c%E1%BA%ADp%20k%C3%AAnh.)

29/08/2020 bởi TOTOLINK Việt Nam

# MAC là gì?

MAC là viết tắt của từ Media Access Control. Đây chính là một phần của tầng liên kết trong mô hình 7 tầng OSI. Trong tầng liên kết của mô hình OSI lại được chia thành hai tầng con đó là tầng Mac và tầng LLC.

Chức năng chính của Mac là cung cấp các cơ chế đánh địa chỉ và điều khiển truy cập kênh. Nghĩa là tầng con Mac trong tầng liên kết được hoạt động giống như một giao diện giúp việc truyền dữ liệu giữa tầng con LLC với tầng vật lý trong mô hình OSI được diễn ra thuận lợi. Ngoài ra, Mac còn có tác dụng cho phép nhiều trạm kết nối tới cùng một môi trường vật lý và dùng chung môi trường đó.

# Địa chỉ MAC là gì?
Địa chỉ Mac gồm 6 octets, mỗi octets 8 bits, được biểu diễn bằng 6 cặp chữ số hoặc ký tự khác nhau và được ngăn cách bằng dấu hai chấm.

Ví dụ như: 00:1B:44:11:3A:B7

Địa chỉ Mac thường có 3 loại đó là Unicast, Broadcast, Multicast.

![](/pictures/MAc.png)

Địa chỉ này là duy nhất được các nhà sản xuất gắn cho từng phần cứng của các thiết bị và không thể thay đổi được. Mỗi thiết bị sẽ có một địa chỉ MAC khác nhau và duy nhất. Vì vậy mà địa chỉ Mac hay còn được gọi là địa chỉ phần cứng hoặc địa chỉ thực.

Sự khác nhau giữa địa chỉ Mac và địa chỉ IP là địa chỉ Mac không thể thay đổi được. Ngược lại địa chỉ IP có thể thay đổi được. Không chỉ có máy tính mà địa chỉ MAC còn được nhà cung cấp gắn trên nhiều thiết bị khác như router phát sóng wifi, smartphone,..


# Kiến trúc MAC 802.11

__Các chức năng riêng của kiến trúc MAC 802.11__

Kết hợp khung: Kết hợp khung nghĩa là đặt hai hay nhiều khung vào một đường một lần truyền dẫn. Như vậy sẽ sẽ làm giảm sử tác động của các tính hiệu không phải dữ liệu lên băng thông, giúp làm giảm tối đa dung lượng băng thông phải sử dụng.

![](/pictures/MAC-structure.png)

Bảo mật: kiến trúc MAC 802.11 sử dụng cơ chế bảo mật WPA2. Đây là chuẩn bảo mật hiện đại và tiên tiến nhất hiện nay, giúp các thông tin, dữ liệu không bị rò rỉ ra ngoài, tránh sự xâm nhập của các hacker.

__Các thành phần của kiến trúc MAC 802.11__

Gói, Bit, Frame

Thành phần này của kiến trúc MAC 802.11 có tác dụng truyền dữ liệu người dùng từ một thiết bị máy tính khác đến những thiết bị khác nhau. Trước khi dữ liệu được truyền đi sẽ được xử lý và bắt đầu truyền từ các tầng trên của mô hình OSI cho đến khi đến lớp vật lý. Đây là tầng cuối cùng trước khi các dữ liệu được truyền đến các thiết bị khác.

Tại tầng mạng, mỗi gói tin IP lớp 3 sẽ đóng gói dữ liệu từ lớp 4-7 truyền đến. Lúc này tại Data-Link, các gói tin IP sẽ được thêm vào một tiêu đề MAC bên trong một frame. Cuối cùng khi frame đến lớp vật lý sẽ được thêm một tiêu để PHY với nhiều thông tin. Cuối cùng là những bit riêng lẻ ở lớp vật lý được truyền đi.

Lớp Data-Link

Lớp Data-Link trong cấu trúc MAC 802.11 được chia thành hai lớp con đó là Logical Link Control và Media Access Control. Mỗi lớp con sẽ có một chức năng riêng.

Đối với lớp Logical Link Control là phần trên: mặc dù dữ liệu không được sử dụng cùng các mạng nhưng khi được truyền đi thì tất cả các dữ liệu này sẽ giống hệt nhau.

Media Access Control là phần dưới cùng: dữ liệu truyền đi giống hệt nhau cho tất cả các mạng dựa trên tiêu chuẩn 802.11.

Tóm lại hoạt động tại các lớp con của cấu trúc MAC đều dựa vào chuẩn 802.11

Lớp vật lý

Lớp vật lý cũng được chia thành 2 lớp con. Phần trên của lớp là giao thức hội tụ lớp vật lý, viết tắt là PLCP, phần dưới được viết tắt là PMD là lớp phụ thuộc vào môi trường vật lý.

Phần trên của lớp vật lý sẽ cho phát dữ liệu bằng cách lấy frame từ lớp con MAC rồi tạo ra các đơn vị dữ liệu giao thức. Sau đó các lớp con PMD chuyển và truyền dữ liệu là bit.