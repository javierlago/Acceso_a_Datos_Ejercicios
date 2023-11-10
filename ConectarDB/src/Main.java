import java.sql.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {

            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "abc123.");
            // Creacion de un rollBack
            conexion.setAutoCommit(false);


            // Obtenemos los metadatos de la tabla
            DatabaseMetaData databaseMetaData = conexion.getMetaData();
            String tipos[] = {"TABLE", "VIEW"};
            ResultSet tablas = databaseMetaData.getTables(null, null, null, tipos);
            while (tablas.next()) {
                if (tablas.getString("TABLE_TYPE").equals("TABLE")) {
                    System.out.println(
                              tablas.getString("TABLE_CAT") + "--"
                            + tablas.getString("TABLE_SCHEM") + "--"
                            + tablas.getString("TABLE_NAME") + "--"
                            + tablas.getString("TABLE_TYPE"));

                }
            }
            System.out.println("Ok");
            Statement sentecia = conexion.createStatement();
            String sql = "Select * from empleado ";
            String crearTabla = "CREATE TABLE if not exists salario (\n"
                    + "    codigo INT PRIMARY KEY,\n"
                    + "    categoria VARCHAR(20)\n" + ");";

            sentecia.executeUpdate(crearTabla);
            String datos = "INSERT INTO salario (codigo, categoria) VALUES (2, 'junior kaka'),(3, 'senior'),(4, 'jefe proyecto')";
            // Cada vez
            int n= sentecia.executeUpdate(datos);
            if(n<0) System.out.println("Se ha actulizado la base de datos");
            conexion.commit();

            ResultSet resultado = sentecia.executeQuery(sql);
            while (resultado.next()) {
                String nss = resultado.getString("NSS");
                String nombre = resultado.getString("Nombre");
                String aple1 = resultado.getString("Apel1");
                String aple2 = resultado.getString("Apel2");
                String sexo = resultado.getString("Sexo");
                String direccion = resultado.getString("Dirección");
                String fechanac = resultado.getString("Fechanac");
                String salario = resultado.getString("Salario");
                String numdept = resultado.getString("Numdept");
                String nsSsup = resultado.getString("NSSsup");
                System.out.println(nss + "--" + nombre + "--" + aple1 + "--" + aple2 + "--" + sexo + "--" + direccion + "--" + fechanac + "--" + salario + "--" + numdept + "--" + nsSsup);

            }
            sentecia.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }
}