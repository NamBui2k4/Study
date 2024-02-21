Englist version

# What is Supervised learning

supervised learning is when you have input variables (x) and outputs (y) and  use an algorithm to learn the mapping from input and output variables

mapping function: $Y = f(x)$

the goal is to approximate the mapping function

It is calld supervised learning because the process of algorithm 

## What is labeled dataset 
- the data for which you already know the answer 
- example: dataset of animal pictures, each images would be labeled with type of animal it is , like cat, dog,..

Given :
- a set of input features X1,X2,...,Xn

Supervised learning:
- classification
- regression

classification is about predicting the labels, while regression is about predicting the quantity

## features of Dataset
The dataset has atributes called properties, or features. They can be: 

* categorical (animal species, color, genre of music), 
* ordinal (size, rating scales, education level), 
* integer-valued (number of word in text, number of like in a post), 
* real-valued,.

for example, car

## training and testing

Two phases:
- training: model is developed
- testing: model is evaluted, the input data (x) is fed into the hypothesis to generate the predicted output.

Trainning set:

- collection of data, including both input features.
- the training  set is use to teach model how to predict the output from input

Ex: from heigh, predict weight

|Heigh(cm)| Weight (kg) |
|--------|--------|
147|49
|150|50|
153|52|
|155|52|
158|54|


## Loss function

training data sample: (x1, y1), (x2, y2),...(xn, yn)

simple model:
y = f(x) = w0 + w1*x

prediction by model x->f(x)

for every training data sample (xi, yi) wee compare f(xi) to yi

error of 1 data point:

$\frac{1}{2} (y_1 - f(x_1))^2$

mean squared error (MSE):

$\frac{1}{2n} ∑_{i=1}^n(y_i - f(x_i))^2$

## Cost function


training data sample: (x1, y1), (x2, y2),...(xn, yn)

simple model:
y = f(x) = w0 + w1*x

mean squared error (MSE):

$\frac{1}{2n} ∑_{i=1}^n(y_i - f(x_i))^2$

cost function:

$\frac{1}{2n}∑{i=1}{}$

goal: minize cost function

⟶ get derivative of cost function 

-------------------
Bản tiếng việt:

## Học có giám sát là gì?

Học có giám sát (supervised learning) là một thuật toán của ngành học máy nhằm mục đích xây dựng một mô hình từ dữ tập dữ liệu huấn luyện (Training data). Dữ liệu huấn luyện bao gồm các cặp đối tượng đầu vào và đầu ra mong muốn. Đầu ra của mô hình có thể là một giá trị liên tục hoặc có thể là dự đoán một nhãn phân lớp cho một đối tượng đầu vào.

![](https://blog.luyencode.net/wp-content/uploads/2019/01/hoc-co-giam-sat.jpg)


## Định nghĩa một cách học thuật hơn

Supervised learning là nhóm thuật toán dự đoán đầu ra (outcome) của một dữ liệu mới (new input) dựa trên các cặp (input, outcome) đã biết từ trước. Cặp dữ liệu này còn được gọi là (data, label), tức là "dữ liệu được gán nhãn" (hiểu nôm na là dữ liệu đi kèm định danh). 

Quá trình này được đặt dưới sự giám sát của con người nhằm đảm bảo đầu ra luôn đạt được giá trị mong muốn. Kết quả cuối cùng sẽ là một mô hình được ứng dụng để tiếp tục dự đoán các đầu ra tiếp theo trong tương lai

![](https://hocvienagile.com/wp-content/uploads/2021/05/mo-hinh-supervised-learning-768x576.png)

Một cách toán học, Supervised learning là khi chúng ra có một tập hợp biến đầu vào $X$ = {$x_1,x_2,…,x_N$}  và một tập hợp nhãn tương ứng $Y$={$y_
1,y_2,…,y_N$}. Các cặp dữ liệu biết trước $(x_i,y_i) ∈X×Y$ được gọi là tập training data (dữ liệu huấn luyện). Từ tập training data này, chúng ta cần tạo ra một hàm số ánh xạ mỗi phần tử từ tập X sang một phần tử (xấp xỉ) tương ứng của tập Y:

$$y_i≈f(x_i),  ∀i=1,2,…,N$$

Lý do chúng ta dùng dấu $"≈"$ thay vì dấu $"="$ là vì kết quả dự đoán đầu ra trong tương lai không chắc chắn 100% là đúng. Ta chỉ có thể xấp xỉ hàm số f thật tốt để khi có một dữ liệu x mới, chúng ta có thể tính được nhãn tương ứng của nó $y=f(x)$.

## Ví dụ

Ví dụ 1: trong nhận dạng chữ viết tay, ta có hàng nghìn bức ảnh của mỗi chữ số được viết bởi nhiều người khác nhau. Chúng ta đưa các bức ảnh này vào trong một thuật toán và chỉ cho nó biết mỗi bức ảnh tương ứng với chữ số nào. Sau khi thuật toán tạo ra một mô hình, tức một hàm số mà đầu vào là một bức ảnh và đầu ra là một chữ số, khi nhận được một bức ảnh mới mà mô hình chưa nhìn thấy bao giờ, nó sẽ dự đoán bức ảnh đó chứa chữ số nào.

Ví dụ này khá giống với cách học của con người khi còn nhỏ. Ta đưa bảng chữ cái cho một đứa trẻ và chỉ cho chúng đây là chữ A, đây là chữ B. Sau một vài lần được dạy thì trẻ có thể nhận biết được đâu là chữ A, đâu là chữ B trong một cuốn sách mà chúng chưa nhìn thấy bao giờ.

Ví dụ 2: Thuật toán dò các khuôn mặt trong một bức ảnh đã được phát triển từ rất lâu. Thời gian đầu, facebook sử dụng thuật toán này để chỉ ra các khuôn mặt trong một bức ảnh và yêu cầu người dùng tag friends - tức gán nhãn cho mỗi khuôn mặt. Số lượng cặp dữ liệu (khuôn mặt, tên người) càng lớn, độ chính xác ở những lần tự động tag tiếp theo sẽ càng lớn.

Ví dụ 3: Bản thân thuật toán dò tìm các khuôn mặt trong 1 bức ảnh cũng là một thuật toán Supervised learning với training data (dữ liệu học) là hàng ngàn cặp (ảnh, mặt người) và (ảnh, không phải mặt người) được đưa vào. Chú ý là dữ liệu này chỉ phân biệt mặt người và không phải mặt người mà không phân biệt khuôn mặt của những người khác nhau.

## Ưu nhược điểm của Supervised Learning

__Ưu điểm__

- Supervised Learning hay học có giám sát cho phép thu thập dữ liệu đầu vào và tạo ra dữ liệu đầu ra từ những đào tạo trước đó.
- Giúp tối ưu hóa các tiêu chí với sự trợ giúp của kinh nghiệm đã cài đặt.
- Học có giám sát giúp giải quyết nhiều loại vấn đề tính toán khác nhau trong thế giới thực.

__Nhược điểm__

- Dữ liệu quá lớn ⟶ khó phân loại để đào tạo mô hình.
- Mô hình cần quyết định trước các cấu trúc và thuật toán.
- Mô hình cần nhiều ví dụ hay sử dụng nhiều loại nếu sử dụng thuật toán phân loại.
- Đào tạo cho việc học có giám sát cần nhiều thời gian tính toán.  

## Các biến thể của Supervised Learning

- [Hồi quy tuyến tính](/Linear_regression/README.md)
- [Hồi quy logistic]()
- [Phân loại]()
- [Naive Bayes Classifier ]()
- [K-nearest neighbors]()
- [Cây quyết định]()
- [Support Vector Machine]()


Nguồn: [blog.luyencode](https://blog.luyencode.net/hoc-co-giam-sat-la-gi/#:~:text=H%E1%BB%8Dc%20c%C3%B3%20gi%C3%A1m%20s%C3%A1t%20l%C3%A0%20g%C3%AC%3F%20H%E1%BB%8Dc%20c%C3%B3,t%C6%B0%E1%BB%A3ng%20%C4%91%E1%BA%A7u%20v%C3%A0o%20v%C3%A0%20%C4%91%E1%BA%A7u%20ra%20mong%20mu%E1%BB%91n.)

[machinelearningcoban](https://machinelearningcoban.com/2016/12/27/categories/)
[hocvienagile](https://hocvienagile.com/supervised-learning-la-gi/)
