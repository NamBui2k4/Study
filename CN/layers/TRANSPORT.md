# Tầng giao vận (Transport Layer)

Tầng giao vận là tầng thứ tư trong mô hình OSI (Open System Interconnection). Chức năng chính của tầng giao vận (Transport Layer) là thiết lập, duy trì và kết thúc các kết nối giữa các ứng dụng trên các thiết bị khác nhau. Bài viết này sẽ giải thích chi tiết về tầng giao vận.

## Chức năng của tầng giao vận (Transport Layer)
Tầng giao vận có các chức năng chính sau:

- Thiết lập kết nối: Tầng giao vận thiết lập kết nối giữa hai hoặc nhiều tiến trình trên thiết bị để chúng có thể giao tiếp với nhau.

-  Tìm lỗi (Error detection): Tầng giao vận phát hiện và xử lý các lỗi trong quá trình truyền tin. Nó đảm bảo dữ liệu được truyền từ nguồn đến đích một cách chính xác và đầy đủ.

- Phân đoạn dữ liệu (segmentation): Tầng giao vận phân chia dữ liệu thành các khối nhỏ hơn để truyền đi. Việc phân đoạn này giúp tối ưu hóa quá trình truyền tin.

- Kiểm soát luồng (Flow control): Tầng giao vận kiểm soát số lượng dữ liệu được truyền đi và đảm bảo người nhận có thể tiếp nhận dữ liệu một cách hiệu quả.

![](/pictures/tranport-layer.jpg)

## Giao thức tầng giao vận

Có hai giao thức phổ biến nhất được sử dụng trong tầng giao vận là Transmission Control Protocol (TCP) và User Datagram Protocol (UDP).

Đối với TCP, mỗi giao thức sẽ cung cấp một kết nối logic (logical communication) giữa các tiến trình ứng dụng đang chạy trên các máy chủ khác nhau. Bằng việc sử dụng kết nối này, các ứng dụng trên các máy chủ có thể gửi tin cho nhau mà không lo ngại về khoảng cách xa cũng như cản trở về cơ sở hạ tầng vật lý

Một điều thú vị là cả 2 loại giao thức được triển khai trên các thiết bị đầu cuối (máy tính, điện thoại, tablet,...) mà không phải trên những thiết bị mạng (router, switch,...)


__1. TCP (Transmission Control Protocol)__

TCP là một giao thức đáng tin cậy được sử dụng để thiết lập kết nối giữa các thiết bị và truyền dữ liệu qua mạng. Khi sử dụng TCP, dữ liệu được phân đoạn và truyền đi theo thứ tự. Người gửi phải chờ đợi xác nhận từ người nhận trước khi gửi các phân đoạn tiếp theo. Điều này đảm bảo rằng dữ liệu được truyền đi một cách chính xác và đầy đủ.

Tuy nhiên, việc kiểm soát luồng của TCP làm tăng độ trễ trong quá trình truyền tin. Nó cũng tốn nhiều băng thông hơn so với UDP

![](/pictures/tcp-transport-layer.jpg)

__2. UDP (User Datagram Protocol)__

UDP là một giao thức không đáng tin cậy được sử dụng cho các ứng dụng yêu cầu tốc độ truyền tin cao, ví dụ như trò chơi trực tuyến. Khi sử dụng UDP, dữ liệu được truyền đi mà không cần kiểm soát luồng hoặc xác nhận từ người nhận. Điều này giúp giảm độ trễ trong quá trình truyền tin và tiết kiệm băng thông.

__Ứng dụng của UDP__

- Streaming multimedia apps: Đây là các ứng dụng truyền phát đa phương tiện, như video, âm thanh, trò chơi trực tuyến. Các ứng dụng này cần tốc độ cao và độ trễ thấp, nên chấp nhận một số mất mát dữ liệu. UDP phù hợp với các ứng dụng này vì nó nhanh chóng và nhẹ nhàng, không cần thiết lập kết nối hay kiểm tra lỗi. Nếu dùng TCP, sẽ gây ra độ trễ và giảm chất lượng truyền phát.

- DNS: Đây là hệ thống tên miền, dùng để chuyển đổi tên miền thành địa chỉ IP và ngược lại. DNS sử dụng UDP để gửi các truy vấn và trả lời đơn giản và nhanh chóng. Nếu dùng TCP, sẽ tốn nhiều thời gian và băng thông để thiết lập kết nối và xử lý lỗi.

- SNMP: Đây là giao thức quản lý mạng đơn giản, dùng để giám sát và điều khiển các thiết bị mạng, như máy tính, máy in, router, switch. SNMP sử dụng UDP để gửi các thông báo và yêu cầu giữa các thiết bị mạng. Nếu dùng TCP, sẽ gây ra độ trễ và tăng tải trên mạng

Tuy nhiên, do không có kiểm soát luồng nên dữ liệu có thể bị gửi đi quá nhanh và phát sinh lỗi trong quá trình truyền tin.

## Đơn vị dữ liệu giao thức của tầng giao vận

Nhắc lại: bất kỳ kiến trúc mạng nào (thường là tcp/ip và osi) đều có các đơn vị dữ liệu giao thức (PDU) ở mỗi tầng mạng. Về cơ bản, chúng là dữ liệu gửi đi nhưng được chia nhỏ thành nhiều phần. Nếu các giao thức đóng vai trò là huyết mạch của hệ thống mạng thì PDU chính là từng tế bào máu được gửi đi trong huyết mạch đó.

Như vậy, Ở tầng Giao vận, các PDU gọi là:

-  __segments__ nếu chúng đươc gửi đi trong giao thức TCP, 

- __Datagram__ nếu chúng được gửi đi trong giao thức UDP

Ta sẽ phân biệt 2 PDU trên thông qua bảng sau:

|Segment                |	Datagram              |
|-----------------------|-------------------------|
| Đơn vị truyền của TCP |	Đơn vị truyền của UDP |
|Có 20 byte tiêu đề và tối đa 65.535 byte payload|	Có 8 byte tiêu đề và tối đa 65.527 byte payload|
|Có các trường: STT, số xác nhận, bộ đếm thời gian, cửa sổ, checksum, báo hiệu khẩn cấp  |	Có các trường: số hiệu cổng nguồn, số hiệu cổng đích, độ dài, checksum
|Đảm bảo sự tin cậy, thứ tự và luồng dữ liệu |Không đảm bảo sự tin cậy, thứ tự và luồng dữ liệu
|Có cơ chế kiểm soát lỗi và kiểm soát tắc nghẽn|Không có cơ chế kiểm soát lỗi và kiểm soát tắc nghẽn
|Có cơ chế thiết lập kết nối ba bước|	Không cần thiết lập kết nối
|Thích hợp cho các ứng dụng cần độ tin cậy cao, như email, web, tệp|	Thích hợp cho các ứng dụng cần tốc độ cao và độ trễ thấp, như video, âm thanh, trò chơi

## Cơ chế bên gửi bên nhận  ở tầng giao vận

Ở trên, ta đã nói rằng tầng giao vận có chức năng  chức năng phân đoạn dữ liệu (segmentation). Điều đó thể hiện rõ ở cách mà nó tổ chức các dữ liệu được gửi đi giữa các máy chủ, mà cụ thể hơn là ở cơ chế bên gửi bên nhận.

Các dữ liệu được truyền đi bởi tầng giao vận có thể được mêu tả như sau:

- Bên gửi: 
    + Tầng giao vận nhận dữ liệu từ ứng dụng
    + Đặt dữ liệu vào một segment/datagram và chuyển cho tầng mạng.  Nếu dữ liệu quá lớn, nó sẽ được chia làm nhiều segment/datagram nhỏ hơn
    + Truyền các segment/datagram đi trên liên kết logic

- Bên nhận: 
    + Tầng mạng nhận các segment/datagram từ liên kết logic
    + Gửi các segment/datagram lên tầng giao vận
    + Tập hợp chúng lại thành một khối dữ liệu và chuyển lên ứng dụng

Nhờ cách vận hành này mà mỗi bên có thể gửi dữ liệu cho nhau một cách "liên mạng", nghĩa là không lo ngại các thiết bị có nằm trong cùng một mạng, miễn là chúng đều có giao thức kết nối phù hợp

![](/pictures/tranport-layer-serviece.jpg.png)

Nếu ta đi sâu hơn vào vấn đề thì ta sẽ thấy bên gửi và bên nhận sẽ có cơ chế đặc biệt để chúng hoạt động hiệu quả. Đó là cơ chế dồn kênh (multiplexing) và ghép kênh (demultiplexing). 

- dồn kênh (multiplexing) - áp dụng cho bên gửi: gộp dữ liệu từ nhiều socket khác nhau thành một dòng dữ liệu duy nhất, và thêm header chứa thông tin về số hiệu cổng nguồn, số hiệu cổng đích, số thứ tự, checksum, 

- phân kênh (demultiplexing) - áp dụng cho bên nhận: tách dòng dữ liệu nhận được thành nhiều dòng dữ liệu riêng biệt, và dựa vào các thông tin của header để xác định socket nào sẽ nhận dữ liệu tương ứng

_Ghi chú: Cái "socket" ở đây là một khái niệm phức tạp nhưng ta có hiểu rằng vai trò của nó là "hộp chứa thư" nếu ta coi bên nhận/bên gửi là ngôi nhà và những lá thư là dữ liệu được gửi/nhận, tức là socket sẽ chứa dữ liệu của người dùng._

_Bất kỳ "hộp chứa thư" nào cũng có Số hiệu cổng (port number) để định danh nó. Mặt khác, trên một header sẽ cũng sẽ có một số hiệu cổng tương ứng với số hiệu cổng trên một socket nào đó. Con số này là số  16-bit có giá trị từ 0 đến 65535._

_Trong thực tế, tồn tại những con số như vậy có giá trị từ 0 đến 1023 và được gọi là số cổng phổ biến (well-known port numbers) vì nó dành riêng cho các giao thức phổ biến (well-known protocol). Các giao thức này chứa các socket như các điểm đầu/cuối của liên kết logic. Ví dụ HTTP có số hiệu cổng của 2 socket đầu cuối là 80, FTP thì là 21_

![](/pictures/multiplexing_and_demultiplexing-f.png)

## Các đặc điểm của tầng giao vận

Tầng giao vận có các đặc điểm sau:

- Đảm bảo giao tiếp giữa các ứng dụng khác nhau.
- Thiết lập kết nối giữa các thiết bị khi cần thiết.
- Điều khiển lỗi và xử lý các lỗi trong quá trình truyền tin.
- Phân đoạn dữ liệu để tối ưu hóa quá trình truyền tin.
- Kiểm soát luồng để đảm bảo người nhận có thể tiếp nhận dữ liệu một cách hiệu quả.

## Ví dụ về tầng giao vận

Một ví dụ phổ biến về tầng giao vận là truyền file qua mạng. Khi người dùng muốn chia sẻ một file cho người khác, tầng giao vận sẽ thiết lập kết nối giữa hai thiết bị để cho phép truyền dữ liệu. Sau đó, dữ liệu sẽ được phân đoạn và truyền qua mạng theo thứ tự. Nếu có lỗi xảy ra trong quá trình truyền tin, tầng giao vận sẽ điều khiển lỗi và xử lý các lỗi đó để đảm bảo dữ liệu được truyền đi một cách chính xác và đầy đủ.

## Mối quan hệ giữa tầng giao vận và tầng mạng

Hãy nhớ rằng, chức năng kết nối giữa các thiết bị (máy tính, điện thoại, tablet,...) là của tầng mạng, còn kết nối các tiến trình trên chính những thiết bị đó mới là của tầng giao vận. Từ đây, ta có mối quan hệ giữa 2 tầng này: mối quan hệ hợp tác và phụ thuộc. 

Tầng giao vận cần dịch vụ của tầng mạng để định tuyến các gói tín (chứa segment/datagram) từ host nguồn đến host đích. Ngược lại, tầng mạng cần dữ liệu của tầng giao vận để đóng gói segment/datagram vào các gói tin và định tuyến trên mạng. 

dịch vụ của tầng giao vận được sinh ra bởi các giao thức như TCP và UDP. Trong khi đó, dịch vụ của tầng mạng được sinh ra từ các giao thức như IP, ICMP, ARP, RARP

## Tìm lỗi

Ta đều biết quá trình truyền dữ liệu ở tầng giao vận luôn xảy ra lỗi. Đặc biệt, sử dụng UDP thì không đảm bảo dữ liệu được gửi đi vẹn toàn, các gói tin có thể lỗi bit (từ 0 -> 1 hoặc 1-> 0) bất  cứ lúc nào. Đó là lý do tầng này có chức năng Tìm lỗi (Error detection).

Ở tầng mạng, tùy vào việc sử dụng giao thức nào mà sẽ có phương pháp tìm lỗi khác nhau:

Đối với tcp:
- phát hiện lỗi: dùng phương pháp checksum
- báo cho người người gửi: dùng cơ chế Acknowledgement, theo đó:
    + ACK (acknowledgements): gói tin được nhận 
    thành công
    
    + NAK (negative acknowledgements): gói tin bị lỗi+ 

- thông báo phản ứng của bên gửi: Truyền lại nếu là NAK

![](/pictures/ack-nack.png)

Checksum được sử dụng để kiểm tra lỗi trong dữ liệu truyền qua mạng, đảm bảo dữ liệu được truyền đến ứng dụng đích một cách chính xác. Có hai loại checksum được sử dụng trong mạng máy tính: checksum ở tầng mạng (IP) và checksum ở tầng giao vận (TCP/UDP). Checksum ở tầng mạng chỉ kiểm tra phần header của gói tin, trong khi checksum ở tầng giao vận kiểm tra cả header và payload của gói tin





## Tổng kết
Tầng giao vận là một phần quan trọng của mô hình OSI. Nó thiết lập, duy trì và kết thúc các kết nối giữa các ứng dụng trên các thiết bị khác nhau. TCP và UDP là hai giao thức phổ biến được sử dụng trong tầng giao vận. TCP là một giao thức đáng tin cậy nhưng tốn nhiều băng thông hơn so với UDP, trong khi đó UDP là một giao thức không đáng tin cậy nhưng tiết kiệm băng thông và giảm độ trễ trong quá trình truyền tin.

Nguồn: [thuemaychuhanoi.com](https://thuemaychuhanoi.com/chuc-nang-va-giao-thuc-tai-tang-giao-van-transport-layer/#:~:text=T%E1%BA%A7ng%20giao%20v%E1%BA%ADn%20l%C3%A0%20t%E1%BA%A7ng%20th%E1%BB%A9%20t%C6%B0%20trong,%E1%BB%A9ng%20d%E1%BB%A5ng%20tr%C3%AAn%20c%C3%A1c%20thi%E1%BA%BFt%20b%E1%BB%8B%20kh%C3%A1c%20nhau.)
