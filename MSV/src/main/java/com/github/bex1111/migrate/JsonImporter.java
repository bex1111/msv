package com.github.bex1111.migrate;

import com.github.bex1111.exception.MSVExceptionFactory;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;

public class JsonImporter extends BaseImporter {

    public JsonImporter(DB db) {
        super(db);
    }

    public void importJson(String fileName, String jsonText, String collctionName) {
        try {
            DBCollection collection = db.getCollection(collctionName);
            Object dbObject = JSON.parse(jsonText);
            if (dbObject instanceof BasicDBObject) {
                collection.insert((DBObject) dbObject);
            } else if (dbObject instanceof BasicDBList) {
                ((BasicDBList) dbObject).forEach(item -> collection.insert((DBObject) item));
            }
        } catch (JSONParseException e) {
            throw MSVExceptionFactory.jsonParseFail(fileName, e);
        }
    }

}