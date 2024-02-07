# Hypothesis Testing là gì? 
# Các bước thực hiện Hypothesis Testing trong phân tích dữ liệu

Trong lĩnh vực khoa học dữ liệu và thống kê, Hypothesis Testing (Kiểm định giả thuyết) là một công cụ quan trọng giúp chúng ta đưa ra quyết định dựa trên dữ liệu mẫu. Đây là một quy trình phân tích mạnh mẽ giúp chúng ta khám phá sự thật và đưa ra những kết luận có tính xác thực.

## Hypothesis Testing là gì?

![](/pictures/HT.png)

_Hypothesis Testing (Kiểm định giả thuyết) là quá trình thống kê để xác định xem có đủ bằng chứng để chấp nhận hay bác bỏ một giả thuyết về bộ tham số θ của tổng thể dựa trên mẫu dữ liệu_

Hypothesis Testing là một phương pháp quan trọng trong quá trình nghiên cứu và phân tích dữ liệu. Nó giúp chúng ta đưa ra những kết luận có tính xác thực dựa trên dữ liệu mẫu, từ đó hỗ trợ quyết định trong các lĩnh vực như y tế, kinh tế, xã hội học, và nhiều lĩnh vực khác.

## Một số khái niệm

__Giả thuyết__

Có 2 loại:

- Giả thuyết không, ký hiệu $H_0$ là một giả thuyết ban đầu về θ 

- Đối thuyết, ký hiệu $H_1$ , đối lập với giả thuyết $H_0$

__Sai lầm loại I và sai lầm loại II__

- Sai lầm loại I  là bác bỏ $H_0$ khi nó đúng.

Xác suất để mắc sai lầm loại này gọi là mức ý nghĩa của kiểm định, ký hiệu $\alpha$. Ngược lại, xác suát để ta không mắc sai lầm (chấp nhận $H_0$ - quyết định đúng đắn) là $1 - \alpha$

- Sai lầm loại II  là sai lầm mà ta chấp nhận $H_0$ khi nó sai

Xác suất để mắc sai lầm loại này được ký hiệu $\beta$. Ngược lại, xác suát để ta không mắc sai lầm (Bác bỏ $H_0$ - quyết định đúng đắn) là $1 - \beta$

Ta có bảng tóm tắt sau:

|            | $H_0$ đúng	                      |  $H_0$ sai ($H_1$ đúng)
|------------|--------------------------------|------------------------------------
|Bác bỏ $H_0$   | Sai lầm loại I. Xác suất α	  |  Quyết định đúng. xác suất (1 – β)
|Chấp nhận $H_0$|Quyết định đúng. Xác suất (1- α)|	Sai lầm loại 2. Xác suất β

## Các loại kiểm định

Trong quá trình kiểm định, ta có 3 hướng kiểm định sau:

- Kiểm định giả thuyết trái
- Kiểm định giả thuyết phải
- Kiểm định giả thuyết hai bên

![](/pictures/HT-3-case.png)

![](/pictures/1-side-HT.png)

## Các bước thực hiện Hypothesis Testing
Bước 1: Xác định giả thuyết

‍

Trước khi thực hiện Hypothesis Testing, chúng ta cần xác định giả thuyết ban đầu. Giả thuyết này bao gồm giả thuyết không và giả thuyết thay thế. Giả thuyết không (null hypothesis) thường là giả thuyết rằng không có sự khác biệt hoặc không có tác động của biến độc lập đến biến phụ thuộc. Giả thuyết thay thế (alternative hypothesis) đại diện cho giả thuyết mà chúng ta muốn chứng minh.




‍

Bước 2: Xác định mức ý nghĩa

‍

Mức ý nghĩa (significance level) là ngưỡng quyết định để xác định liệu dữ liệu mẫu có đủ bằng chứng để bác bỏ giả thuyết không hay không. Thông thường, mức ý nghĩa phổ biến là 0.05, tương đương với 5%. Điều này có nghĩa là nếu giá trị p (p-value) nhỏ hơn 0.05, chúng ta sẽ bác bỏ giả thuyết không.

‍

Bước 3: Thu thập dữ liệu và thực hiện phân tích

‍

Sau khi đã xác định giả thuyết và mức ý nghĩa, chúng ta tiến hành thu thập dữ liệu và thực hiện phân tích. Phân tích có thể bao gồm sử dụng các phương pháp thống kê như t-test, chi-square test, ANOVA, và nhiều phương pháp khác phù hợp với từng trường hợp cụ thể.

‍

Bước 4: Tính toán giá trị p và đưa ra kết luận

‍

Sau khi hoàn thành phân tích, chúng ta tính toán giá trị p. Giá trị p là xác suất để dữ liệu mẫu được quan sát có thể xảy ra nếu giả thuyết không đúng. Nếu giá trị p nhỏ hơn mức ý nghĩa đã xác định, chúng ta sẽ bác bỏ giả thuyết không và chấp nhận giả thuyết thay thế.

Nguồn: [_coderschool.vn_](https://www.coderschool.vn/blog/hypothesis-testing-la-gi-cac-buoc-thuc-hien-hypothesis-testing-trong-phan-tich-du-lieu)

