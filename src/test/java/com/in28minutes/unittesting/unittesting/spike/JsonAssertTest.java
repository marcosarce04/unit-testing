package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"price\":10,\"id\":1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{name:Ball,price:10,id:1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
