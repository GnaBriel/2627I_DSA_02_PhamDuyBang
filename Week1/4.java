/*
    - Thấy parent[9] = 8 -> khi union 9 và 8 thì 8 phải là nút gốc -> cây do 8 và 9 có kích thước ít nhất là 2
    - parent[8] có thể = 8 vì nó cây gốc 8 chứa 8 và 9 hoàn toàn có thể đứng độc lập
    - parent[8] có thể = 0 vì cây gốc 0 có size 4 > 2 nên có thể làm bố cây gốc 8
    - parent[8] có thể = 4 vì cây gốc 0 có size 4 > 2 nên có thể làm bố cây gốc 8
*/