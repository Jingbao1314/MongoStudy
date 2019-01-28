package org;

import delete.MongoDelete;
import find.MongoFind;
import insert.MongoInsert;
import update.MongoUpdata;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoDelete delete=new MongoDelete();
        delete.delete("age","20");
//        MongoInsert insert=new MongoInsert();
//        insert.insertMany(null);
        MongoFind find=new MongoFind();
        find.find();

//        MongoUpdata updata=new MongoUpdata();
//        updata.update("age","21","18");
    }
}
