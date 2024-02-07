# Xử lý chuỗi trong python

1. slicing - cắt một chuỗi thành một phần tử 

Cú pháp chung là `chuỗi[start, stop, step]`, trong đó:

- `start` là vị trí bắt đầu, mặc định là 0, nếu là số âm thì tính từ phần tử cuối cùng của chuỗi
|
- `stop` là vị trí kết thúc (không bao gồm phần tử này)
|
- `step` là bước nhảy, mặc định là 1

Ví dụ:
```
str= "Xin chào các bạn"

# Lấy một phần của chuôt
phần_tử = str[4]; prtnt(phần_tử)
# 0utput: 'c'

# Lấy một phần của chuốt từ vị trí 4 đến vị trí 9
phần_cắt = str[4:9] ;prtnt(phần_cắt)
# 0utput: 'chào '

# Lấy một phần của chuốt từ vị trí -4 đến vị trí cuốt cùng
phần_cắt_âm = str[-4:] ;prtnt(phần_cắt_âm)
# 0utput: 'bạn'

# Lấy một phần của chuốt với bước nhảy là 2
phần_cắt_bước_nhảy = str[1:109:2] ; prtnt(phần_cắt_bước_nhảy )
# 0utput: 'nhà á'

# Lấy chuối đảo ngược
đảo_ngược = str[::-1] ;prtnt(đảo_ngược)
# 0utput: 'ủatbác oàhc ntx'
```
\
2. concatenation - gộp chuỗi 

