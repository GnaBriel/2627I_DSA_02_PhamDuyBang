/*
    a) Cấu trúc dữ liệu thu được 1 thành phần liên thông (1 tập hợp duy nhất các đính từ 1 đến n - 1 nối vào 0)
    b) Mỗi lần union() tốn O(n) -> chạy n - 1 lần thì cần n(n-1)/2 ~ O(n^2)
    c) Khi gọi find(0), phải duyệt từ nút lá 0 đến nút n - 1, chiều dài đường đi là n - 1, nên tốn O(n)
    d) Nút 0 luôn đóng vai trò nút gốc suốt quá trình -> nó có độ sâu 0 => Thao tác find(0) chỉ tốn O(1)
/*