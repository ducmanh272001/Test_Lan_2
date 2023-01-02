package DAO;

import Entities.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDSinhVien {


    public static void main(String[] args) {
        //Danh sách sinh viên
        int chon;
        List<SinhVien> list = new ArrayList<SinhVien>();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("========= Xin vui lòng chọn menu ===========");
            System.out.println("1 : Thêm sinh viên ");
            System.out.println("2 : Sửa sinh viên ");
            System.out.println("3 : Xóa sinh viên");
            System.out.println("4 : Hiển thị danh sách sinh viên");
            System.out.println("5 : Nhập id sinh viên mà bạn muốn tìm kiếm !");
            chon = sc.nextInt();
            if (chon == 0 || chon > 5) {
                System.out.println("Xin mời bạn chọn lại menu");
            } else {
                switch (chon) {
                    case 1:
                        try {
                            System.out.println("Nhập id sinh viên ");
                            sc.nextLine();
                            int id = Integer.parseInt(sc.nextLine());
                            if (id < 0) {
                                System.out.println("Id phải là 1 số dương lớn hơn 0");
                                System.out.println("Nhập id sinh viên");
                                id = Integer.parseInt(sc.nextLine());
                            }
                            for (int i = 0; i < list.size(); i++) {
                                if (id == list.get(i).getId()) {
                                    System.out.println("Id đang có trong danh sách xin mời nhập lại");
                                    System.out.println("Nhập id sinh viên");
                                    id = Integer.parseInt(sc.nextLine());
                                }
                            }
                            System.out.println("Nhập tên sinh viên");
                            String name = sc.nextLine();
                            name = ChuanHoaTen.chuanHoa(name);
                            if (name.length() <= 5) {
                                System.out.println("Tên tối thiểu 5 ký tự");
                                System.out.println("Nhập tên sinh viên");
                                name = sc.nextLine();
                                name = ChuanHoaTen.chuanHoa(name);
                            }
                            System.out.println("Nhập tuổi sinh viên");
                            int age = Integer.parseInt(sc.nextLine());
                            if (age < 0) {
                                System.out.println("Tuổi không được bé hơn 0");
                                System.out.println("Nhập tuổi sinh viên");
                                age = Integer.parseInt(sc.nextLine());
                            }
                            SinhVien sinhvien = new SinhVien(id, name, age);
                            list.add(sinhvien);
                            break;
                        } catch (Exception e) {
                            System.out.println("Id sinh viên phải là số");
                            break;
                        }
                    case 2:
                        System.out.println("Nhập id sinh viên bạn muốn sửa");
                        sc.nextLine();
                        int idsua = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId() == idsua) {
                                System.out.println("Nhập tên sinh viên");
                                String namesua = sc.nextLine();
                                namesua = ChuanHoaTen.chuanHoa(namesua);
                                if (namesua.length() <= 5) {
                                    System.out.println("Tên tối thiểu 5 ký tự");
                                    System.out.println("Nhập tên sinh viên");
                                    namesua = sc.nextLine();
                                }
                                list.get(i).setName(namesua);
                                System.out.println("Nhập tuổi sinh viên");
                                int agesua = Integer.parseInt(sc.nextLine());
                                if (agesua < 0) {
                                    System.out.println("Tuổi không được bé hơn 0");
                                    System.out.println("Nhập tuổi sinh viên");
                                    agesua = Integer.parseInt(sc.nextLine());
                                }
                                list.get(i).setAge(agesua);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Nhập id sinh viên bạn cần xóa");
                        sc.nextLine();
                        int idxoa = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId() == idxoa) {
                                list.remove(list.get(i));
                                System.out.println("Xóa thành công");
                            }
                            System.out.println("Không có id trong cơ sở dữ liệu");
                        }
                        break;
                    case 4:
                        System.out.println("Hiển thị danh sách sinh viên");
                        for (SinhVien svla : list) {
                            System.out.println(svla.toString());
                        }
                        break;
                    case 5:
                        System.out.println("Nhập id sinh viên");
                        sc.nextLine();
                        int id = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < list.size(); i++) {
                            if(list.get(i).getId() == id){
                                System.out.println(list.get(i).toString());
                            }
                            System.out.println("Không có id trong cơ sở dữ liệu");
                        }
                        break;
                }
            }
        } while (true);
    }
}
