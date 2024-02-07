Nguồn Bài viết: [@HuyenNguyen](https://viblo.asia/p/tim-hieu-giao-thuc-ip-phan-1-bJzKmxer59N)

# giao thức IP (Phần 1)

Các máy tính trên mạng "nói chuyện" với nhau thông qua một ngôn ngữ đặc biệt gọi các giao thức mạng. Có nhiều giao thức khác nhau và mỗi giao thức đều có một nhiệm vụ riêng như:

- Giao thức truyền dữ liệu, dùng để vận chuyển dữ liệu giữa 2 máy tính.
- Giao thức xử lý dữ liệu có nhiệm vụ xử lý dữ liệu nhận được từ giao thức truyền dữ liệu.

Giao thức IP là một giao thức của chồng giao thức TCP/IP thuộc tầng mạng

# Đặc điểm của giao thức IP

- Là 1 trong những giao thức quan trọng nhất của bộ giao thức TPC/IP.

- Là giao thức hướng không liên kết (connectionless): không có bất kì cơ chế thiết lập kết nối , không có cơ chế báo nhận hay điều khiển luồng nào được sử dụng với IP, các gói tin IP cũng không được đánh số thứ tự khi trao đổi trên mạng… 

    Về cơ bản, nó giống như việc gửi thư mà không báo trước cũng như không cần phản hồi

![](/pictures/conectionless.png)

- dữ liệu của IP được truyền đi ngay lập tức nếu có thể (best effort). Dữ liệu được truyền đi dưới dạng các gói (packet) nhỏ. Mỗi gói bao gồm thông tin định tuyến, cho phép các thiết bị định tuyến nó trên mạng rồi gửi đến đích. Tuy nhiên, một vài gói  có thể bị mất trên đường truyền

- Không có cơ chế khôi phục lại gói tin bị mất trên đường truyền. Điều này là do giao thức IP là một giao thức không liên kết, có nghĩa là nó không đảm bảo rằng dữ liệu sẽ được truyền đi nguyên vẹn, không bị mất hoặc thay đổi. IP chỉ chịu trách nhiệm gửi dữ liệu đến đích, còn việc dữ liệu có được truyền đi nguyên vẹn hay không là do các giao thức tầng cao hơn chịu trách nhiệm. 

![](/pictures/best_effort.png)

- Mỗi gói tin IP được xử lý một cách hoàn toàn độc lập với các gói tin IP khác . 

![](/pictures/independent-media.png)

# Địa chỉ IP

Theo lý thuyết, IP là một giao thức, nhưng chúng ta thường gọi nó là địa chỉ IP vì ngoài việc giúp các thiết bị giao tiếp với nhau thì nó còn chức năng định danh các thiết bị trên mạng. Giống như việc ta định danh một ngôi nhà ở bằng địa chỉ thường trú của nó.

Địa chỉ IP là một chuỗi ký tự. Có 2 loại địa chỉ IP
- Ipv4 (ip version 4)
- Ipv6 (ip version 6)



