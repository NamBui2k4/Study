# Protocol Data Unit (PDU) - đơn vị dữ liệu giao thức 
Trong mô hình mạng  OSI (Open Systems Interconnection), dữ liệu truyền từ máy nguồn đến máy đích thông qua mạng sẽ được chia nhỏ thành nhiều phần gọi là PDU.

Tuy nhiên, PDU cũng chỉ là tên gọi chung của nhiều "loại" PDU khác nhau. Nói như vậy có nghĩa là, có rất nhiều loại PDU khác nhau tồn tại trong mô hình OSI tùy thuộc PDU đó nằm ở tầng nào. Dưới đây là các ví dụ về PDU ở một số tầng cụ thể:

1. Physical Layer (Tầng Vật lý): PDU được gọi là Bit (1 hoặc 0).

2. Data Link Layer (Tầng Liên kết Dữ liệu): PDU được gọi là Frame (Khung).
   Trong Ethernet, PDU là Ethernet Frame.

3. Network Layer (Tầng Mạng): PDU được gọi là Packet (Gói).
    Trong IP, PDU là IP Packet.

3. Transport Layer (Tầng Giao thông): PDU được gọi là Segment (Đoạn) hoặc Datagram.
    Trong TCP, PDU là TCP Segment; trong UDP, PDU là UDP Datagram.

4. Session Layer (Tầng Phiên): PDU được gọi là Data.

5. Presentation Layer (Tầng Trình bày): PDU được gọi là Data.

6. Application Layer (Tầng Ứng dụng): PDU được gọi là Data.

Mỗi tầng sẽ thêm thông tin điều khiển (control information) vào PDU của mình để hỗ trợ các chức năng cụ thể tại tầng đó. Khi dữ liệu được truyền qua các tầng, các thông tin điều khiển này có thể được thêm vào hoặc loại bỏ tùy thuộc vào cơ sở hạ tầng mạng cụ thể và yêu cầu của ứng dụng.