package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //adresEklePrepared(80, "İstanbul", "Bakırköy", "Yeşilköy", "Çınar sokak");
        //adresSil(5);
        //adresGuncelle(6,"Muğla","Fethiye");
        adresIleGoreListele("ank");

    }

    public static void adresEkle(int musteriid, String il, String ilce, String mahalle, String adres) throws SQLException {
        //JDBC kullanımında ilk yapılacak işlem 2 sistem arasında iletişimi sağlayacak driveri devreye almaktır.
        //Java 1.6 dan önce kullanılması gerekn yapı:
        //Driver.class.forName("org.postgresql.Driver");  buna artık ihtiyacım yok

        //jdbc:postgresql://host:port/database
        //host : Veritabanını tutan yapı. Eğer uzak sunucudaysa ip adresi, localde ise localhost(127.0.0.1) yazılır.


        //Driverla sunucuya bağlanabilmek için gerekli paramtreler ;
        //1. Veritabanı server ının ip adresi
        //2. port numarası
        //3. işlem yapılacak db adı

        //4. Yetkilendirme için username
        //5. Yetkilendirme için password


        String adresEkleSql = "INSERT INTO public.tbladres(" +
                "musteriid, il, ilce, mahalle, adres)" +
                "VALUES (" + musteriid + ",'" + il + "','" + ilce + "','" + mahalle + "','" + adres + "');";


        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisV1";
        String username = "postgres";
        String password = "1234";

        //DriverManager aracılığı ile bir Connection nesnesi oluşturulur.
        //Connection referansı oluşturabilmek için url, username, password bilgilerini  getConnection metoda verdik
        Connection connection = DriverManager.getConnection(connectionAdres, username, password);

        //Bu yazdığımız sql Driver tarafından anlaşılamaz.
        //Driverin anlayabileceği yapıya getirmek için prepareStatment kullanılır.
        PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

        //connection.prepareStatement(adresEkleSql).executeUpdate();
        //connection.close();
    }

    public static void adresEklePrepared(int musteriid, String il, String ilce, String mahalle, String adres) {
        //bağlantı ile ilgili kodlar
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisV1";
        String username = "postgres";
        String password = "1234";

        //sorgumuz
        String adresEkleSql = "INSERT INTO public.tbladres(musteriid, il, ilce, mahalle, adres) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(connectionAdres, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);
        ) {
            //? yerlere değer atama
            preparedStatement.setInt(1, musteriid);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
            preparedStatement.setString(4, mahalle);
            preparedStatement.setString(5, adres);

            //sorgu çalıştrma
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) System.out.println("ekleme gerçeekleşti");
            else System.out.println("ekleme hatalı");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void adresSil(int id){
        //bağlantı ile ilgili kodlar
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisV1";
        String username = "postgres";
        String password = "1234";

        //sorgumuz
        String adresSilSql = "DELETE FROM tbladres WHERE id=?";

        try (Connection connection = DriverManager.getConnection(connectionAdres, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresSilSql);
        ) {
            //? yerlere değer atama
            preparedStatement.setInt(1, id);


            //sorgu çalıştrma
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) System.out.println("silme başarıyla gerçekleşti");
            else System.out.println("silme hatalı");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void adresGuncelle(int id, String il, String ilce){
        //bağlantı ile ilgili kodlar
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisV1";
        String username = "postgres";
        String password = "1234";

        //sorgumuz
        String adresGuncelleSql = "UPDATE tbladres SET il=?, ilce=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(connectionAdres, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresGuncelleSql);
        ) {
            //? yerlere değer atama

            preparedStatement.setString(1,il);
            preparedStatement.setString(2,ilce);
            preparedStatement.setInt(3, id);


            //sorgu çalıştrma
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) System.out.println("güncelleme başarıyla gerçekleşti");
            else System.out.println("güncelleme hatalı");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresIleGoreListele(String ilargs){
        //bağlantı ile ilgili kodlar
        String connectionString = "jdbc:postgresql://localhost:5432/Java12SatisV1?user=postgres&password=1234";


        //sorgumuz
        String adresListeleSql = "select * from tbladres where il ilike ? order by musteriid";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(adresListeleSql);
        ) {
            //? yerlere değer atama
            preparedStatement.setString(1,"%"+ilargs+"%");


            //sorgu çalıştrma
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int musteriid= resultSet.getInt("musteriid");
                String il=resultSet.getString("il");
                String ilce=resultSet.getString("ilce");

                System.out.println("Müşteri id : "+musteriid+" il : "+il+" ilçe : "+ilce);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

/*
                              executeQuery()                          executeUpdate()                           execute()
   geriye dönen tip  :       ResultSet(tablo)                     Int(etkilenen satır sayısı)
   nerede kullanılır :       Select sorguları                     Insert, Delete, Update sorguları             tüm sorgular


   execute()
   Eğer SQL insert, update, delete geçiyorsa geriye int döner
   Eğer SQL select geçiyorsa resultSet döner
   Eğer SQL alter, create, drop geriye true, false döner

 */