package DAO;

public class ChuanHoaTen {

    public static String chuanHoa(String name){
        name = name.replaceAll("\\s+", " ");
        name = name.trim();
        String chucaidau = name.substring(0, 1);
        chucaidau = chucaidau.toUpperCase();
        String phansau = name.substring(1, name.length());
        name = chucaidau + phansau;
        return name;
    }
}
