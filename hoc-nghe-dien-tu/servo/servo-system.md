# Hệ Thống Điều Khiển Servo (AC Servo)

Đã bao giờ bạn thấy các chuỗi chuyền sản xuất sử dụng cánh tay rôbot tự động hàn và lắp ráp chi tiết máy móc hay chưa ? Đó chính là hệ thống servo, một trong những hệ thống tự động hóa hiện đại nhất trong nền sản suất công nghiệp nặng ở thời điểm hiện tại. Hệ thống servo được sử dụng rộng rãi trong các máy công cụ tự động, ăng-ten theo dõi vệ tinh, máy bay điều khiển từ xa, hệ thống định vị tự động trên tàu thuyền và máy bay, và hệ thống điều khiển súng phòng không.

![](/pictures/servo.jpg)
\

## Khái niệm về hệ thống Servo 
Servo là một hệ thống gồm bốn bộ phận cấu thành là:
- Bộ điều khiển lập trình (PLC)
- Servo driver (bộ khuếch đại)
- Servo motor  (động cơ)
- encoder (bộ giải mã)

Đây là hệ thống truyền động điều khiển hồi tiếp vòng kín, nhận tín hiệu và thực hiện một cách nhanh chóng và chính xác theo lệnh từ PLC. 

Dưới đây là hình ảnh về một hệ thống servo cơ bản nhất

![](/pictures/bo-ac-servo-h178.jpg)

Chức năng chính của Servo đó là điều khiển vị trí, thay đổi tốc độ chính xác, điều chỉnh momen phù hợp với những ứng dụng công việc.

## Nguyên lý cơ bản
PLC gửi lệnh điều khiển đến Driver, Driver sẽ tính toán để cấp tần số dòng điện phù hợp cho động cơ chạy, động cơ chạy truyền chuyển đồng từ đầu trục để cơ cấu chuyển động di chuyển đến vị trí yêu cầu, đồng thời động cơ phản hồi tốc độ và vị trí liên tục về cho driver so sánh với giá trị đặt, đồng thời các giá trị phản hồi về đều được gửi về PLC để giám sát và điều khiển, màn hình HMI hiển thì toàn bộ thống số của hệ thống và cho phép vận hành bằng tay hệ thống

## Phương pháp điều khiển

- Phương pháp điều khiển bằng xung: PLC sẽ phát xung tốc độ cao cho servo driver và động cơ sẽ chạy đúng số xung và tần số xung do PLC phát ra. Với phương pháp này thì một PLC của hãng này có thể điều khiển cho servo của hãng khác.

![](/pictures/phuong-phap-dieu-khien.jpg)
\
- Phương pháp dùng mạng truyền thông SSCNET: ở phương pháp này, các tín hiệu diều khiển từ PLC cho driver đều được thực hiện qua mạng truyền thông với module điều khiển servo. Các thống số của hệ thống đêu đều được đưa về PLC, do vậy việc giám sát sẽ dễ dàng hơn

Với phương pháp sử dụng SSCNET thì chỉ áp dụng cho PLC và servo của cùng một hãng

## Nguyên lý điều khiển Servo

1. Nguyên lý mạch động lực

- Nguồn điện xoay chiều 3 pha thông qua mạch chỉnh lưu sẽ trở thành điện một chiều, sau đó bộ tụ điện chỉnh nguồn một chiều thành dạng tương đối phẳng.
|
- Bộ biến tần thực chất là bộ nghịch lưu chuyển đổi điện một chiều thành điện xoay chiều 3 pha, xử dụng nguyên lý điều khiển đóng ngắt các cặp van bán dẫn theo một tần số nào đó sẽ tạo ra được dòng điện xoay chiểu. Bản chất là bộ băm xung điều áp.
|
- Khi động cơ dừng cần có hãm thì dòng điện phát ra từ động cơ sẽ quay lại bộ điều khiển, lúc này bộ hãm tái sinh sẽ có chức năng tiêu thụ dòng hãm tái sinh đó bằng điện trở xả.

![](/pictures/mach-dong-luc.jpg)


Nguồn: [dongluchp](https://dongluchp.com/he-thong-servo/)
