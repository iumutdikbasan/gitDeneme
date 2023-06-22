import java.sql.*;

public class DbFunction {
    public Connection connectToDb(String dbname, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
            if (conn != null) {
                System.out.println("Bağlanma başarıyla sağlandı");
            } else {
                System.out.println("Bağlantı sağlanamadı.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    // Creating a Table and INSERTING data
   /* public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name +"(empid SERIAL,name varchar(200), address varchar(200),primary key(empid));";
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tablo oluşturuldu");

            boolean kaan = true;
            Boolean kaanB = false;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    */
    class denemeTableCreate{
        public static final String denemeSqlCreate = "CREATE TABLE deneme" + "("
                + " ID serial,"
                + " NAME varchar(100) NOT NULL,"
                + " SALARY numeric(15, 2) NOT NULL,"
                + " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                + " PRIMARY KEY (ID)"
                + ")";
    }
    public void createTable(Connection conn, String table_name){

        try (
             PreparedStatement preparedStatement = conn.prepareStatement(denemeTableCreate.denemeSqlCreate)) {

            preparedStatement.execute();

        } catch (SQLException e){
            System.out.println(e);
        }
    }
    //Satır yaratma işlemi
    public void insertRow(Connection conn, String table_name, String name, String address){
        Statement statement;
        try{
            String query= String.format("insert into %s(name,address) values('%s','%s');", table_name,name,address);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Satır yaratıldı.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Satır okuma işlemi
    /*
    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query= String.format("select * from %s",table_name);
            statement= conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("Address")+" ");


            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
     */
    public static String readSorgu =  ("select * from employee");
    public void readData(Connection conn,String table_name) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement(readSorgu);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {               // Position the cursor                  4
            int empid = Integer.parseInt(String.valueOf(resultSet.getInt("empid")));      // Retrieve the first column value
            String name = String.valueOf(resultSet.getString("name"));      // Retrieve the first column value
            String address = String.valueOf(resultSet.getString("address"));      // Retrieve the first column value

            Employee employee = new Employee(empid,name,address);


        }

    }
    //Satır güncelleme işlemi
    public void update_name(Connection conn,String table_name,String old_name, String new_name){
        Statement statement;
        try{
            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Satır Güncellendi");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Arama işlemi
    public void search_by_id(Connection conn,String table_name, int id){
        Statement statement;
        ResultSet rs= null;
        try {
            String query= String.format("select * from %s where empid = %s", table_name,id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            }
        }catch (Exception e){

        }
    }
    // Silme işlemi
    public void delete_by_name(Connection conn,String table_name, String name){
        Statement statement;
        try {
            String query= String.format("delete from %s where name = '%s'", table_name,name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Silinme işlemi tamamlandı.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
