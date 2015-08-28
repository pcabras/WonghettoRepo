package be.pcab.wonghetto.wonghettocore.cloud;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import be.pcab.wonghetto.wonghettocore.WonghettoContext;
import be.pcab.wonghetto.wonghettocore.persistence.domain.Category;
import be.pcab.wonghetto.wonghettocore.service.CategoryTX;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.Processor;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.Request;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.RequestType;

public class RequestProcessor implements Processor<Request> {

	private static Logger logger = Logger.getLogger(RequestProcessor.class);

	private WonghettoContext wonghettoContext;

	public RequestProcessor() {

		wonghettoContext = WonghettoContext.getInstance();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Request process(Request request) throws Exception {

		logger.info("processing request...");

		RequestType requestType = (RequestType) request.getRequestType();

		switch (requestType) {

		case INFO: {

			JSONObject outComingJson = new JSONObject();
			outComingJson.put("Type", RequestType.PROCESSED);
			outComingJson.put("Content", "Request Processed");

			request.setJson(outComingJson);
			break;
		}

		case CLOUD_MIRROR: {

			CategoryTX categoryTX = (CategoryTX) wonghettoContext
					.getBean("categoryTXManager");

			List<Category> categories = categoryTX.getAll();

			StringBuilder categoryList = new StringBuilder();

			Iterator<Category> iterator = categories.iterator();

			while (iterator.hasNext()) {

				Category category = iterator.next();

				categoryList.append(category.getName());

				if (iterator.hasNext()) {

					categoryList.append(", ");
				}

			}

			JSONObject outComingJson = JsonRequestBuilder.builder()
					.type(RequestType.PROCESSED)
					.content(categoryList.toString()).build();
			
			request.setJson(outComingJson);

		}

		default:
			break;
		}

		logger.info("request processed");

		return request;
	}

}
