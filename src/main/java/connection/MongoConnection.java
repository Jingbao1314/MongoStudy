package connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author jijngbao
 * @date 19-1-28
 */
public class MongoConnection {
    public static MongoDatabase connection(){
        MongoDatabase mongoDatabase=null;
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase("test");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return mongoDatabase;
    }

}
