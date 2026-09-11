// Cài đặt sai:
public void union(int p, int q){
    for(int i = 0; i < leader.length; i++){
        if(leader[i] == leader[p]){
            leader[i] = leader[q];
        }
    }
}
/*
    Cài đặt chạy sai khi leader của một group không phải phần tử được duyệt cuối cùng trong group, ví dụ:
    n = 4; leader = [0, 1, 2, 3];
    unions:
    (0, 1) => leader = [1, 1, 2, 3];
    (2, 1) => leader = [1, 1, 1, 3];
    (1, 3) => leader = [3, 3, 1, 3]; -> Sai, vì leader của 2 là 1, nhưng 1 đã được thay đổi thành 3, nên 2 sẽ không nhận được leader đúng
*/
