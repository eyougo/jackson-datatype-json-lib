package com.fasterxml.jackson.datatype.jsonlib;

import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mei
 * Date: 10/22/14
 * Time: 15:07
 */
public class NullObjectWriteTest extends TestBase{

    public void testWriteNull() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JsonLibModule());

        // Ok: let's create JSONObject from JSON text
        String JSON = null;
        JSONObject ob = JSONObject.fromObject(JSON);
        assertEquals("null", mapper.writeValueAsString(ob));

        JSON = "null";
        ob = JSONObject.fromObject(JSON);
        assertEquals("null", mapper.writeValueAsString(ob));

        ob = JSONObject.fromObject(null);
        Map<String, Object> test = new HashMap<String, Object>();
        test.put("test", ob);
        assertEquals("{\"test\":null}", mapper.writeValueAsString(test));
    }
}
