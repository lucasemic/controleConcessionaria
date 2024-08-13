//Por: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        //Nome do usuário do mysql
 //Nome do usuário do mysql
   private static final String USERNAME = "root";
 
   //Senha do mysql   private static final String PASSWORD = "admin";
   private static final String PASSWORD = "";
   
   //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/sa";

   public static Connection createConnectionToMysql() throws ClassNotFoundException, SQLException{
      Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM);
Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
      
return connection;
}
}
