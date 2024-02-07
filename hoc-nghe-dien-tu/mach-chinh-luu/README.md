# Mạch chỉnh lưu là gì? Phân loại và chức năng của mạch chỉnh lưu?

_POSTED ON 26 THÁNG CHÍN, 2022 BY ADMIN123_

Mạch chỉnh lưu là gì? Phân loại và chức năng của mạch chỉnh lưu? Trong bài viết này hãy cùng Cơ Khí Việt Hàn tìm hiểu về mạch chỉnh lưu nhé.

## Khái niệm và phân loại mạch chỉnh lưu

__Mạch chỉnh lưu là gì__

    Mạch chỉnh lưu (còn có tên gọi khác là Cầu
    đi-ốt) là mạch điện cho phép chuyển đổi dòng
    điện xoay chiều (AC) thành dòng điện một chiều
    (DC). Chỉnh lưu giống như một cái van chỉ cho
    phép nước đi qua nó theo một chiều nhất định.
\
![](/pictures/chuc-nang-cua-mach-chinh-luu.png) 

_Ghi chú: "Tải" có thể là bất kỳ thứ gì, miễn là nó tiêu thụ điện, ví dụ: bóng đèn, điện trở, động cơ điện, laptops,..._


![](/pictures/1-Hình-ảnh-thực-tế-của-cầu-Diode-400x400.jpg)
\
__Tại sao chúng ta cần chuyển dòng điện xoay chiều (AC) thành dòng điện một chiều (DC)?__

Trong thực tế, mạng lưới điện quốc gia và các hộ gia đình đều sử dụng điện xoay chiều, nhưng các thiết bị điện tử mà chúng ta hay dùng là laptops, điện thoại,.. lại chỉ sử dụng điện một chiều. Đó là vì dòng điện của chúng luôn cố định về điện áp và tần số. Đó cũng là lý do mà chúng ta hay thấy những thiết bị như laptop luôn đi kèm một cục adapter, là bởi trong cục adapter ấy chứa một mạch chỉnh lưu điều đỉnh nguồn AC thành DC

![](/pictures/adapter.png)
\
__nguyên lý hoạt động của mạch chỉnh lưu__

_Trước khi đi vào nguyên lý, cần nhắc lại rằng: điốt là một linh kiện chỉ cho phép dòng điện đi qua 1 chiều duy nhất mà không có chiều ngược lại. Hình dạng của điốt có một mũi tên cho ta biết chiều dòng điện luôn hướng theo mũi tên đó_

![](/pictures/diode.png)
\
Một mạch chỉnh lưu gồm có bốn điốt được gán nhãn từ D1 đến D4, sắp xếp thành “cặp nối tiếp” sao cho chỉ có hai điốt dẫn điện trong mỗi nửa chu kỳ

![](/pictures/Sơ-đồ-nguyên-lý-cầu-diode.gif)

- Nửa chu kỳ dương: điốt D1 và D2 ​​dẫn điện trong khi điốt D3 và D4 được phân cực ngược và không dẫn điện.

![](/pictures/nửa-chu-kỳ-dương.gif)

- Nửa chu kỳ âm: điốt D3 và D4 dẫn nối tiếp, nhưng điốt D1 và D2 ​​chuyển sang “TẮT” vì chúng được phân cực ngược. Dòng điện chạy qua tải có chiều như cũ.

Vì dòng điện chạy qua tải là một chiều, do đó điện áp đi qua tải cũng là một chiều. 

Bên cạnh đó, trong mỗi nửa chu kỳ, vì dòng điện chạy qua cả hai điốt nên biên độ của điện áp đầu ra đã bị giảm đi 2 lần (nhỏ hơn điện áp đầu vào). Ngược lại, tần số dòng điện lại tăng gấp đôi so với tần số nguồn cung cấp (ví dụ: 100Hz đối với nguồn cung cấp 50Hz hoặc 120Hz đối với nguồn cung cấp 60Hz.)

__Phân loại mạch chỉnh lưu:__
- Phân loại theo loại linh kiện bán dẫn trong mạch

    + Mạch chỉnh lưu không điều khiển sử dụng diode

    + Mạch chỉnh lưu có điều khiển sử dụng SCR hay thyristor

    + Mạch chỉnh lưu bán điều khiển sử dụng diode và SCR

- Phân loại theo số pha nguồn cấp: một pha, hai pha, ba pha, 6 pha…

- Phân loại theo sơ đồ mắc linh kiện có hai loại

    + Mạch chỉnh lưu hình tia: Ở sơ đồ này số lượng linh kiện sẽ bằng với số pha của nguồn cấp cho mạch. Tất cả các linh kiện đấu chung một đầu nào đó với nhau hoặc cực âm chung hoặc cực dương chung.
\
    + Sơ đồ mạch cầu: Ở sơ đồ này số lượng linh kiện bán dẫn nhiều gấp đôi số nguồn cấp cho mạch. Trong đó một nửa số linh kiện mắc chung cực âm, một nửa kia lại mắc chung nhau cực dương.

⟹ Như vậy, khi gọi tên một mạch chỉnh lưu người ta dùng 3 dấu hiệu trên để chỉ cụ thể mạch đó. Ví dụ mạch chỉnh lưu cầu 3 pha bán điều khiển là mạch chỉnh lưu mắc theo kiểu sơ đồ cầu, nguồn cấp cho mạch là 3 pha và sử dụng cả diode và SCR.

__Ứng dụng của mạch chỉnh lưu?__

Trong các bộ nguồn, mạch chỉnh lưu thường mắc với biến áp, bộ lọc phẳng điện áp và có thể là bộ điều khiển điện áp. Một vài ứng dụng của mạch chỉnh lưu là:

__Sử dụng trong máy hàn__

![](/pictures/chuc-nang-cua-mach-chinh-luu-2.png)
\
Nguyên lý của máy hàn là tạo ra hồ quang giữa hai khi cho tiếp xúc giữa cực dương và cực âm của nguồn thông qua que hàn. Người ta sẽ chuyển điện áp xoay chiều có giá trị lớn thành điện một chiều khoảng 30V. Do ta giảm điện áp ở ngõ ra nên ra máy hàn sẽ có khả năng cung cấp dòng điện ngõ ra lớn.

__Sử dụng trong các bộ nguồn__

Như chúng ta đã biết, hầu hết các mạch điện bên trong các thiết bị điện đều sử dụng nguồn điện xoay chiều để hoạt động. Sử dụng mạch chỉnh lưu trong nguồn điện giúp chuyển đổi nguồn điện AC thành DC. Trong đó nổi bật nhất là mạch chỉnh lưu cầu, được sử dụng rộng rãi trong các thiết bị lớn. Nơi chúng có khả năng chuyển đổi điện áp xoay chiều cao thành điện một chiều thấp.

Việc sử dụng máy biến áp là cách đơn giản để thay đổi được ngõ ra là điện áp một chiều mong muốn. Khi đó mạch chỉnh lưu có thể cấp nguồn cho động cơ, đèn led hoặc các thiết bị hoạt động với điện một chiều.

__Diode Flyback__

Trong một số ứng dụng để bảo vệ các linh kiện khi có điện áp ngược trả về. Khi mạch điều khiển đóng ngắt tải có tính cảm, khi tải bị ngắt điện thì nó sẽ phát ra dòng điện. Để triệt tiêu dòng điện này người ta sử dụng mạch chỉnh lưu với một diode đã xả hết dòng điện trên tải.

__Ứng dụng trong bộ AM radio__  
Bộ chỉnh lưu cũng được sử dụng để phát hiện các tín hiệu vô tuyến được điều chế biên độ. Tín hiệu có thể được khuếch đại trước khi phát hiện. Nếu không, phải sử dụng diode điện áp rơi rất thấp hoặc diode phân cực với điện áp cố định.

Khi sử dụng bộ chỉnh lưu để giải điều chế, tụ điện và điện trở tải phải được kết hợp cẩn thận: điện dung quá thấp làm cho sóng mang tần số lớn đi đến ngõ ra hoặc quá cao làm cho tụ điện chỉ nạp điện một lần mà không xã điện.



Nguồn:

- [cokhiviethan](https://cokhiviethan.com.vn/mach-chinh-luu-la-gi-phan-loai-va-chuc-nang-cua-mach-chinh-luu.html#:~:text=M%E1%BA%A1ch%20ch%E1%BB%89nh%20l%C6%B0u%20l%C3%A0%20m%E1%BA%A1ch%20%C4%91i%E1%BB%87n%20cho%20ph%C3%A9p,%C4%91i%20qua%20n%C3%B3%20theo%20m%E1%BB%99t%20chi%E1%BB%81u%20nh%E1%BA%A5t%20%C4%91%E1%BB%8Bnh.)
- [linhkienhatech](https://linhkienhatech.com/blogs/news/cau-di-ot-la-gi-hieu-ro-cau-diode-trong-5-phut#:~:text=C%E1%BA%A7u%20diode%20hay%20c%C3%B2n%20g%E1%BB%8Di%20l%C3%A0%20b%E1%BB%99%20ch%E1%BB%89nh,chi%E1%BB%81u%20AC%20th%C3%A0nh%20%C4%91i%E1%BB%87n%20%C3%A1p%20m%E1%BB%99t%20chi%E1%BB%81u%20DC.)
- [Học nghề kỹ sư điện tử](https://www.youtube.com/watch?v=X13h7FyqMZE)