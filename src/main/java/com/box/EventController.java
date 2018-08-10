package com.box;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.box.sdk.BoxEvent;
import com.box.sdk.EventListener;
import com.box.sdk.EventStream;
import com.box.service.BoxJavaSDK;
import com.box.service.BoxSDK;

@Controller
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	private BoxSDK javaSDK;

	@Autowired
	public EventController(BoxSDK javaSDK) {
		this.javaSDK = javaSDK;
	}

	class XDto {
		final int x;

		public XDto(int x) {
			this.x = x;
		}
	}

	Stream<XDto> produceX() {
		return IntStream.range(1, 10).mapToObj(i -> {
			logger.info("produce " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return new XDto(i);
		});
	}

	@RequestMapping("/events")
	public ResponseBodyEmitter handleRequest(@RequestParam("userId") String userId) {
		logger.info("Events controller -- "+userId);
		final SseEmitter emitter = new SseEmitter();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {

			EventStream stream = null;
			try {
				stream = new EventStream(javaSDK.getAppUserConnection(userId));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			stream.addListener(new EventListener() {
				public void onEvent(BoxEvent event) {
					// Handle the event.
					try {
						logger.info("--on event -- " + event.getType());
						emitter.send(event.getType() + " - " + event.getCreatedAt(), MediaType.TEXT_PLAIN);
					} catch (Exception e) {
						e.printStackTrace();
						emitter.completeWithError(e);
						return;

					}
				}

				@Override
				public boolean onException(Throwable arg0) {
					// TODO Auto-generated method stub
					logger.info("Exception in event controller");
					return false;
				}

				@Override
				public void onNextPosition(long arg0) {
					// TODO Auto-generated method stub
					logger.info("Stream next position "+arg0);
				}
			});
			stream.start();
			// emitter.complete();
		});

		return emitter;
	}

}
