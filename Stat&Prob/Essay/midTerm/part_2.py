import numpy as np 
import cv2 
import matplotlib.pyplot as plt


# Thiết lập kích thước của đồ thị và hình ảnh khi vẽ bằng plt : 10x8
plt.rcParams['figure.figsize'] = [10,8]

# đọc hình ảnh đầu vào dưới dạng trắng đen
img = cv2.imread("Screenshot 2023-11-10 071440.png", 0)

# B1: tính histogram của ảnh
L = 256
n_k, r_k = np.histogram(img.flatten(), L , [0, L - 1])

# vẽ demo ảnh ban đầu
ax = plt.subplot(121)
plt.imshow(img, cmap='gray')
plt.subplot(122)
plt.plot(r_k[:-1], n_k)
plt.xlabel('r')
plt.ylabel('pixels')
plt.title('h_r_kogram của ảnh ban đầu')
plt.show()

# B2: chuẩn hóa
M, N = img.shape[:2] # lấy chiều dài và chiều rộng
P_r_k = n_k/(M*N)

# B3: Tính cdf cho ảnh
cdf = np.cumsum(P_r_k)

L = 256
# B4: Tính giá trị mức xám cho ảnh
s_k = ( (L - 1) * cdf).astype("uint8")
# print('cdf :', cdf)

print()
print('S_k =:',s_k)

# Hình ảnh đã xử lý
equalized_img = cv2.LUT(img, s_k) 
new_hist = cv2.calcHist([equalized_img], [0], None, [L], [0, 256])
ax = plt.subplot(121)
plt.imshow(equalized_img, cmap='gray')
plt.subplot(122)
plt.plot(new_hist)
plt.xlabel('r')
plt.ylabel('pixels')
plt.title('h_r_kogram của ảnh đã chỉnh sửa')
plt.show()


