/*
    Mảng đã cho không thể là biểu diễn của cấu trúc weighted quick union
    Vì khi gộp 2 cây, cây to hơn sẽ làm bố cây nhỏ hơn, trước khi union(0, 5) có:
    - Cây gốc 0 có size 7 chứa các cây con: {4, 3}, {6, 1, 8}, {2}
    - Cây gốc 5 có size 3 {5, 7, 9}
    Mà 7 > 3 nên parent[0] không thể là 5 => mảng đã cho không thể là biểu diễn của cấu trúc weighted quick union
*/