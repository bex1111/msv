db.getCollection('asd').save({"Sandor":"test"});
db.getCollection('test').save({"Sandor":"test"});
db.getCollection('jani').save({"Sandor":"test"});
db.getCollection('asd').save([{
                               "asd":"asd"
                             },{
                               "test":"test"
                             }
                               ]);