import hei.devweb.rendu2.dao.impl.DataSourceProvider;
import org.junit.Before;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public abstract class ArticleAbstractDAOTestCase {

    @Before
    public void initDataBase() throws Exception {
        try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP TABLE articles");
            statement.executeUpdate("DROP TABLE utilisateurs");

            statement.executeUpdate("CREATE TABLE `articles` (\n" +
                    "  `article_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `brand` VARCHAR(100) NULL,\n" +
                    "  `gender` VARCHAR(100) NULL,\n" +
                    "  `price` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`article_id`));");

            statement.executeUpdate("CREATE TABLE `utilisateurs` (\n" +
                    "  `utilisateur_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`utilisateur_id`));\n");

            this.insertDataSet(statement) ;
        }
    }
    public abstract void insertDataSet(Statement statement) throws  Exception;
}
