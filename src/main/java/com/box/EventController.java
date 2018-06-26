package com.box;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxEvent;
import com.box.sdk.EventListener;
import com.box.sdk.EventStream;
import com.box.util.BoxConnections;

import reactor.core.publisher.Flux;

@Controller
public class EventController {
	
    class XDto{
        final int x;
        public XDto(int x) {this.x = x;}
    }

    Stream<XDto> produceX(){
        return IntStream.range(1,10).mapToObj(i -> {
            System.out.println("produce "+i);
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            return new XDto(i);
        });
    }

    /*
	@GetMapping(path = "/events", produces = "text/event-stream")
		Flux<XDto> getEvents()	{
		System.out.println("Events ..");
			return Flux.fromStream(produceX());

		}*/
	
    /*
	@RequestMapping("/sseTest")
    public ResponseBodyEmitter handleRequest () {

        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    emitter.send(LocalTime.now().toString() , MediaType.TEXT_PLAIN);

                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
    }*/
    
    
	
	@RequestMapping("/events")
    public ResponseBodyEmitter handleRequest () {
		System.out.println("Events controller -- ");
        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
        	
        	BoxDeveloperEditionAPIConnection api = BoxConnections.getServiceAccountConnection();
        	EventStream stream = new EventStream(api);
        	stream.addListener(new EventListener() {
        	    public void onEvent(BoxEvent event) {
        	        // Handle the event.
                    try {
                    	System.out.println("--on event -- "+event.getType());
        	    	emitter.send(event.getType()+ " - " +event.getCreatedAt() , MediaType.TEXT_PLAIN);
                    }catch(Exception e)	{
                        e.printStackTrace();
                        emitter.completeWithError(e);
                        return;

                    }
        	    }

				@Override
				public boolean onException(Throwable arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void onNextPosition(long arg0) {
					// TODO Auto-generated method stub
					
				}
        	});
        	stream.start();
            //emitter.complete();
        });

        return emitter;
    } 
	

}
