# BĂNG THÔNG (BANDWIDTH)
__Băng thông là gì?__
Đây là một thuật ngữ dùng trong lĩnh vực công nghệ. Nó ám chỉ __tốc độ tối đa__ mà trang Web có thể truyền tải trong một đơn vị thời gian. Về lý thuyết, băng thông càng lớn thì tốc độ truyền dữ liệu càng nhanh và ngược lại. Nếu tìm hiểu kỹ băng thông là gì, chúng ta sẽ thấy có khá nhiều đơn vị khác nhau để đo lường. Tuy nhiên, Mbps là đơn vị được sử dụng khá rộng rãi nhất hiện nay.

![](/pictures/BANDWIDTH.png)

__Đánh giá chất lượng băng thông__
Có thể thấy, Băng thông chính là thước đo hiệu suất mạng. Chất lượng của băng thông sẽ được đánh giá bằng 3 tiêu chí:
- Độ trễ (Latency)
- Thông lượng(Throughput)
- Lưu lượng (Goodput)

Dưới đây là giải thích cho mỗi thuật ngữ:
1. Độ trễ (Latency): đề cập đến thời gian, bao gồm cả các độ trễ, mà dữ liệu mất để đi từ một điểm cụ thể đến một điểm khác.

2. Thông lượng (Throughput):
- đây là đơn vị đo lường sự chuyển đổi của các bit qua thiết bị mạng trong một khoảng thời gian nhất định.
- Thường thì throughput thấp hơn băng thông đã được chỉ định khi triển khai tầng vật lý. 
- Nhiều yếu tố ảnh hưởng đến throughput, bao gồm:
    - số lượng thiết bị mạng 
    - loại thiết bị mạng
    - độ trễ của thiết bị
- Trong một mạng lưới hoặc một mạng có nhiều đoạn, throughput không thể nhanh hơn đường truyền chậm nhất trong đường dẫn từ nguồn đến đích.
- Dù các đoạn đều có băng thông cao, chỉ cần một đoạn với throughput thấp là có thể tạo nên "thắt nú cổ chai" (bottleneck) trong đường đi của toàn bộ mạng.
3. Goodput (Lưu lượng hữu ích):
- Goodput là một đo lường khác để đánh giá việc chuyển đổi dữ liệu có thể sử dụng được; nó là lưu lượng dữ liệu có thể sử dụng được được chuyển qua trong một khoảng thời gian nhất định.
Goodput thường thấp hơn throughput vì nó bao gồm throughput trừ đi các chi phí liên quan đến việc thiết lập các phiên, xác nhận, đóng gói, và các bit được gửi lại (retransmitted bits).
Goodput luôn thấp hơn throughput, và thông thường cũng thấp hơn băng thông đã định.

# Băng thông so với Thông lượng: Sự khác biệt và So sánh
Băng thông là lượng dữ liệu tối đa được truyền qua mạng hoặc kết nối. Đồng thời, thông lượng là lượng dữ liệu được truyền qua mạng hoặc kết nối.

Băng thông là một phép đo lý thuyết, trong khi thông lượng là một phép đo thực tế.

Băng thông được biểu thị bằng bit trên giây (bps), trong khi thông lượng được biểu thị bằng byte trên giây (Bps).