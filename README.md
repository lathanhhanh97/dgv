# Xây dựng api cho rạp chiếu phim bằng Java Srping Boot
## Các chức năng chính của hệ thống
- Lấy dữ liệu thông tin phim đang chiếu
- Lấy dữ liệu thông tin phim sắp chiếu
- Lấy dữ liệu thông tin các suất chiếu đặc biệt
- Lấy thông tin các suất chiếu
- Thực hiện đặt vé
## Thực hiện cái đặt
- Thực hiện lệnh 
    `git clone https://github.com/lathanhhanh97/dgv.git`
- Có thể sử dụng các IDE hỗ trợ Java Spring Boot để chạy ứng dụng
## Các lỗi gặp phải nếu có
### Lỗi bị chiếm port và không chạy được
- Cách sửa: thay đổi port trong file application.properties
`server.port=80`
## Các việc trong tuần tới
- Hoàn thiện chức năng đăng kí, đăng nhập cùng với jwt
- Tiến hành ghép api với front-end