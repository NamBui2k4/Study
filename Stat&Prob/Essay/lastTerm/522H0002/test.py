# đọc file dữ liệu
file = open("test.csv", mode = "r", encoding="utf-8-sig")
number = []
salary = []
with file:
    # đọc từng dòng trong file dữ liệu
    for line in file:
        listData = line.split(",")
        # lấy ra danh sách số lượng 65 sinh viên 
        if listData[0] == 'STT':
            for i in range(1,len(listData)): 
                number.append(int(listData[i].strip()))
        # lấy  ra danh sách mức lương tương ứng
        if listData[0] == 'Tiền lương':
            for i in range(1,len(listData)): 
                salary.append(int(listData[i].strip()))
# tạo ra một từ điểm để lưu trữ các sinh viên cùng với mức lương của họ
my_dict = {}
for i in range(len(number)):
    my_dict[number[i]] = salary[i]

from random import sample
# chọn ngẫu nhiên 15 sinh viên từ 65 sinh viên
combinations_employee = sample(number,15)
# lấy danh sách mức lương của các sinh viên đó
# combinations_salary = [my_dict[i] for i in combinations_employee]
# # in ra kết quả
# print(combinations_employee)
# print((combinations_salary))


b = [49, 105, 61, 34, 59, 143, 87, 40, 138, 128, 102, 91, 125, 25, 92, 68, 118, 66, 124, 144, 131, 130, 146, 59, 44, 138, 99, 123, 77, 88]
for i in b:
    if 
# giá trị trung bình
# a = 0
# for i in combinations_salary:
#     a += i
# average_salary = a / len(combinations_salary)
# print(average_salary)

# độ lệch chuẩn
# from statistics import stdev
# std = stdev(combinations_salary)
# print(std)

    
# S2

#[2, 14, 63, 46, 18, 38, 12, 4, 30, 39, 3, 40, 15, 47, 52]
#[61, 74, 128, 106, 59, 45, 83, 69, 125, 25, 52, 94, 143, 119, 92]

#giá trị trung bình
# b = [61, 74, 128, 106, 59, 45, 83, 69, 125, 25, 52, 94, 143, 119, 92]

# a = 0
# for i in b:
#     a += i
# print(a/15)
# average_salary = a / len(b)
# print(average_salary)

# from statistics import stdev
# std = stdev(b)
# print(std)
