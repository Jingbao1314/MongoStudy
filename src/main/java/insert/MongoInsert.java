package insert;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import connection.MongoConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jijngbao
 * @date 19-1-28
 */
public class MongoInsert {
    public void insertMany(List<Document> list){
        try{
            MongoDatabase mongoDatabase = MongoConnection.connection();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase
                    .getCollection("phone");
            System.out.println("集合 person 选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Document document = new Document().
                    append("number", "17602648919").
                    append("up", "500").
                    append("down", "1000");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            document = new Document().
                    append("number", "17602648919").
                    append("up", "300").
                    append("down", "1500");
            documents.add(document);
            document = new Document().
                    append("number", "17603648919").
                    append("up", "400").
                    append("down", "1200");
            documents.add(document);
            document = new Document().
                    append("number", "17602648939").
                    append("up", "200").
                    append("down", "1600");
            documents.add(document);
            document = new Document().
                    append("number", "17635648919").
                    append("up", "300").
                    append("down", "1100");
            documents.add(document);
            document = new Document().
                    append("number", "17602629919").
                    append("up", "350").
                    append("down", "1350");
            documents.add(document);
            document = new Document().
                    append("number", "18256127721").
                    append("up", "450").
                    append("down", "1000");
            documents.add(document);


            collection.insertMany(documents);
            System.out.println("文档插入成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
