package be.pcab.wonghetto.wonghettocore.cloud;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;

import org.junit.Test;

import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.RequestType;

public class JsonRequestBuilderTest {


	@SuppressWarnings("unchecked" )
	@Test
	public void testBuild() {

		JSONObject actualJsonObject = JsonRequestBuilder.builder()
				.type(RequestType.INFO).content("Fake Request").build();

		JSONObject expectedJsonObject = new JSONObject();
		expectedJsonObject.put("Type", RequestType.INFO);
		expectedJsonObject.put("Content", "Fake Request");

		assertEquals(expectedJsonObject.toJSONString(),
				actualJsonObject.toJSONString());
	}

}
