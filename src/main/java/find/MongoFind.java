package find;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.MongoDatabase;
import connection.MongoConnection;

/**
 * @author jijngbao
 * @date 19-1-28
 */
public class MongoFind {
    public void find(){
        try{
            MongoDatabase mongoDatabase =MongoConnection.connection();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase
                    .getCollection("person");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
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
