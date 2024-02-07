Bất kỳ hệ thống mạng lớn, nhỏ nào khi đã có sự kết nối của các thiết bị điện tử sử dụng địa chỉ IP động thì đều được cấp từ DHCP server.DHCP Là Gì? DHCP Server Là Gì? Ưu Điểm Và Cấu Hình Của DHCP thế nào? Chia sẻ sau của Hosting Việt sẽ giúp bạn đi tìm lời giải cho vấn đề này nhé!

![](/pictures/dhcp-la-gi-1.jpg)

## DHCP là gì? 
DHCP chính là từ viết tắt của cụm từ Dynamic Host Configuration Protocol (được dịch là Giao thức Cấu hình Host Động). Theo đó, DHCP là giao thức có chức năng cấp phát địa chỉ IP cho tất cả các thiết bị truy cập trên cùng một mạng thông qua máy chủ DHCP được tích hợp trên router. 

Bên cạnh đó, DHCP còn có nhiệm vụ cấp thông số cần thiết của mạng đến các thiết bị. Cụ thể là thông tin về subnet mask, default gateway và dịch vụ DNS.

## Cách thức hoạt động của DHCP 
Về cơ bản, cách thức hoạt động của DHCP đơn giản. Đó là, khi một thiết bị muốn truy cập mạng phát tín hiệu, DHCP sẽ thực hiện việc gửi yêu cầu từ router. Sau đó, router tiến hành gán cho địa chỉ IP khả dụng.

Cụ thể, khi có nhu cầu kết nối mạng, thiết bị thực hiện gửi yêu cầu DHCP DISCOVER đến máy chủ. Tiếp đến, DHCP server tiến hành tìm kiếm địa chỉ IP khả dụng, sau đó, cung cấp lại cho thiết bị và gói DHCP OFFER.

Khi đã có được địa chỉ, thiết bị sử dụng một gói tin DHCP REQUEST để trả lời lại cho máy chủ. Lúc này, máy chủ sẽ gửi xác nhận thiết bị đã có IP, cũng như thời gian sử dụng nó cho đến khi thay thế bằng địa chỉ mới.

Chính vì cơ chế hoạt động này nên đối với các mạng có quy mô nhỏ hoặc hộ gia đình thì router hoạt động như máy chủ DHCP. Còn với các mô hình mạng lớn hơn, một router sẽ không có khả năng quản lý tất cả các thiết bị nên cần đến máy chủ chuyên dụng để thực hiện việc cấp IP.

## DHCP Server là gì? 
DHCP server là một máy chủ thực hiện việc kết nối mạng. Nó có chức năng phản hồi thông tin khi máy trạm (DHCP client) phát yêu cầu. Ngoài ra, DHCP server còn có nhiệm vụ truyền thông tin một cách hợp lý nhất đến các thiết bị, đồng thời, thực hiện cấu hình cổng mặc định (Default gateway) hay Subnet mask.

![](/pictures/dhcp-la-gi-2.jpg)

## DHCP Client là gì?

DHCP Client được định nghĩa là máy trạm chạy dịch vụ DHCP. DHCP Client được sử dụng để thực hiện đăng ký, cập nhật thông tin về địa chỉ IP cùng với những bản ghi DNS cho chính nó. Cụ thể, khi cần một địa chỉ IP hay tham số TCP/IP để làm việc trong hệ thống mạng, DHCP Client sẽ tiến hành gửi yêu cầu đến DHCP Server. 

## Ưu điểm của DHCP
- DHCP có chức năng cho phép cấu hình tự động. Nhờ thế, tốc độ kết nối mạng của các thiết bị nhanh hơn.
- Giúp quản lý địa chỉ IP khoa học, tránh được tình huống bị trùng lắp IP và hệ thống mạng hoạt động ổn định hơn.
- Địa chỉ IP, tham số TCP/IP được quản lý dễ dàng thông qua các trạm.
- Người quản trị mạng có thể tùy ý thay đổi cấu hình, thông số IP theo nhu cầu sử dụng để nâng cấp hạ tầng.
- Cho phép các thiết bị di chuyển qua lại giữa các mạng và nhận địa chỉ IP mới tự động.

## Nhược điểm của DHCP là gì?
Dù mang lại nhiều ưu điểm nổi bật nhưng DHCP cũng không tránh khỏi việc tồn tại một số hạn chế. Cụ thể:

- Việc dùng địa chỉ IP động không phù hợp với những thiết bị cố định, có tần suất truy cập cao, liên tục như máy in, file server.
- DHCP chỉ phù hợp cho các mô hình mạng nhỏ hoặc tại hộ gia đình. 
## Các thông điệp giao tiếp giữa DHCP Server và DHCP Client là gì?
- DHCP Discover: Đây là một gói thông tin được gửi đến DHCP server bởi một thiết bị yêu cầu cung cấp địa chỉ IP để truy cập mạng. 

- DHCP Offer: Đây là gói thông tin chứa địa chỉ IP, cấu hình TCP/IP bổ sung. DHCP Offer được máy chủ DHCP gửi phản hồi cho Client sau khi nhận DHCP Discover.

- DHCP Request: Đây là gói thông tin được DHCP Client trả lời cho server về sự chấp nhận đối với IP, sau khi nó nhận được DHCP Offer.

- DHCP Acknowledge: Đây là gói thông tin mà máy chủ DHCP phản hồi lại cho Client nhằm xác định là đã chấp nhận DHCP Request, đồng thời, định hướng những tham số tùy chọn để thực hiện việc cho phép Client truy cập mạng TCP/IP, cũng như hoàn tất hệ thống khởi động.

- DHCP Nak: Nếu Client không sử dụng địa chỉ IP do nó không còn giá trị hoặc đã được máy khác dùng, thì máy chủ DHCP thực hiện gửi một gói DHCP Nak. Sau đó, Client phải thực hiện lại quá trình thuê bao.

Như vậy, DHCP Nak là một gói thông tin do máy chủ gửi đến Client, trong trường hợp nó nhận được yêu cầu xuất phát từ một IP không có giá trị. Việc xác định địa chỉ IP có hay không có giá trị được dựa vào phạm vi mà nhà sản xuất đã cấu hình cho máy chủ.

- DHCP Decline: Khi DHCP Client quyết định các tham số trong đề nghị không có giá trị, nó thực hiện gửi gói DHCP Decline đến máy chủ và lúc này Client phải làm lại tiến trình thuê bao.

- DHCP Release: Đây là gói tin mà DHCP Client gửi đến máy chủ để giải phóng địa chỉ IP, đồng thời, thực hiện xóa các thuê bao đang tồn tại.

![](/pictures/dhcp-la-gi-3.jpg)

## Cách xử lý lỗi xung đột IP với DHCP 

Mặc dù vai trò của DHCP là tự động gán IP cho các thiết bị, nhưng đôi khi chính bản thân DHCP gặp lỗi gây ra lỗi xung đột IP. Trong trường hợp này, để khắc phục, người quản trị chỉ việc thực hiện giải phóng các địa chỉ IP bị trùng. Nếu lỗi vẫn chưa được khắc phục thì khởi động lại router. Tuy nhiên, khi bạn đã sử dụng cả 2 cách trên nhưng không được thì điều đó có nghĩa lỗi phát sinh không phải do DHCP hay router. 

## Những cuộc tấn công có thể xảy ra với cấu hình DHCP là gì? 
Thực tế, có thể xảy ra 2 tình huống mà DHCP bị tấn công là dùng máy trạm DHCP Client bất hợp pháp và DHCP server bất hợp pháp.

### Khi DHCP Client bất hợp pháp
Đối với trường hợp này, máy trạm Client rơi vào tình huống yêu cầu gửi cấp IP liên tục về máy chủ. Và server sẽ tự động cấp IP cho Client không xác thực cho đến khi hết địa chỉ.

Tất nhiên, kết quả mà nó mang lại là làm cạn nguồn địa chỉ dành cho những máy trạm hợp pháp, khiến hệ thống bị trì trệ, nhiều máy trạm không thể truy cập vào mạng được. Kiểu tấn công này rất đơn giản, thực hiện dễ dàng chỉ với băng thông mà không làm tốn nhiều thời gian của hacker.

### Khi DHCP server bất hợp pháp
 Khi hacker phá vỡ tường bảo vệ mạng, chúng sẽ có được quyền kiểm soát máy chủ DHCP và xâm nhập để điều khiển hệ thống. Thông thường có 3 kiểu tấn công máy chủ DHCP bất hợp pháp.

- DoS hệ thống mạng: Hacker thiết lập một dải IP, subnet mask khiến các máy trạm không đăng nhập được vào hệ thống, dẫn đến DoS mạng. 

- DNS redirect: Thông qua viêc thay đổi DNS các máy trạm, các lượt truy cập sẽ bị dẫn đến những website giả có chứa mã độc, virus nhằm mục đích đánh cắp thông tin của người dùng.

- Man-in-the-middle: Kiểu tấn công này nhắm vào cổng mặc định bằng cách chuyển đổi chúng về máy của hacker. Điều này có nghĩa, những yêu cầu từ Client gửi đến Default gateway sẽ được tự động chuyển đến máy của hacker trước khi đến cổng mặc định. Từ đó, hacker dễ dàng sao chép, đánh cấp tất cả thông tin của người truy cập. Tuy nhiên, kiểu tấn công này chỉ giúp hacker xem được các thông tin gửi ra ngoài mạng. Còn nội dung từ bên ngoài gửi đến máy trạm Client thì chúng không xâm nhập được.

## Giải pháp bảo mật cho DHCP
Với mỗi loại tấn công sẽ có giải pháp bảo mật DHCP riêng. Cụ thể:

### Tấn công bằng DHCP Client bất hợp pháp
Để đối phó với kiểu tấn công này, bạn sử dụng các switch có độ bảo mật cao. Chúng sẽ giúp giới hạn số lượng địa chỉ MAC trên một cổng. Nhờ thế, hệ thống sẽ không xảy ra tình trạng có quá nhiều địa chỉ MAC được dùng trên một cổng tại cùng một thời điểm. Khi có nhiều địa chỉ vượt mức quy định thì cổng sẽ ngừng phục vụ và chúng chỉ có thể tái hoạt động vào thời gian đã được thiết lập bởi quản trị viên.

### Tấn công Man-in-the-middle
Bạn dùng switch có độ bảo mật DHCP snooping cao để làm giải pháp bảo mật cho DHCP trước kiểu tấn công này. Các switch có tác dụng hạn chế kết nối có dấu hiệu nghi ngờ từ DHCP đến các cổng. Đồng thời, chỉ có những kết nối có độ tin cậy cao mới cho phép gói tin DHCP response hoạt động. Tất nhiên, chỉ có cổng này mới được quyền kết nối đến máy chủ thật.

### Các giải pháp khác thường được dùng để bảo mật DHCP server

- Lưu trữ dữ liệu an toàn bằng cách dùng hệ thống tập tin NTFS.
- Thường xuyên cập nhật phiên bản mới của windows và các phần mềm.
- Thường xuyên quét virus cho hệ thống.
- Sàng lọc và loại bỏ những phần mềm hay các dịch vụ không cần thiết.
- Dùng tường lửa để bảo mật cho máy chủ DHCP.
- Sử dụng hình thức bảo mật vật lý cho máy chủ.

![](/pictures/dhcp-la-gi-4.jpg)

## Cấu hình DHCP trên Router
Để giúp bạn dễ hình dung cách thực hiện cấu hình DHCP trên router. Hosting Việt sẽ làm ví dụ sau:

Cấu hình và cấp phát IP mạng 192.168.1.0/24 cho các máy tính thuộc Phòng 1, mạng 172.16.0.0/16 cho các máy tính thuộc Phòng 2. Sau khi được cấp phát IP, các máy tính có thể ping thấy nhau, đồng thời, truy cập được website trên máy chủ thông qua DNS có trong DHCP.

Câu lệnh để thực hiện:

Ở configure mode: 
 ip dhcp pool

Với pool name: Là tên bạn tùy chọn đặt cho dãy IP cấu hình. Thông thường, người ta sẽ đặt theo tên gọi của phòng ban để tiện quản lý dãy IP cấp phát. Chẳng hạn như DHCP_PhongKinhDoanh, DHCP_PhongNhanSu… Trong ví dụ này, pool name tương ứng với Phong1, Phong2.

 network <địa chỉ của mạng cần cấp>

 default-router <địa chỉ cổng của mạng được cấp IP>

 dns-server <địa chỉ DNS server cấp cho clients> (chỉ sử dụng trong trường hợp có DNS server)                           

Trên router, bạn lần lượt sử dụng các lệnh để cấu hình DHCP là gì sau:

 ip dhcp pool DHCP_Phong1

 network 192.168.1.0 255.255.255.0

 default-router 192.168.1.1

 dns-server 10.0.0.2

 ip dhcp pool DHCP_Phong2

 network 172.16.0.0 255.255.0.0

 default-router 172.16.0.1

 dns-server 10.0.0.2
Sau khi hoàn tất cấu hình, các máy tính đã nhận được địa chỉ IP và bạn có thể thực hiện lệnh ping để chúng thấy nhau. Sau đó, bạn bắt đầu truy cập website trên server.  

Nguồn: [hostingviet](https://hostingviet.vn/dhcp-la-gi)