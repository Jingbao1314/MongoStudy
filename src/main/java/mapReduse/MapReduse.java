package mapReduse;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.MapReduceAction;
import connection.MongoConnection;
import org.bson.Document;

/**
 * @author jijngbao
 * @date 19-1-28
 */
public class MapReduse {
    public void mapReduce(){
        try {
            MongoDatabase mongoDatabase = MongoConnection.connection();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase
                    .getCollection("phone");
            System.out.println("集合 person 选择成功");
            String map = "function() { "+
//                    "var sum=parseInt(this.up)+parseInt(this.down);"+
                    "var key=\"big\";"+
//                    "var ups=parseInt(this.up);"+
                    "var downs=parseInt(this.down);"+
                    "emit(key,downs);}";

            String reduce = "function(key, values) { " +
                    "var sum=0; " +
                    "values.forEach(function(doc) { " +
//                    "sum += doc; "+
                    "if(doc>sum){"+
                    "sum=doc;"+
                    "}"+
                    "}); " +
                    "return {all: sum};}";
            MapReduceIterable mapReduceIterable = collection.mapReduce(map,
                    reduce);
//                    .action(MapReduceAction.REPLACE)
//                    .databaseName("test")
//                    .collectionName("person")
//                    .sharded(false);
//            for(Object o:mapReduceIterable){
//                System.out.println(o.toString());
//            }
//
            MongoCursor<Document> mongoCursor = mapReduceIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next().toJson());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
