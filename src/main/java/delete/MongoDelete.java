package delete;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import connection.MongoConnection;
import org.bson.Document;

/**
 * @author jijngbao
 * @date 19-1-28
 */
public class MongoDelete {
    public void delete(String field,Object value){
        try{
            MongoDatabase mongoDatabase = MongoConnection.connection();
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");
            collection.deleteOne(Filters.eq(field, value));
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void deleteMany(String field,Object value ){
        try{
            MongoDatabase mongoDatabase = MongoConnection.connection();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase
                    .getCollection("person");
            System.out.println("集合 test 选择成功");
            //删除所有符合条件的文档
            collection.deleteMany (Filters.eq(field, value));

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
