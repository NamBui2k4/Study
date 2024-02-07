import matplotlib.pyplot as plt

from skimage import data
from skimage import exposure
from skimage.exposure import match_histograms
import cv2

# Đọc ảnh nguồn 
reference = cv2.imread("Screenshot 2023-11-10 071440.png") ; 
reference = cv2.cvtColor(reference, cv2.COLOR_BGR2RGB)
# Đọc ảnh tham chiếu
image = cv2.imread("cafe.png") 
mage = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

matched = match_histograms(image, reference, channel_axis = 2)
# giải thích:
    # match_histograms: Hàm thực hiện khớp nối mức xám giữa 2 ảnh
    # channel_axis=-1: Chỉ định cột 2 để khớp nối màu 2 ảnh. 
    # một pixel sẽ có 3 thuộc tính : (dài, rộng, màu) ứng với 3 cột (0, 1, 2).
    # Ở đây ta chỉ quan tâm đến xử lý màu nên ta chọn cột 2 để đưa vào hàm 
    
fig, (pic1, pic2, pic3) = plt.subplots(nrows=1, ncols=3)
# giải thích:
    # plt.subplots: Tạo 3 lưới đồ thị cho 3 ảnh trên là pic1, pic2, pic3
    # fig là một đối tượng Figure trong matplotlib giúp hiển thị 3 đồ thị trên
    # mỗi lưới đồ thị sẽ có 3 cột (ncols=3) và 1 hàng (nrows=1).
    # lưới đồ thị dùng dùng để vẽ hình ảnh
for aa in (pic1, pic2, pic3): # xóa trục tọa độ
    aa.set_axis_off()
    
pic1.imshow(image)
pic1.set_title('Source')
pic2.imshow(reference)
pic2.set_title('Reference')
pic3.imshow(matched)
pic3.set_title('Matched')
plt.show()