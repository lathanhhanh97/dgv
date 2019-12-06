# Xây dựng api cho rạp chiếu phim bằng Java Srping Boot
## Mô tả dự án
- Xây dựng hệ thống back-end cho ứng dụng đặt vé xem phim
- Sử dụng: Java Spring Boot & MySQL 5.7
- Thiết kế Database
    <img src="https://i.imgur.com/S1YxbiY.png">

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
                        
   - Trong đó `movie_id` là id của bộ phim, `date` là ngày có suất chiếu của bộ phim `movie_id`. 
  
  <img src="https://i.imgur.com/hAx2KkZ.jpg">
- Thực hiện đặt vé
- Đăng kí, đăng nhập 
## Thực hiện cái đặt
- Thực hiện lệnh 
    > `git clone https://github.com/lathanhhanh97/dgv.git`
- Có thể sử dụng các IDE hỗ trợ Java Spring Boot để chạy ứng dụng
## Các lỗi gặp phải nếu có
### Lỗi bị chiếm port và không chạy được
- Cách sửa: thay đổi port trong file application.properties
    >`server.port=80`
## Các việc trong tuần tới
- Hoàn thiện chức năng đăng kí, đăng nhập cùng với jwt
- Tiến hành ghép api với front-end