package update;

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
public class MongoUpdata {
    public void update(String field,Object o,Object y){
        try{
            MongoDatabase mongoDatabase = MongoConnection.connection();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase
                    .getCollection("person");
            System.out.println("集合 test 选择成功");
            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq(field, o), new Document
                    ("$set",new Document(field,y)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next().toJson());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
