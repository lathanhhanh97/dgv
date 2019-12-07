# Xây dựng api cho ứng dụng đặt vé xem phim bằng Java Srping Boot
## Mô tả dự án
- Xây dựng hệ thống back-end cho ứng dụng đặt vé xem phim
- Sử dụng: Java Spring Boot & MySQL 5.7
- Ứng deploy trên heroku: 
    - [https://dgv-cinema-api.herokuapp.com/swagger-ui.html](https://dgv-cinema-api.herokuapp.com/swagger-ui.html)
    - [https://dgvapi.herokuapp.com/swagger-ui.html](https://dgvapi.herokuapp.com/swagger-ui.html)
- Thiết kế Database 
    [Link Dbdiagram](https://dbdiagram.io/d/5de9c01cedf08a25543ec5c0)
    <img src="https://i.imgur.com/ScziiJD.png">

## Các chức năng chính của hệ thống
- Lấy dữ liệu thông tin phim đang chiếu
    > `http://localhost/movies/now` 
    <img src="https://i.imgur.com/tHBnbOz.jpg">
- Lấy dữ liệu thông tin phim sắp chiếu
    > `http://localhost/movies/future` 
    <img src="https://i.imgur.com/uwcUX9M.jpg">
- Lấy dữ liệu thông tin các suất chiếu đặc biệt
- Lấy thông tin các suất chiếu
    > `localhost/schedule/movie_id/date`
                        
   - Trong đó `movie_id` là id của bộ phim, `date` là ngày (định dạng YYYY-mm-dd) có suất chiếu của bộ phim `movie_id`. 
  
  <img src="https://i.imgur.com/hAx2KkZ.jpg">
- Thực hiện đặt vé
- Đăng kí, đăng nhập 
- [Bấm vào đây](https://dgv-cinema-api.herokuapp.com/swagger-ui.html) để xem các api và chạy thử.
## Thực hiện cài đặt
- Thực hiện lệnh 
    > `git clone https://github.com/lathanhhanh97/dgv.git`
- Có thể sử dụng các IDE hỗ trợ Java Spring Boot để chạy ứng dụng
## Các lỗi gặp phải nếu có
### Lỗi bị chiếm port và không chạy được
- Cách sửa: thay đổi port trong file `application.properties`
    >`server.port=80`
### Không kết nối được đến CSDL
- Cách fix lỗi: sử dụng `database.sql` import vào phpmyadmin và cấu hình lại kết nối trong file `application.properties`
## Các việc trong tuần tới
- Tiến hành ghép api với front-end