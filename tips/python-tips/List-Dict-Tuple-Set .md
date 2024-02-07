# Khác biệt giữa List, Dict, Tuple, Set trong Python

Chào các bạn, Trong ngôn ngữ Python kiểu dữ liệu List là một trong các kiểu dữ liệu tập hợp bao gồm: List, Tuple, Set, Dictionary tuy nhiên việc hiểu ý nghĩa và cách sử dụng của từng kiểu đôi khi lại gây chút nhầm lẫn 😥, trong bài viết này mình sẽ gới thiệu 4 kiểu dữ liệu List và sự khác biệt giữa chúng 😜

##List

Kiểu dữ liệu List là kiểu dữ liệu được sử dụng nhiều nhất trong Python bạn có thể thấy chúng bất kì đâu trong một dự án Python, List chứa một tập các giá trị, được phân tách nhau bằng dấu phẩy, List có thể chứa bất kỳ kiểu dữ liệu nào. Một List được tạo bởi cặp dấu [] như sau:

    lst = [2, 4, 3, "ABC", 3, [6, 4, 2]] 

    print type(lst) 
    # output: <type 'list'>

__Các thao tác cơ bản với List:__

- Truy cập đến một phần tử trong mảng:

        print lst[2] 
        # output: 3

- Gán giá trị mới cho một phần tử trong mảng

        lst[2] = 100 
        # output: [2, 4, 100, 'ABC', 3, [6, 4, 2]]

- Lấy độ dài của mảng

        print(len(lst)) # output: 6

- Thêm phần tử mới vào mảng

        lst.append(True) 
        # output: [2, 4, 100, 'ABC', 3, [6, 4, 2], True]

- Gộp 2 mảng

        any_lst = ['one', 'two', 'three']
        lst.extend(any_lst) 

        # out put: 
        [2, 4, 100, 'ABC', 3, [6, 4, 2], True,
        'one', 'two', 'three']

- Sắp xếp tăng dần hay giảm dần

        lst = [4,3,5,2,7,5,2]

        lst.sort() 
        # output: [2, 2, 3, 4, 5, 5, 7]

        lst.sort(reverse = True) 
        # output: [7, 5, 5, 4, 3, 2, 2]

## Tuple

Tương tự như kiểu dữ liệu List tuy nhiên lại có một sự khác biệt với kiểu List đó là các phần tử trong Tuple không thể bị thay đổi sau khi gán chính vì vậy tốc độ của Tuple luôn luôn nhanh hơn so với List, Tuple chứa một tập các giá trị, được phân tách nhau bằng dấu phẩy, có thể chứa bất kỳ kiểu dữ liệu nào. Một tuple được tạo bởi cặp dấu () như sau:

    tup = (2, "ABC", 7, 3, [4,3,7], True, 3) 
  
    print type(tup) 
    # output: <type 'tuple'>

- Không thể thay đổi một phần tử của Tuple

        tup[1] = 100 

        # TypeError: 'tuple' object does not 
        support item assignment

- Không thể xoá phần tử trong Tuple

        del tup[1] 
        
        # TypeError: 'tuple' object doesn't 
        support item deletion

- Đếm số lần xuất hiện của một phần tử trong Tuple

        print(tup.count(3)) 
        # output: 2

- Lấy ra vị trí index đầu tiên tìm được

        print(tup.index(3)) 
        # output: 3

# Set

Tương tự như 2 kiểu dữ liệu chúng ta đã tìm hiểu ở trên tuy nhiên Set lại chứa các phần tử là DUY NHẤT có nghĩa là các phần tử không bị lặp lại trong một tập hợp Set 💯, Set chứa một tập các giá trị, được phân tách nhau bằng dấu phẩy, có thể sử dụng được các phép toán trên tập hợp, các phần tử trong Set không có thứ tự. Một tập hợp Set được tạo bởi cặp dấu {} như sau:

        A = { 2, 7, 3, 2, 5 } 
        # hoặc A = set([2, 3, 5, 7])

        print(type(A))
        # output:  <type 'set'>

__Các thao tác cơ bản với Set__

- Thêm một phần tử vào Set

        A.add(100)
        #output: {2, 3, 100, 5, 7}

- Xoá một phần tử bằng pop

        A.pop()
        # output: {3, 5, 7}

- Lấy giao của 2 set

        A = { 2, 7, 3, 2, 5 }
        B = { 4, 5, 7}

        print( A & B )
        # output: {5, 7}

- lấy hợp của 2 set

        A = { 2, 7, 3, 2, 5 }
        B = { 4, 5, 7}

        print( A | B )
        # output: {2, 3, 4, 5, 7}

- Lấy hiệu của 2 set

_Chú ý: sử dụng phép toán "-" sẽ loại bỏ những phần tử trong set bên trái nếu chúng có mặt ở set phải_

        A = { 2, 7, 3, 2, 5 }
        B = { 4, 5, 7 }

        print( A - B ) 
        # loại bỏ phần tử của A nếu chúng có mặt ở B

        # output: {2, 3}

- Lấy phần bù của hợp 2 set (những phần tử có ở cả 2 set nhưng không nằm ở phần tử chung của 2 set này)

        A = { 2, 7, 3, 2, 5 }
        B = { 4, 5, 7 }

        # {2,3} có ở A nhưng không có ở B
        # 4 có ở B nhưng không có ở A

        print( A ^ B ) 
        # output: {2, 3, 4}

# Dict

Khác với 3 kiểu dữ liệu ở trên Dict lưu trữ các phần tử theo dạng {key: value}, các key phải có giá trị khác nhau và Python chỉ chấp nhận các key có các kiểu dữ liệu như (string, number, tuple): Một Dict được tạo bởi cặp dấu {} và mỗi phàn tử là một cặp key:value 😮 như sau:

    dict_a = {
        1: "MySQL", 
        2: "SQLServer", 
        3: "SQLite"   
    }

    dict_b = {
        "a": "MySQL", 
        "b": "SQLServer", 
        (2, 3, 7 ): "SQLite"
    }


__Các thao tác cơ bản với Dict__

- Lấy các keys của Dict

        print(dict_a.keys()) 
        # output: [1, 2, 3]

- Lấy các values của Dict:

        print dict_a.values() 
        # output: ['MySQL', 'SQLServer', 'SQLite']


- Lấy các items của Dict

_Một item bao gồm cả key lẫn value của nó_


        print(dict_a.items()) 
        # output: [(1, 'MySQL'), (2, 'SQLServer'), (3, 'SQLite')]

Thêm một phần tử vào Dict:

    dict_a[100] = "MongoDB"
    print dict_a #=> {1: 'MySQL', 2: 'SQLServer', 3: 'SQLite', 100: 'MongoDB'}












Nguồn: [_viblo_](https://viblo.asia/p/khac-biet-giua-list-dict-tuple-set-trong-python-E375zgzdKGW)